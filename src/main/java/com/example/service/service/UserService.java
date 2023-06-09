package com.example.service.service;

import com.example.service.entity.User;
import com.example.service.exception.BaseException;
import com.example.service.exception.UserException;
import com.example.service.mapper.UserMapper;
import com.example.service.model.LoginDto;
import com.example.service.model.MRegisterRequest;
import com.example.service.model.MRegisterResponse;
import com.example.service.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository repository;



    private PasswordEncoder passwordEncoder;

     public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
         this.passwordEncoder = passwordEncoder;
     }

     public Optional<User>  findByEmail(String email) {
         return  repository.findByEmail(email);
     }

     public boolean matchPassword(String rawPassword, String encodedPassword) {
       return passwordEncoder.matches(rawPassword, encodedPassword);
     }

     public  String login(LoginDto requestDto) throws BaseException {
         // validate request


         // verify database
        Optional<User> opt = repository.findByEmail(requestDto.getEmail());

        if (opt.isEmpty()) {
            // throw Login fail, email not found
            throw UserException.loginFailEmailNotFound();
        }

        User user = opt.get();
        if (!this.matchPassword(requestDto.getPassword(), user.getPassword())) {
            // throw login fail, password incorrect
            throw UserException.loginFailPasswordIncorrect();
        }

        // TODO: gernerate JWT
        String token = "JWT TO DO";
        return  token;
     }

     public User register(MRegisterRequest dto) throws BaseException {
         // validate
         if (Objects.isNull(dto.getEmail())) {
             throw UserException.createEmailNull();
         }

         if (Objects.isNull(dto.getPassword())) {
             throw UserException.createPasswordNull();

         }

         if (Objects.isNull(dto.getName())) {
             throw UserException.createNameNull();

         }
        // verify
        if (repository.existsByEmail(dto.getEmail())) {
            throw  UserException.createEmailDuplicate();
         }


         //save
        User entity = new User();
        entity.setEmail(dto.getEmail());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setName(dto.getName());

        return repository.save(entity);
     }
}

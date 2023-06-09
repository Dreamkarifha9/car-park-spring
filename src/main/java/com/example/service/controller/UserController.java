package com.example.service.controller;

import com.example.service.entity.User;
import com.example.service.exception.BaseException;
import com.example.service.mapper.UserMapper;
import com.example.service.model.LoginDto;
import com.example.service.model.MRegisterRequest;
import com.example.service.model.MRegisterResponse;

import com.example.service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userServices;
    private  final UserMapper userMapper;
    public UserController(UserService userServices, UserMapper userMapper) {
        this.userServices = userServices;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public  ResponseEntity<String> login(@RequestBody LoginDto requestDto) throws BaseException {
        String response = userServices.login(requestDto);
        return  ResponseEntity.ok(response);
    }
    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<MRegisterResponse> register(@RequestBody MRegisterRequest request) throws BaseException {
        User response = userServices.register(request);
        System.out.println(response);
       MRegisterResponse model = userMapper.toRegisterResponse(response);
        return ResponseEntity.ok(model);
    }


}

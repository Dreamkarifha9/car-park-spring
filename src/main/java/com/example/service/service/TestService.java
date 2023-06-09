package com.example.service.service;

import com.example.service.exception.FileException;
import com.example.service.exception.UserException;
import com.example.service.model.MRegisterRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TestService {
    public String register(MRegisterRequest request) throws UserException {
        if (request == null) {
            throw UserException.requestNull();
        }

        // validate email
        if (Objects.isNull(request.getEmail())) {
            throw UserException.emailNull();
        }
            return  "";
    }

    public String uploadPicture(MultipartFile file) throws FileException {
        if (file == null) {
           throw  FileException.fileNull();
        }
        if(file.getSize() > 1048576 * 2) {
            throw  FileException.fileMaxSize();
        }

       String contentType = file.getContentType();
        if(contentType == null) {
            throw FileException.unsupported();
        }
        List<String> supportType = Arrays.asList("image/jpeg", "image/png");
        if(!supportType.contains(contentType)) {
            throw FileException.unsupported();
        }

        try {
            byte[] bytes = file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  "";
    }
}

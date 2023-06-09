package com.example.service.mapper;

import com.example.service.entity.User;
import com.example.service.model.MRegisterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    MRegisterResponse toRegisterResponse(User user);
}

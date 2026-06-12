package com.example.demo.services;


import com.example.demo.dto.AddPostRequestDto;
import com.example.demo.dto.UserNdAddressUpdateDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entities.UserEntity;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    String saveUser(UserRequestDto userRequestDto);

    List<UserResponseDto> getAllUsers();

    List<String> fetchAll();

    String updateUser(@Valid UserNdAddressUpdateDto userNdAddressUpdateDto);

    String createPost(AddPostRequestDto dto);
}

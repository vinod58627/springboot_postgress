package com.example.demo.controllers;

import com.example.demo.dto.AddPostRequestDto;
import com.example.demo.dto.UserNdAddressUpdateDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public String saveNewUser(@Valid @RequestBody UserRequestDto userRequestDto) {

        var message = userService.saveUser(userRequestDto);
        return message;
    }

    @GetMapping("/getUsers")
    public List<UserResponseDto> getAllUser() {

        List<UserResponseDto> message = userService.getAllUsers();
        return message;
    }

    @GetMapping(value = "/fetchAll")
    public List<String> fetchAll() {
        return userService.fetchAll();
    }

    @PutMapping(value = "/updateUser")
    public String fetchAll(@Valid @RequestBody UserNdAddressUpdateDto userNdAddressUpdateDto) {
        return userService.updateUser(userNdAddressUpdateDto);
    }

    @PostMapping("/addPost")
    public String addNewImage(@Valid @RequestBody AddPostRequestDto dto) {
        var str = userService.createPost(dto);
        return str;

    }

}

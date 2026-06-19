package com.example.demo.services;

import com.example.demo.dto.EntityManagerUpdateDto;
import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.dto.OneToOneResponseDto;
import com.example.demo.entities.OneToOneEntity;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

public interface EntityManagerService {
    String saveNewUser(@Valid OneToOneRequestDto otpd);

    String updateUser(@Valid EntityManagerUpdateDto otpd);

    String updateEmail(Integer id, String email);

    List<OneToOneEntity> getAllUsers();

    List<Map<String, Object>> getAllUsersWithNativeQuery();
}

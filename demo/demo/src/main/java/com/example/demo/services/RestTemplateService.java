package com.example.demo.services;

import com.example.demo.dto.OneToOneRequestDto;

import java.util.List;

public interface RestTemplateService {
    List<OneToOneRequestDto> getAllEmployees();
}

package com.example.demo.services;

import com.example.demo.dto.AddPageRequestDto;
import com.example.demo.dto.PageAllResponseDto;
import com.example.demo.entities.PageEntity;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PageService {

    List<PageAllResponseDto> getAll();

    String newRecord(@Valid AddPageRequestDto dto);

    Page<PageEntity> allGet(Integer pageNo);
}

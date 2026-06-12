package com.example.demo.services;

import com.example.demo.dto.OneToManySaveDto;
import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.dto.OneToOneResponseDto;
import com.example.demo.dto.UpdatePinMobileRequestDto;
import jakarta.validation.Valid;

import java.util.List;

public interface OneToOneService {

    String oneToOneSave(@Valid OneToOneRequestDto user);

    List<OneToOneRequestDto> oneToOneGet();

    List<OneToOneResponseDto> getFromQuery();

    String updatePinNdMobile(@Valid UpdatePinMobileRequestDto dto);

    //One To Many Service
    String saveOtm(@Valid OneToManySaveDto otmDto);
}

package com.example.demo.services;

import com.example.demo.dto.DemoPsDto;
import com.example.demo.entities.DemoPsEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DemoPsService {
    public List<DemoPsEntity> getAllData();

    public DemoPsDto saveNewRe(@Valid @RequestBody DemoPsDto demoPsDto);

    public DemoPsDto getByMail(String mail);

    public List<DemoPsDto> getByLoc(String mail);
}

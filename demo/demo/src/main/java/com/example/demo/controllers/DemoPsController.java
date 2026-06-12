package com.example.demo.controllers;

import com.example.demo.dto.DemoPsDto;
import com.example.demo.entities.DemoPsEntity;
import com.example.demo.services.DemoPsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demops")
public class DemoPsController {
    @Autowired
    private DemoPsService demoPsService;

    @GetMapping("/psget")
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/getData")
    public List<DemoPsEntity> getAll() {

        return demoPsService.getAllData();
    }

    @PostMapping("/saveRecord")
    public ResponseEntity<DemoPsDto> saveNewRecord(@Valid @RequestBody DemoPsDto demoPsDto) {
        DemoPsDto str = demoPsService.saveNewRe(demoPsDto);
        return ResponseEntity.ok(str);

    }

    @GetMapping("/getByEmail/{mail}")
    public ResponseEntity<DemoPsDto> getData (@PathVariable String mail){
        DemoPsDto dtp = demoPsService.getByMail(mail);

        return ResponseEntity.ok(dtp);
    }
    @GetMapping("/getByLoc/{mail}")
    public ResponseEntity<List<DemoPsDto>> getByLoc (@PathVariable String mail){
        List<DemoPsDto> dtp = demoPsService.getByLoc(mail);

        return ResponseEntity.ok(dtp);
    }
}

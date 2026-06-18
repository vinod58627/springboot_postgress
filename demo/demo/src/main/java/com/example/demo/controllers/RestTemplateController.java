package com.example.demo.controllers;

import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.services.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplateService rts;

    @GetMapping("/getUser")
    public Object getUser(){
        String url = "https://jsonplaceholder.typicode.com/users/2";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<OneToOneRequestDto>> getAllEmployees(){
        List<OneToOneRequestDto> message = rts.getAllEmployees();
        return ResponseEntity.ok().body(message);
    }

}

package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUser")
    public Object getUser(){
        String url = "https://jsonplaceholder.typicode.com/users/2";
        return restTemplate.getForObject(url, Object.class);
    }
}

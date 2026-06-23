package com.example.demo.controllers;

import com.example.demo.services.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapper")
public class ModelMapperController {

    @Autowired
    private ModelMapperService mms;



}

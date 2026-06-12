package com.example.demo.controllers;

import com.example.demo.services.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controllerNdService")
public class DemoServiceController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/csGet")
    public String csGetMap(){
        String msg = demoService.getUser();
        return msg;
    }
    @GetMapping("/csCheckName/{name}")
    public String csGetName(@PathVariable String name){
        String msg = demoService.getUserName(name);
        return msg;
    }
}

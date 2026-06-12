package com.example.demo.serviceImpls;

import com.example.demo.services.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    public String getUser(){
        return "Successfullyh Connected";
    }

    public String getUserName(String name){
        return "Vinod " + name;
    }
}

package com.example.demo.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DemoDto {

    //We should add
    @NotNull(message = "Id is required")
    private Integer id;

    @NotBlank(message = "Name should not be empty")
    private String name;
    @NotBlank(message = "Email should not be empty")
    private String email;
    @NotBlank(message = "location should not be empty")
    private String location;
    /*
    Ip: {}
    Op: {"id": null, "name": null,"email": null,"location": null}
    without setter and getter methods you can not access values
    @Data: Instead of manually writing:
        getters
        setters
        toString()
        equals()
        hashCode()
     */
    /*
    For Validation This Dependency should add
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
     */
    /*
    IP: {
    "id": 1,
    "name": "Vinod",
    "email": "",
    "location": ""
    }
    Op: {
        "timestamp": "2026-05-12T10:14:26.465+00:00",
        "status": 400,
        "error": "Bad Request",
        "message": "Validation failed for object='demoDto'. Error count: 2",
        "path": "/demo/checkDto"
    }
    @NotBlank should not accept null , empty values and " space "
     */
}

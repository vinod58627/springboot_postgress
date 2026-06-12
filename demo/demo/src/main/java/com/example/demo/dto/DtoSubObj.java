package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DtoSubObj {
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "House number is required")
    private String hno;
    @NotBlank(message = "District is required")
    private String dist;

}

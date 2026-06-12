package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParentAddressRequestDto {

    @NotBlank
    private String houseNo;

    @NotBlank
    private String street;

    @NotBlank
    private String distName;

    @NotNull
    private Integer pinCode;
}

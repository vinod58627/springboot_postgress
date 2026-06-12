package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ParentChildRequestDto {
    @NotBlank
    private String name;

    @Email
    private String email;

    @Valid
    private ParentAddressRequestDto parentAddress;
}

package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DtoMainObj {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Mobile is required")
    private Integer num;

    @Valid
    @NotNull(message = "Address details are required")
    private DtoSubObj address;
}


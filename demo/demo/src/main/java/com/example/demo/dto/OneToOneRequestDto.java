package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record OneToOneRequestDto(
        Integer id,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        String email,

        @NotNull(message = "Age is required")
        Integer age,

        @NotNull(message = "PinCode is required")
        Integer pinCode,

        @NotBlank(message = "Name is required")
        String nationality,

        @Valid
        @NotNull(message = "Family details are required")
        OneToOneRequestChildDto family

) {
    public record OneToOneRequestChildDto(
            Integer sno,

            @NotBlank(message = "Father Name is required")
            String fatherName,

            @NotBlank(message = "Mother Name is required")
            String motherName,

            @NotBlank(message = "Mobile is required")
            @Pattern(
                    regexp = "^[0-9]{10}$",
                    message = "Mobile must contain exactly 10 digits"
            )
            String mobile
    ) {
    }
}

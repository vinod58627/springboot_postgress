package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EntityManagerUpdateDto(
        @NotNull
        Integer id,

        @NotBlank
        String userName,

        @NotNull
        Integer pinCode,

        @NotBlank
        String mobile
) {
}

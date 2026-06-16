package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddPageRequestDto(

        Integer id,

        @NotEmpty
        String name,

        @Email
        @NotEmpty
        String email,

        @NotNull
        Long salary,

        @NotNull
        Integer empId,

        String branch
) {
}

package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OneToManySaveDto(

        @NotNull
        Integer userId,

        @NotBlank(message = "Name is Required")
        String name,
        @NotBlank(message = "Email is Required")
        String email,

        @NotBlank(message = "Phone is Required")
        String mobileNumber,

        @NotEmpty(message = "At least one qualification is required")
        @Valid
        List<OneToManyChildDto> qualification

) {
    public record OneToManyChildDto(
            @NotBlank(message = "Course is Required")
            String course,
            @NotBlank(message = "Year is Required")
            String year,
            @NotNull(message = "Percentage is Required")
            Integer percentage
    ) {

    }
}

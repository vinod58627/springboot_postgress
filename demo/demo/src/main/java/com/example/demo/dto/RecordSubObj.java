package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record RecordSubObj(
        @NotBlank(message = "Street is required")
        String street,

        @NotBlank(message = "House number is required")
        String hno,

        @NotBlank(message = "District is required")
        String district

) {
}

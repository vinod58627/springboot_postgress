package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdatePinMobileRequestDto(
        @NotNull
        Integer id,

        @NotNull
        Integer pin,

        @NotNull
        @Pattern(
                regexp = "^[0-9]{10}$",
                message = "Mobile must contain exactly 10 digits"
        )
        String mobile,

        @NotBlank
        String fatherName
) {
}

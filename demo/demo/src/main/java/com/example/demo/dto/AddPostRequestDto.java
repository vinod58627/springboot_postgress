package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record AddPostRequestDto(
        @NotBlank(message = "Image is Requires")
        String imgUrl,

        boolean isAlive
) {
}

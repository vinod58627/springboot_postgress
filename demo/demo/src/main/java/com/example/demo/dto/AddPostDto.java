package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record AddPostDto(
        @NotBlank(message = "Image should Not be Empty")
        String imgPath
) {
}

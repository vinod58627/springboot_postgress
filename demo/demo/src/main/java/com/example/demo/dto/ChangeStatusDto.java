package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public record ChangeStatusDto(
        @NotNull(message = "Id is required")
        Integer id,

        @NotNull(message = "Status is required")
        Boolean isAlive
) {
}

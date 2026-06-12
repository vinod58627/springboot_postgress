package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public record ChangeOrderDto(
        @NotNull
        Integer id,

        @NotNull
        Integer newOrder
) {
}

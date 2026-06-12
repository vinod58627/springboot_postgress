package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoPsDto {

    private Integer id;

    @NotEmpty(message = "Name Should not Empty")
    private String name;

    @NotEmpty(message = "Email Should not Empty")
    private String email;

    @NotNull(message = "Gender Should not Empty")
    private Boolean isAdult;

    @NotNull(message = "Age Should not Empty")
    private Integer age;

    @NotNull(message = "Mobile")
    private Long mobile;

    private String location;
}

package com.example.demo.dto;

public record OneToOneResponseRecordDto(
        Integer id,
        String name,
        Integer age,
        String email,
        String fatherName,
        String motherName,
        String mobile
) {
}

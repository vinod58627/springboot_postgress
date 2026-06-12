package com.example.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record UserRequestDto(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        String email,

        @NotNull(message = "Age should not null")
        Integer age,

        String location,

        @NotNull(message = "mobile Required")
        Long phone,

        @Valid
        AddressDto address,

        @Valid
        List<FamilyMemberDto> familyMembers

) {
    public record AddressDto(

            @NotBlank(message = "Street is required")
            String street,

            @NotBlank(message = "House number is required")
            String hno,

            @NotBlank(message = "District is required")
            String district,


            @NotNull(message = "Pin is required")
            Long pinCode
    ) {
    }

    public record FamilyMemberDto(

            @NotBlank(message = "Member name required")
            String memberName,

            @NotNull(message = "Age required")
            Integer age,

            @NotBlank(message = "Relation required")
            String relationName,

            @NotNull(message = "Mobile no Requires")
            Long mobile

    ) {
    }

}

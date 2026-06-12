package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserNdAddressUpdateDto {

    @NotNull(message = "User Missing")
    private Integer userId;

    @NotBlank(message = "Location is missing")
    private String location;

    @NotNull(message = "Phone number missing")
    private Long phone;

    @NotBlank(message = "Street Missing")
    private String street;

    @NotBlank(message = "House no missing")
    private String houseNo;

}

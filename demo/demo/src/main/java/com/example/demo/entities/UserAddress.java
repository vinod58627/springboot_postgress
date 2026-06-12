package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(schema = "sprbt", name = "user_address")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer addId;

    @NotEmpty
    @Column(name = "house_no")
    private String hNo;

    private String district;

    @Column(name = "pin_Code")
    private Long pinCode;

    private String street;

   /* @JsonIgnore
    @OneToOne(mappedBy = "address")
    UserEntity userEntity;*/

}

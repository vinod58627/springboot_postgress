package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(schema = "sprbt", name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Name should not Empty")
    private String userName;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "Email should not Empty")
    private String email;

    @NotNull(message = "Age should not null")
    private Integer age;

    private String location;

    @NotNull(message = "Mobile Requires")
    private Long phone;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private UserAddress address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<UserFamilyEntity> familyMembers;


}

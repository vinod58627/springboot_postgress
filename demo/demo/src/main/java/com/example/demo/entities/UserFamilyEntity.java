package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(schema = "sprbt", name = "family_details")
public class UserFamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Name Required")
    private String name;

    @NotEmpty(message = "Relation Required")
    private String relation;

    @NotNull(message = "Age Required")
    private Integer age;

    @NotNull(message = "Mobile no Requires")
    private Long mobile;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private UserEntity user;

}

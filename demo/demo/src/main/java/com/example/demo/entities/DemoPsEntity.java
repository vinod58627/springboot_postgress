package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="demo")
public class DemoPsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer psId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean isAdult;

    private Integer age;

    @Column(unique = true)
    private Long mobile;

    private String location;

}

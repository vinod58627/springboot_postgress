package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "sprbt", name = "one_to_one")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneToOneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    private Integer age;

    private Integer pincode;

    private String nationality;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_sno", referencedColumnName = "sno")
    private OneToOneChild family;


}

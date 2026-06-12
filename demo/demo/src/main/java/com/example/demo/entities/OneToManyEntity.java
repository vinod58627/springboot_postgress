package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(schema = "sprbt", name = "one_to_many")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneToManyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slNo;

    private String name;

    private String email;

    private String mobile;

    @Column(name = "user_id")
    private Integer userId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "study_id")
    private List<OneToManyChildEntity> study;

}

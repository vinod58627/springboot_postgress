package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "sprbt", name = "one_to_many_child")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneToManyChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String course;

    private String year;

    private Integer percentage;

}

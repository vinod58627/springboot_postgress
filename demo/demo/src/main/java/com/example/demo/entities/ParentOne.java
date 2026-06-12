package com.example.demo.entities;

import com.example.demo.common.CommonColumns;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "sprbt", name = "parent_one")
@Data
public class ParentOne extends CommonColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer userId;

    private String email;

    private Integer age;

    private Long mobile;

}

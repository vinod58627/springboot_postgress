package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "sprbt", name = "one_to_one_child")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OneToOneChild {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_seq")
    @SequenceGenerator(
            name = "child_seq",
            sequenceName = "child_seq",
            allocationSize = 1
    )
    private Integer sno;

    private String fatherName;

    private String motherName;

    private String mobile;


}

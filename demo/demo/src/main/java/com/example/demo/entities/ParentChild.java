package com.example.demo.entities;

import com.example.demo.common.CommonColumns;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "sprbt", name = "parent_child")
@Data
public class ParentChild extends CommonColumns {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_address_id", unique = true)
    private ParentAddress parentAddress;

}

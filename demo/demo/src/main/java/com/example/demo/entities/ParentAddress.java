package com.example.demo.entities;

import com.example.demo.common.CommonColumns;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "sprbt", name = "parent_address")
public class ParentAddress extends CommonColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String houseNo;

    private String street;

    private String distName;

    private Integer pinCode;
}

package com.example.demo.entities;

import com.example.demo.common.CommonColumns;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "sprbt", name = "page_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageEntity extends CommonColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer slNo;

    private String name;

    private String email;

    private Long salary;

    @Column(name = "emp_id", unique = true)
    private Integer empId;

    private String branch;


}

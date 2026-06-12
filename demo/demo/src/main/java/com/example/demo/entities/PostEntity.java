package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(schema = "sprbt", name = "homepage_gallery")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "Image Should NOt be Empty")
    @Column(unique = true)
    private String imgPath;

    @Column(name = "match_order")
    private Integer matchOrder;

    @NotNull(message = "Is Alive is Required")
    private boolean isAlive;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    private String createdAt;

}

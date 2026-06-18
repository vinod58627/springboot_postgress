package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(schema = "sprbt", name = "one_to_many")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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

    @CreatedDate
    private LocalDateTime createdDate;

    @CreatedBy
    private String createdBy = "14458110";

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @LastModifiedBy
    private String updatedBy ="14442166";

}

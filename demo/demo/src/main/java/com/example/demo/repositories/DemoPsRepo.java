package com.example.demo.repositories;

import com.example.demo.entities.DemoPsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemoPsRepo extends JpaRepository<DemoPsEntity , Integer> {

    DemoPsEntity findByEmail(String email);

    List<DemoPsEntity> findByLocation(String email);
}

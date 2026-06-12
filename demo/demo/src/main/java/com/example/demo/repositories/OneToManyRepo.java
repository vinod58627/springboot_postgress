package com.example.demo.repositories;

import com.example.demo.entities.OneToManyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToManyRepo extends JpaRepository<OneToManyEntity, Integer> {
}

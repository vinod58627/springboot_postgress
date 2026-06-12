package com.example.demo.repositories;

import com.example.demo.entities.ParentChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentChildRepo extends JpaRepository<ParentChild, Integer> {
}

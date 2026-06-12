package com.example.demo.repositories;

import com.example.demo.entities.ParentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentAddressRepo extends JpaRepository<ParentAddress, Integer> {
}

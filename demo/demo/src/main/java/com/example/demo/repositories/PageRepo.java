package com.example.demo.repositories;

import com.example.demo.dto.PageAllResponseDto;
import com.example.demo.entities.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepo extends JpaRepository<PageEntity, Integer> {
    PageEntity findByEmpId(Integer empId);

    @Query(nativeQuery = true, value = """
            select sl_no as slNo, name,email, branch, emp_id as empId,salary , any_type as anyType from sprbt.page_table
            """)
    List<PageAllResponseDto> getAll();

}

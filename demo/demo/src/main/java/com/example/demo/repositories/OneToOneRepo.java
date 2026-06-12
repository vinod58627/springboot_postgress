package com.example.demo.repositories;

import com.example.demo.dto.OneToOneResponseDto;
import com.example.demo.entities.OneToOneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OneToOneRepo extends JpaRepository<OneToOneEntity, Integer> {

    @Query(nativeQuery = true, value = """
            select oto.id as id, oto.name as name, oto.age as age, oto.email as email, otoc.father_name as fatherName, otoc.mother_name as motherName, otoc.mobile as mobile from sprbt.one_to_one oto left join sprbt.one_to_one_child otoc  on oto.c_sno =otoc.sno;
            """)
    List<OneToOneResponseDto> dataFromQuery();
}

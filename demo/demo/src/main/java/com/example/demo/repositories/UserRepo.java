package com.example.demo.repositories;

import com.example.demo.dto.UserResponseDto;
import com.example.demo.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query(value = """
            select
            u.id as uid,
            u.user_name as name,
            u.email,
            u.age,
            u.phone as mobile,
            ua.house_no ,
            ua.id as addId,
            ua.district,
            ua.pin_code
            from sprbt.users u
            join sprbt.user_address ua
            on u.address_id = ua.id
            """, nativeQuery = true)
    List<UserResponseDto> getAllUsers();

    @Query(value = "select email from UserEntity us")
    List<String> fetchAll();
}

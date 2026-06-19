package com.example.demo.controllers;

import com.example.demo.dto.EntityManagerUpdateDto;
import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.dto.OneToOneResponseDto;
import com.example.demo.entities.OneToOneEntity;
import com.example.demo.services.EntityManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity")
public class EntityManagerController {

    @Autowired
    private EntityManagerService entSer;

    @PostMapping("/post")
    public ResponseEntity<String> saveNewUser(@Valid @RequestBody OneToOneRequestDto otpd){
        String message = entSer.saveNewUser(otpd);
        return ResponseEntity.ok().body(message);
    }

    @PatchMapping("/updateNameNationality")
    public ResponseEntity<String> updateNameNationality(@Valid @RequestBody EntityManagerUpdateDto emud){
        String message = entSer.updateUser(emud);
        return ResponseEntity.ok().body(message);
    }

    @PatchMapping("/dynamicQuery/{id}/{email}")
    public  ResponseEntity<String> dynamicQuery(@PathVariable Integer id,
                                                @PathVariable String email){
        String message = entSer.updateEmail(id, email);
        return  ResponseEntity.ok().body(message);
    }
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<OneToOneEntity>> matchEmployees(){
        List<OneToOneEntity> users = entSer.getAllUsers();
        return ResponseEntity.ok().body(users);
    }
    @GetMapping("/getEmpNativeQuery")
    public ResponseEntity<List<Map<String, Object>>> matchNativeQuery(){
        List<Map<String, Object>> users = entSer.getAllUsersWithNativeQuery();
        return ResponseEntity.ok().body(users);
    }
}

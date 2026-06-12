package com.example.demo.controllers;

import com.example.demo.dto.ParentChildRequestDto;
import com.example.demo.services.ParentChildService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class ParentChildController {


    @Autowired
    private ParentChildService parentChildService;

    @PostMapping("/newparent")
    public ResponseEntity<?> addNewParent(@Valid @RequestBody ParentChildRequestDto pcr) {
        String Message = parentChildService.saveParent(pcr);
        return ResponseEntity.ok(Message);
    }
}

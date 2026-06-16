package com.example.demo.controllers;

import com.example.demo.dto.AddPageRequestDto;
import com.example.demo.dto.PageAllResponseDto;
import com.example.demo.entities.PageEntity;
import com.example.demo.services.PageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PaginationController {

    @Autowired
    private PageService pageService;

    @GetMapping("/all")
    public ResponseEntity<List<PageAllResponseDto>> getAll() {
        List<PageAllResponseDto> users = pageService.getAll();
        return ResponseEntity.ok().body(users);
    }
    @GetMapping("/getAll/{pageNo}")
    public ResponseEntity<Page<PageEntity>> allGet(@PathVariable Integer pageNo) {
        Page<PageEntity> users = pageService.allGet(pageNo);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping("/newRecord")
    public ResponseEntity<String> addNewRecord(@Valid @RequestBody AddPageRequestDto dto) {
        String users = pageService.newRecord(dto);
        return ResponseEntity.ok().body(users);
    }
}

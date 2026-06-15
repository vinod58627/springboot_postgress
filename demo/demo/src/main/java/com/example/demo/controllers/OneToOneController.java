package com.example.demo.controllers;

import com.example.demo.dto.OneToManySaveDto;
import com.example.demo.dto.OneToOneRequestDto;
import com.example.demo.dto.OneToOneResponseDto;
import com.example.demo.dto.UpdatePinMobileRequestDto;
import com.example.demo.services.OneToOneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


import java.util.List;

@RestController
@RequestMapping("/checkoto")
public class OneToOneController {
    private static final Logger logger = Logger.getLogger(OneToOneController.class.getName());
    @Autowired
    private OneToOneService oneToOneService;

    @PostMapping("/saveOto")
    public ResponseEntity<String> savePost(@Valid @RequestBody OneToOneRequestDto user) {
        String msg = oneToOneService.oneToOneSave(user);
        return ResponseEntity.ok().body(msg);

    }

    @GetMapping("/getoto")
    public ResponseEntity<List<OneToOneRequestDto>> getAll() {
        List<OneToOneRequestDto> users = oneToOneService.oneToOneGet();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/getFromQuery")
    public ResponseEntity<List<OneToOneResponseDto>> getFromQuery() {
        List<OneToOneResponseDto> users = oneToOneService.getFromQuery();

        return ResponseEntity.ok().body(users);
    }

    @PatchMapping("/updatePinMobile")
    public ResponseEntity<String> updatePinNdMobile(@Valid @RequestBody UpdatePinMobileRequestDto dto) {
        String msg = oneToOneService.updatePinNdMobile(dto);
        return ResponseEntity.ok().body(msg);
    }

    //One To Many Controller

    @PostMapping("/checkOtm")
    public ResponseEntity<String> saveOneToMany(@Valid @RequestBody OneToManySaveDto otmDto) {
        String msg = oneToOneService.saveOtm(otmDto);
        return ResponseEntity.ok().body(msg);
    }

    @RequestMapping("/profile")
    public String userProfile(Model model) {
        model.addAttribute("username", "JohnDoe");
        logger.info("Vinod Is Calling Logger");
        return "profile";
    }

    @GetMapping("/check/{a}divide{b}")
    public String checkPath(@PathVariable Integer a, @PathVariable Integer b) {
        Integer c = a + b;
        return "The Total is " + c;
    }

}

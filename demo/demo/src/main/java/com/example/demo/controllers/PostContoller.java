package com.example.demo.controllers;

import com.example.demo.dto.AddPostDto;
import com.example.demo.dto.ChangeOrderDto;
import com.example.demo.dto.ChangeStatusDto;
import com.example.demo.dto.GalleryResonseDto;
import com.example.demo.services.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery")
@RequiredArgsConstructor
public class PostContoller {

    @Autowired
    private PostService postService;

    @PostMapping("/addImage")
    public ResponseEntity<String> addPost(@Valid @RequestBody AddPostDto addPostDto) {
        String msg = postService.addImg(addPostDto);

        return ResponseEntity.ok(msg);
    }

    @PutMapping("/changeStatus")
    public ResponseEntity<String> changeStatus(
            @Valid @RequestBody ChangeStatusDto dto
    ) {

        return ResponseEntity.ok(
                postService.changeStatus(dto)
        );
    }

    @PutMapping("/changeOrder")
    public ResponseEntity<String> changeOrder(
            @Valid @RequestBody ChangeOrderDto dto
    ) {

        return ResponseEntity.ok(
                postService.changeOrder(dto)
        );
    }
    @GetMapping("/allGallery")
    public ResponseEntity<List<GalleryResonseDto>> getAll(){
        var allImages = postService.getAllImages();
        return ResponseEntity.ok(allImages);
    }

}

package com.example.demo.services;

import com.example.demo.dto.AddPostDto;
import com.example.demo.dto.ChangeOrderDto;
import com.example.demo.dto.ChangeStatusDto;
import com.example.demo.dto.GalleryResonseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface PostService {
    String addImg(AddPostDto addPostDto);

    String changeStatus(@Valid ChangeStatusDto changeStatusDto);

    String changeOrder(ChangeOrderDto dto);

    List<GalleryResonseDto> getAllImages();
}

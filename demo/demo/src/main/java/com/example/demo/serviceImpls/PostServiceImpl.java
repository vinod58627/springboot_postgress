package com.example.demo.serviceImpls;

import com.example.demo.dto.*;
import com.example.demo.entities.PostEntity;
import com.example.demo.repositories.PostRepo;
import com.example.demo.services.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Override
    @Transactional
    public String addImg(AddPostDto addPostDto) {
        try {
            System.out.println(addPostDto);
            postRepo.incrementDisplayOrders();
            PostEntity post = new PostEntity();
            post.setImgPath(addPostDto.imgPath());
            post.setMatchOrder(1);
            post.setAlive(true);
            post.setCreatedAt(String.valueOf(LocalDateTime.now()));
            post.setCreatedBy(14458110);
            postRepo.save(post);
            return "Image Posted Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    @Transactional
    public String changeStatus(ChangeStatusDto dto) {

        PostEntity post = postRepo.findById(dto.id())
                .orElseThrow(() ->
                        new RuntimeException("Image Not Found"));

        // TRUE -> FALSE
        if (post.isAlive() && !dto.isAlive()) {

            Integer currentOrder = post.getMatchOrder();

            // Shift remaining
            postRepo.shiftAfterDelete(currentOrder);

            post.setAlive(false);

            // Remove order
            post.setMatchOrder(null);
        }

        // FALSE -> TRUE
        else if (!post.isAlive() && dto.isAlive()) {

            Integer maxOrder = postRepo.getMaxOrder();

            post.setAlive(true);

            // Add at last
            post.setMatchOrder(maxOrder + 1);
        }

        postRepo.save(post);

        return "Status Changed Successfully";
    }

    @Override
    @Transactional
    public String changeOrder(ChangeOrderDto dto) {

        PostEntity post = postRepo.findById(dto.id())
                .orElseThrow(() ->
                        new RuntimeException("Image Not Found"));

        Integer newOrder = dto.newOrder();

        Integer oldOrder = post.getMatchOrder();

        // ==========================
        // CASE 1: INACTIVE IMAGE
        // ==========================
        if (oldOrder == null) {

            // Shift existing images down
            postRepo.shiftDown(Integer.MAX_VALUE, newOrder);

            // Activate image
            post.setAlive(true);

            // Insert into requested order
            post.setMatchOrder(newOrder);

            postRepo.save(post);

            return "Inactive Image Activated and Reordered";
        }

        // ==========================
        // CASE 2: MOVE DOWN
        // ==========================
        if (oldOrder < newOrder) {

            postRepo.shiftUp(oldOrder, newOrder);
        }

        // ==========================
        // CASE 3: MOVE UP
        // ==========================
        else if (oldOrder > newOrder) {

            postRepo.shiftDown(oldOrder, newOrder);
        }

        post.setMatchOrder(newOrder);

        postRepo.save(post);

        return "Order Changed Successfully";
    }

//    @Override
//    @Transactional
//    public String changeOrder(ChangeOrderDto dto) {
//
//        PostEntity post = postRepo.findById(dto.id())
//                .orElseThrow(() ->
//                        new RuntimeException("Image Not Found"));
//
//        Integer oldOrder = post.getMatchOrder();
//
//        Integer newOrder = dto.newOrder();
//
//        // Move Down
//        if (oldOrder < newOrder) {
//
//            postRepo.shiftUp(oldOrder, newOrder);
//        }
//
//        // Move Up
//        else if (oldOrder > newOrder) {
//
//            postRepo.shiftDown(oldOrder, newOrder);
//        }
//
//        post.setMatchOrder(newOrder);
//
//        postRepo.save(post);
//
//        return "Order Changed Successfully";
//    }

    @Override
    public List<GalleryResonseDto> getAllImages() {
        return postRepo.fetchAllImages();

    }
}

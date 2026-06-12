package com.example.demo.repositories;

import com.example.demo.dto.GalleryResonseDto;
import com.example.demo.entities.PostEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE PostEntity p SET p.matchOrder = p.matchOrder + 1")
    void incrementDisplayOrders();


    // Remove Image Shift
    @Modifying
    @Transactional
    @Query("""
                UPDATE PostEntity p
                SET p.matchOrder = p.matchOrder - 1
                WHERE p.matchOrder > :order
                AND p.isAlive = true
            """)
    void shiftAfterDelete(Integer order);

    // Max Order
    @Query("""
                SELECT COALESCE(MAX(p.matchOrder),0)
                FROM PostEntity p
                WHERE p.isAlive = true
            """)
    Integer getMaxOrder();

    // Move Down
    @Modifying
    @Transactional
    @Query("""
                UPDATE PostEntity p
                SET p.matchOrder = p.matchOrder - 1
                WHERE p.matchOrder > :oldOrder
                AND p.matchOrder <= :newOrder
                AND p.isAlive = true
            """)
    void shiftUp(Integer oldOrder, Integer newOrder);

    // Move Up
    @Modifying
    @Transactional
    @Query("""
                UPDATE PostEntity p
                SET p.matchOrder = p.matchOrder + 1
                WHERE p.matchOrder >= :newOrder
                AND p.matchOrder < :oldOrder
                AND p.isAlive = true
            """)
    void shiftDown(Integer oldOrder, Integer newOrder);

    @Query(value = """
                SELECT 
                    id as id,
                    img_path as imageUrl,
                    match_order as "order",
                    is_alive as active
                FROM sprbt.homepage_gallery
                ORDER BY match_order
            """, nativeQuery = true)
    List<GalleryResonseDto> fetchAllImages();

}

package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    List<VideoEntity> findByNameContainingOrDescriptionContainingAllIgnoreCase(String name, String description);

    List<VideoEntity> findByNameContainingIgnoreCase(String name);

    List<VideoEntity> findByDescriptionContainingIgnoreCase(String description);
}
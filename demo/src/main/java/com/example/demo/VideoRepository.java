package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface VideoRepository extends JpaRepository<VideoEntity, Long> {
    List<VideoEntity> findByNameContainingOrDescriptionContainingAllIgnoreCase(String name, String description);

    List<VideoEntity> findByNameContainingIgnoreCase(String name);

    List<VideoEntity> findByDescriptionContainingIgnoreCase(String description);

    @PreAuthorize("#entity.username == authentication.name")
    @Override
    void delete(VideoEntity entity);
}
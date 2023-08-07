package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ApiController {
    private final VideoService videoService;

    public ApiController(VideoService _VideoService) {
        this.videoService = _VideoService;
    }

    @GetMapping("/api/videos")
    public List<VideoEntity> all() {
        return videoService.getVideos();
    }

    @PostMapping("/api/videos")
    public VideoEntity addVideo(@RequestBody NewVideo newVideo) {
        return videoService.create(newVideo);
    }
}
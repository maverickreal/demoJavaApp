package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ApiController {
    @Autowired
    private VideoService videoService;

    @GetMapping("/api/videos")
    public List<Video> getVideos() {
        return videoService.getVideos();
    }

    @PostMapping("/api/videos")
    public Video addVideo(@RequestBody Video video) {
        videoService.createVideo(video);
        return video;
    }
}
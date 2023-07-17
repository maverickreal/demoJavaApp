package com.example.demo;

import java.util.List;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
class VideoService {
    private List<Video> videos;

    public VideoService() {
        videos = List.of(
                new Video("1"),
                new Video("2"),
                new Video("3"));
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void createVideo(Video video) {
        List<Video> tmp = new ArrayList<>(videos);
        tmp.add(video);
        videos = tmp;
    }
}
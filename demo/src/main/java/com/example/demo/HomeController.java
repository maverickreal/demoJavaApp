package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private static record Video(String name) {
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Video> videos = List.of(
                new Video("Video 1"),
                new Video("Video 2"),
                new Video("Video 3"));
        model.addAttribute("videos", videos);
        return "index";
    }
}
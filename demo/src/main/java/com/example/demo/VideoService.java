package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import jakarta.annotation.PostConstruct;

@Service
public class VideoService {
    @Autowired
    private VideoRepository repository;

    public List<VideoEntity> getVideos() {
        return repository.findAll();
    }

    public VideoEntity create(NewVideo newVideo, String username) {
        return repository.saveAndFlush(new VideoEntity(newVideo.name(), newVideo.description(), username));
    }

    public List<VideoEntity> search(Search search) {
        VideoEntity probe = new VideoEntity();
        if (StringUtils.hasText(search.value())) {
            probe.setName(search.value());
            probe.setDescription(search.value());
        }
        Example<VideoEntity> example = Example.of(probe,
                ExampleMatcher.matchingAny()
                        .withIgnoreCase()
                        .withStringMatcher(StringMatcher.CONTAINING));
        return repository.findAll(example);
    }

    public void delete(Long videoId) {
        repository.findById(videoId)
                .map(videoEntity -> {
                    repository.delete(videoEntity);
                    return true;
                })
                .orElseThrow(() -> new RuntimeException("No video at " + videoId));
    }

    @PostConstruct
    void initDatabase() {
        repository.save(new VideoEntity("Need HELP with your SPRING BOOT 3 App?",
                "SPRING BOOT 3 will only speed things up and make it super SIMPLE to serve templates and raw data.",
                "alice"));
        repository.save(new VideoEntity("Don't do THIS to your own CODE!",
                "As a pro developer, never ever EVER do this to your code. Because you'll ultimately be doing it to YOURSELF!",
                "alice"));
        repository.save(new VideoEntity("SECRETS to fix BROKEN CODE!",
                "Discover ways to not only debug your code, but to regain your confidence and get back in the game as a software developer.",
                "bob"));
    }
}
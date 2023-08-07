package com.example.demo;

import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class VideoService {
    // private List<NewVideo> videos;
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository _VideoRepository) {
        this.videoRepository = _VideoRepository;
        // this.videos = List.of(
        // new NewVideo("1", "abc"),
        // new NewVideo("2", "def"),
        // new NewVideo("3", "ghi"));
    }

    public List<VideoEntity> getVideos() {
        return videoRepository.findAll();
    }

    public VideoEntity create(NewVideo video) {
        return videoRepository.saveAndFlush(new VideoEntity(video.name(), video.description()));
    }

    public List<VideoEntity> search(VideoSearch videoSearch) {
        if (StringUtils.hasText(videoSearch.name()) && StringUtils.hasText(videoSearch.description())) {
            return videoRepository.findByNameContainingOrDescriptionContainingAllIgnoreCase(videoSearch.name(),
                    videoSearch.description());
        }
        if (StringUtils.hasText(videoSearch.name())) {
            return videoRepository.findByNameContainingIgnoreCase(videoSearch.name());
        }
        if (StringUtils.hasText(videoSearch.description())) {
            return videoRepository.findByDescriptionContainingIgnoreCase(videoSearch.description());
        }

        return Collections.emptyList();
    }

    public List<VideoEntity> search(UniversalSearch search) {
        // Sort sort = Sort.by("name").ascending()
        // .and(Sort.by("description").descending());
        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        VideoEntity videoEntity = new VideoEntity();
        // if (StringUtils.hasText(search.value())) {}
        videoEntity.setName(search.value());
        videoEntity.setDescription(search.value());
        Example<VideoEntity> probe = Example.of(videoEntity, exampleMatcher);
        return videoRepository.findAll(probe);
    }
}
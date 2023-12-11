package com.oussemaouakad.surpriseme.Story;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StoryServiceImpl implements StoryService{

    private final StoryRepository storyRepository;
    @Override
    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    @Override
    public Story getStoryById(long id) {
        return storyRepository.findById(id).orElse(null);
    }

    @Override
    public Story saveStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public void deleteStory(long id) {
        storyRepository.deleteById(id);
    }
}

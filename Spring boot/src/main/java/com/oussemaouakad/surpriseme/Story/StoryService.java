package com.oussemaouakad.surpriseme.Story;

import java.util.List;

public interface StoryService {
    List<Story> getAllStories();

    Story getStoryById(long id);

    Story saveStory(Story story);

    void deleteStory(long id);
}

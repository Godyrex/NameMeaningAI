package com.oussemaouakad.surpriseme.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Story")
@CrossOrigin(origins = "http://localhost:4200")
public class StoryController {
    @Autowired
 private StoryService storyService;

    @GetMapping
    public List<Story> getAllStories() {
        return storyService.getAllStories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Story> getStoryById(@PathVariable long id) {
        Story story = storyService.getStoryById(id);
        return story != null ? ResponseEntity.ok(story) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Story> saveStory(@RequestBody Story story) {
        Story savedStory = storyService.saveStory(story);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStory(@PathVariable long id) {
        storyService.deleteStory(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.Story.Book.controller;


import com.example.Story.Book.exceptions.StoryException;
import com.example.Story.Book.model.Story;
import com.example.Story.Book.services.StoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/story")
public class StoryController {

    @Autowired
    private StoryServices storyServices;


    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<Object> addStoryController(@RequestBody Story story) throws StoryException{
        Story response = storyServices.addStory(story);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @GetMapping("/all_stories")
    public ResponseEntity<List<Story>> getAllStoriesHandler() throws StoryException{
        List<Story> storyList = storyServices.getAllStories();
        return new ResponseEntity<>(storyList, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Story> updateStoryByIDHandler(@PathVariable("id") Integer id,@RequestBody Story story) throws StoryException{
        Story story1 = storyServices.updateStoryByID(id,story);
        return new ResponseEntity<>(story1, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStoryByIDHandler(@PathVariable("id") Integer id) throws StoryException{
        String res = storyServices.deleteStoryByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}

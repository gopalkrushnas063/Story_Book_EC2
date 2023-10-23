package com.example.Story.Book.services;

import com.example.Story.Book.exceptions.StoryException;
import com.example.Story.Book.model.Story;

import java.util.List;

public interface StoryServices {
    public Story addStory(Story story) throws StoryException;
    public List<Story> getAllStories() throws StoryException;
    public Story updateStoryByID(Integer id,Story story) throws StoryException;
    public String deleteStoryByID(Integer id) throws StoryException;
}

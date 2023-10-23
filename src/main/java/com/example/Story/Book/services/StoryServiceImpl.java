package com.example.Story.Book.services;

import com.example.Story.Book.exceptions.StoryException;
import com.example.Story.Book.model.Story;
import com.example.Story.Book.repository.StoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StoryServiceImpl implements StoryServices{

    @Autowired
    private StoryDao sDao;


    @Override
    public Story addStory(Story story) throws StoryException {
        Story existingStory = sDao.findByStoryTitle(story.getStoryTitle());

        if(existingStory != null){
            throw new StoryException("Story is already exist with this title"+story.getStoryTitle());
        }
        return sDao.save(story);
    }

    @Override
    public List<Story> getAllStories() throws StoryException {
        List<Story> stories = sDao.findAll();
        if(stories.isEmpty()){
            throw new StoryException("No any records found");
        }
        return stories;
    }

    @Override
    public Story updateStoryByID(Integer id, Story story) throws StoryException {
        Story existingStory = sDao.findById(id).get();
        existingStory.setStoryType(story.getStoryType());
        existingStory.setStoryTitle(story.getStoryTitle());
        existingStory.setStoryContent(story.getStoryContent());
        existingStory.setStoryImage(story.getStoryImage());
        if(existingStory != null){
            return sDao.save(existingStory);
        }
        throw new StoryException("Story does not exist with story ID : "+id);
    }

    @Override
    public String deleteStoryByID(Integer id) throws StoryException {
        Optional<Story> optionalStory = sDao.findById(id);
        if(optionalStory.isPresent()){
            sDao.deleteById(id);
            return "Successfully deleted the Story with the Client ID : "+id;
        }
        throw new StoryException("Claim does not exist with the Story ID : "+id);
    }
}

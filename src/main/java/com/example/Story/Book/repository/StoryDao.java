package com.example.Story.Book.repository;

import com.example.Story.Book.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryDao extends JpaRepository<Story,Integer> {
    public Story findByStoryTitle(String title);
}

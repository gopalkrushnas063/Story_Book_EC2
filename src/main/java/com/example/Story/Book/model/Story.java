package com.example.Story.Book.model;


import lombok.*;


import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storyID;
    private String storyType;
    private String storyTitle;
    private String storyImage;
    private String storyContent;

}

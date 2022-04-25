package com.anilduyguc.questionapp.responses;

import com.anilduyguc.questionapp.entities.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String username;
    String text;
    String title;
    List<LikeResponse> postlikes;

    public PostResponse(Post entity, List<LikeResponse> likes) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.username = entity.getUser().getUsername();
        this.title = entity.getTitle();
        this.text = entity.getText();
        this.postlikes = likes;
    }
}

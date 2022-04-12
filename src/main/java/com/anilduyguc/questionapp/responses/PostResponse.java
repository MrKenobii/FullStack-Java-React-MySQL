package com.anilduyguc.questionapp.responses;

import com.anilduyguc.questionapp.entities.Post;
import lombok.Data;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String username;
    String text;
    String title;

    public PostResponse(Post entity) {
        this.id = entity.getId();
        this.userId = entity.getUser().getId();
        this.username = entity.getUser().getUsername();
        this.title = entity.getTitle();
        this.text = entity.getText();

    }
}

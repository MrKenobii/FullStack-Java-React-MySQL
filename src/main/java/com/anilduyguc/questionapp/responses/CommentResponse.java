package com.anilduyguc.questionapp.responses;

import com.anilduyguc.questionapp.entities.Comment;
import lombok.Data;

@Data
public class CommentResponse {
    Long id;
    Long userId;
    String text;
    String username;
    public CommentResponse(Comment entity){
        this.id = entity.getId();
        this.userId=entity.getUser().getId();
        this.text=entity.getText();
        this.username= entity.getUser().getUsername();
    }
}

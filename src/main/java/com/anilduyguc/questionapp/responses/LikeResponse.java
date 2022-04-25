package com.anilduyguc.questionapp.responses;

import com.anilduyguc.questionapp.entities.Like;
import lombok.Data;

@Data
public class LikeResponse {
    Long id;
    Long userId;
    Long postId;
    public LikeResponse(Like like){
        this.id = like.getId();
        this.userId = like.getUser().getId();
        this.postId = like.getPost().getId();
    }
}

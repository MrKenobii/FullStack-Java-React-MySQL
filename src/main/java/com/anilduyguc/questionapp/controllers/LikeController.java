package com.anilduyguc.questionapp.controllers;

import com.anilduyguc.questionapp.entities.Like;
import com.anilduyguc.questionapp.requests.LikeCreateRequest;
import com.anilduyguc.questionapp.responses.LikeResponse;
import com.anilduyguc.questionapp.services.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping
    public List<LikeResponse> getAllLikes(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
        return likeService.getAllLikes(userId, postId);
    }
    @PostMapping
    public Like createOneLike(@RequestBody LikeCreateRequest likeCreateRequest){
        return likeService.createOneLike(likeCreateRequest);
    }
    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return likeService.getOneLikeById(likeId);
    }
    @DeleteMapping("/{likeId}")
    public void deleteOneLike(@PathVariable Long likeId){
        likeService.deleteOneLikeById(likeId);
    }
}

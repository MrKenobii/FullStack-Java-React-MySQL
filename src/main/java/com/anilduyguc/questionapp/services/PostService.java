package com.anilduyguc.questionapp.services;

import com.anilduyguc.questionapp.entities.Post;
import com.anilduyguc.questionapp.entities.User;
import com.anilduyguc.questionapp.repos.PostRepository;
import com.anilduyguc.questionapp.requests.PostCreateRequest;
import com.anilduyguc.questionapp.requests.PostUpdateRequest;
import com.anilduyguc.questionapp.responses.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private PostRepository postRepository;
    private UserService userService;
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<PostResponse> getAllPosts(Optional<Long> userId) {
        List<Post> postList;
        if(userId.isPresent())
             postList = postRepository.findByUserId(userId.get());
        postList = postRepository.findAll();
        return postList.stream().map(post ->
            new PostResponse(post)
        ).collect(Collectors.toList());
    }

    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest postCreateRequest ) {
        User user = userService.getOneUserById(postCreateRequest.getUserId());
        if(user == null) return null;
        Post toSave = new Post();
        toSave.setId(postCreateRequest.getId());
        toSave.setText(postCreateRequest.getText());
        toSave.setTitle(postCreateRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(postUpdateRequest.getText());
            toUpdate.setTitle(postUpdateRequest.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;

        }
        return null;
    }

    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}

package com.anilduyguc.questionapp.services;

import com.anilduyguc.questionapp.entities.Comment;
import com.anilduyguc.questionapp.entities.Post;
import com.anilduyguc.questionapp.entities.User;
import com.anilduyguc.questionapp.repos.CommentRepository;
import com.anilduyguc.questionapp.requests.CommentCreateRequest;
import com.anilduyguc.questionapp.requests.CommentUpdateRequest;
import com.anilduyguc.questionapp.responses.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }


    public List<CommentResponse> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
        List<Comment> comments;
        if(userId.isPresent() && postId.isPresent()){
            comments = commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
        }
        else if(userId.isPresent()){
            comments =  commentRepository.findByUserId(userId.get());
        }
        else if(postId.isPresent()){
            comments = commentRepository.findByPostId(postId.get());
        }
        else{
            comments = commentRepository.findAll();
        }
        return comments.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());


    }

    public Comment getOneCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CommentCreateRequest commentCreateRequest) {
        User user = userService.getOneUserById(commentCreateRequest.getUserId());
        Post post = postService.getOnePostById(commentCreateRequest.getPostId());
        if(user != null && post != null){
            Comment commentToSave = new Comment();
            commentToSave.setId(commentCreateRequest.getId());
            commentToSave.setText(commentCreateRequest.getText());
            commentToSave.setPost(post);
            commentToSave.setUser(user);
            commentToSave.setCreateDate(new Date());
            return commentRepository.save(commentToSave);
        }else
            return null;
    }

    public Comment updateOneCommentById(Long commentId, CommentUpdateRequest commentUpdateRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment toUpdate = comment.get();
            toUpdate.setText(commentUpdateRequest.getText());
            return commentRepository.save(toUpdate);
        }
        else return null;
    }

    public void deleteOneCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

package com.Instagram.social.controller;
import com.Instagram.social.model.Post;
import com.Instagram.social.service.PostService;
import com.Instagram.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Instagram.social.service.PostService;
@RestController
@RequestMapping("Post")
public class PostController {
    @Autowired
   private UserService userService;
    @PutMapping("{userId}/create/{imageUrl}")
    public String createPost(@PathVariable String userId, @PathVariable String imageUrl) throws Exception {
        userService.createPost(userId,imageUrl);
        return "Post created";
    }
    @GetMapping("{postId}")
    public Post getPostById(@PathVariable String postId) throws Exception {
        return userService.getPostById(postId);
    }
    @DeleteMapping("{userId}/delete/{postId}")
    public String deletePost(@PathVariable String userId, @PathVariable String postId) throws Exception {
        userService.deletePost(userId, postId);
        return "Post deleted";
    }
    @DeleteMapping("{userId}/deleteAll")
    public String deleteAllPostOfAUser(@PathVariable String userId) throws Exception {
        return "The post in {userId} is deleted";
    }
    @PutMapping("like/{postId}")
    public String likePost(@PathVariable String postId) throws Exception {
        userService.likePost(postId);
        return "Liked post..!";
    }
}


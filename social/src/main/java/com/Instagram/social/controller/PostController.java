package com.Instagram.social.controller;

import com.Instagram.social.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Instagram.social.service.PostService;
@RestController
@RequestMapping("Post")
public class PostController {
    @Autowired
   private PostService postService;
    @PostMapping("{userId}/Create/{imageUrl}")
    public String CreatePost(@PathVariable String userId,@PathVariable String imageUrl) throws Exception{
        PostService.CreatePost(userId,imageUrl);
        return "post created";
    }
}

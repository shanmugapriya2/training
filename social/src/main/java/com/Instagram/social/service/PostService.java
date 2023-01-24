package com.Instagram.social.service;

import com.Instagram.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.Instagram.social.repository.UserRepository;
@Service
public class PostService {
    private static PostService PostRepository;
    @Autowired
    private UserRepository userRepository;
    public static String CreatePost(@PathVariable String userId, @PathVariable String imageUrl) throws Exception{
        PostRepository.CreatePost(userId,imageUrl);
        return "post created";


    }
}

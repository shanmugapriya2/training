package com.Instagram.social.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Instagram.social.repository.UserRepository;
@Service

public class PostValidator {
    @Autowired
    UserRepository userRepository;
    public void preValidatePost(String postId) throws Exception {
        if(isPostExist(postId)) {
            throw new Exception("Re - enter the post id correctly, Post id not found");
        }
    }
    public boolean isPostExist(String postId) {
        return userRepository.getPostById(postId) == null;
    }
}



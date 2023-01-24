package com.Instagram.social.service;

import com.Instagram.social.model.Post;
import com.Instagram.social.model.User;
import com.Instagram.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Instagram.social.validators.IdAndNameValidator;
import com.Instagram.social.validators.CreateUserValidator;
import com.Instagram.social.validators.PostValidator;
import com.Instagram.social.validators.FollowUserValidator;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    IdAndNameValidator idAndNameValidator;
    @Autowired
    CreateUserValidator createUserValidator;
    @Autowired
    FollowUserValidator followUserValidator;

    @Autowired
    PostValidator postValidator;

    public User getUserById(String userId) throws Exception {
        idAndNameValidator.preValidateUserId(userId);
        return UserRepository.getUserById(userId);
    }

    public String getUserByName(String userName) throws Exception {
        idAndNameValidator.preValidateUserName(userName);
        return userRepository.getUserByName(userName);
    }

    public void createUser(User user) throws Exception {
        createUserValidator.preValidateUser(user);
        userRepository.createUser(user);
    }

    public void followUser(String userId, String userIdToFollow) throws Exception {
        followUserValidator.preValidate(userId, userIdToFollow);
        userRepository.followUser(userId, userIdToFollow);
    }


    public void deleteUser(String userId) throws Exception {
        idAndNameValidator.isIdExist(userId);
        userRepository.deleteUser(userId);
    }

    public void createPost(String userId, String imageUrl) throws Exception {
        idAndNameValidator.isIdExist(userId);
        userRepository.createPost(userId, imageUrl);
    }

    public Post getPostById(String postId) throws Exception {
        postValidator.isPostExist(postId);
        return (Post) userRepository.getPostById(postId);
    }

    public void deletePost(String userId, String postId) throws Exception {
        idAndNameValidator.isIdExist(userId);
        postValidator.preValidatePost(postId);
        userRepository.deletePost(userId, postId);
    }

    public void deleteAllPostOfAUser(String userId) throws Exception {
        idAndNameValidator.isIdExist(userId);
        userRepository.deleteAllPostOfAUser(userId);
    }

    public void likePost(String postId) throws Exception {
        postValidator.preValidatePost(postId);
        userRepository.likePost(postId);
    }

    public void CreateUser(User user)throws Exception {
        createUserValidator.preValidateUser(user);
        userRepository.createUser(user);
    }
}
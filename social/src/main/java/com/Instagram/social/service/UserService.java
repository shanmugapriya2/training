package com.Instagram.social.service;

import com.Instagram.social.model.User;
import com.Instagram.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String CreateUser(@RequestBody User user) throws Exception{
        userRepository.CreateUser(user);
        return "user with user id"+user.getUserId()+"created";
    }
    public Optional<String> getUserById(@PathVariable String userId) throws Exception{
        return userRepository.findById(userId);
    }

    public String getUserByName(@PathVariable String userName) throws Exception{
        return userRepository.getUserByName(userName);
    }
    public String followUser(@PathVariable String userId,@PathVariable String userIdToFollow) throws Exception{
        userRepository.followUser(userId,userIdToFollow);
        return "followed"+userIdToFollow;
    }
    }


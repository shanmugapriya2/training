package com.Instagram.social.controller;

import com.Instagram.social.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Instagram.social.model.User;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
     private UserService userService;
    @PostMapping
    public String UserService(@RequestBody User user) throws Exception{
        userService.CreateUser(user);
        return "user with user id"+user.getUserId()+"created";
    }
    @GetMapping("/{User}")
    public User getUserById(@PathVariable String userId) throws Exception{
        return userService.getUserById(userId);
    }
    @GetMapping("/{Name}")
    public String getUserByName(@PathVariable String userName) throws Exception{
        return userService.getUserByName(userName);
    }
    @PutMapping("{userid}/follow{userIdTOFollow}")
    public String followUser(@PathVariable String userId,@PathVariable String userIdToFollow) throws Exception{
        userService.followUser(userId,userIdToFollow);
        return "followed"+userIdToFollow;
    }


}

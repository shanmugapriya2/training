package com.Instagram.social.repository;

import com.Instagram.social.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepository extends MongoRepository<String, String>{
    String getUserByName(String userName);
    Long CreateUser(User user);
    void followUser(String userId, String userIdToFollow);
}

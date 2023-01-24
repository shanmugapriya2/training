package com.Instagram.social.repository;

import com.Instagram.social.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepository extends MongoRepository<String, String>{

    String getUserByName(String userName);
    String CreateUser(User user);
    void followUser(String userId, String userIdToFollow);


    Object getPostById(String postId);

    String createUser(User user);

    void deleteUser(String userId);

    void createPost(String userId, String imageUrl);

    void deletePost(String userId, String postId);

    void deleteAllPostOfAUser(String userId);

    void likePost(String postId);

    static User getUserById(String userId) {
        return null;
    }
}

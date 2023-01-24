package com.Instagram.social.validators;

import com.Instagram.social.controller.UserController;
import com.Instagram.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FollowUserValidator {
    @Autowired
    IdAndNameValidator idAndNameValidator;

    public void preValidate(String userId, String userIdToFollow) throws Exception {
        idAndNameValidator.isIdExist(userId);
        idAndNameValidator.isIdExist(userIdToFollow);
        if (isBothIdEqual(userId, userIdToFollow)) {
            throw new Exception("Both id are same");
        }

        if (isAlreadyFollowed(userId, userIdToFollow)) {
            throw new Exception(userId + " is already following " + userIdToFollow);
        }
    }

    private boolean isAlreadyFollowed(String userId, String userIdToFollow) {
        return UserRepository.getUserById(userId)
                .equals(userIdToFollow);
    }

    private boolean isBothIdEqual(String userId, String userIdToFollow) {
        return UserRepository.getUserById(userId)
                .equals(userIdToFollow);
    }
}


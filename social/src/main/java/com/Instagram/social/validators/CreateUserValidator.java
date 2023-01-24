package com.Instagram.social.validators;

import com.Instagram.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Instagram.social.repository.UserRepository;
import com.Instagram.social.model.User;
@Service
public class CreateUserValidator {
    @Autowired
    UserRepository userRepository;

    public void preValidateUser(User user) throws Exception {
        if (isIdAvailable(user.getUserId())) {
            throw new Exception("user with instagram id" + user.getUserId() + "already exist");
        } else if (isNameAvailable(user.getUserName())) {
            throw new Exception("User with instagram id" + user.getUserName() + "already exist");
        }
    }

    public boolean isIdAvailable(String userId) {
        return (userRepository .findById(userId) != null);

    }

    public boolean isNameAvailable(String userName) {
        return (userRepository.findAll() != null);

    }
}

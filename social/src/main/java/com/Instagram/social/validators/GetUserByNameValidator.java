package com.Instagram.social.validators;

import com.Instagram.social.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByNameValidator {
    @Autowired
    UserRepository userRepository;

    public void isIdExit(String userName)throws Exception{
        if(userRepository.getUserByName(userName)==null){
            throw new Exception("user with id"+userName+"is not found");
        }
    }

}

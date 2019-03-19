package com.springboot.service;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/13
 */
@Service
public class ImpUserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User loadUserByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
}

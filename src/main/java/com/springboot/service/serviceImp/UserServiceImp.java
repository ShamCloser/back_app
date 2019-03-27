package com.springboot.service.serviceImp;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/13
 */
@Service
public class UserServiceImp implements IUserService {
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

    @Override
    public Page<User> userList(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

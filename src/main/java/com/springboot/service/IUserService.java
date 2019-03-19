package com.springboot.service;

import com.springboot.entity.User;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/13
 */
public interface IUserService {
    /**
     * 根据用户名和密码加载用户
     * @param username
     * @param password
     */
    User loadUserByUsernameAndPassword(String username, String password);
}

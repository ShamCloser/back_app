package com.springboot.service;

import com.springboot.entity.User;
import org.springframework.data.domain.Page;

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

    /**
     * 员工列表
     * @param page
     * @param size
     * @return
     */
    Page<User> userList(Integer page,Integer size);

    /**
     * 保存员工
     * @param user
     * @return
     */
    User save(User user);

    /**
     * 根据id查找员工
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * 删除员工
     * @param id
     */
    void deleteUser(Integer id);
}

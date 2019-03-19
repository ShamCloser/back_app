package com.springboot.repository;

import com.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ project  项目介绍
 * @ author  clsr
 * @ date  2019/3/13
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsernameAndPassword(String username,String password);
}

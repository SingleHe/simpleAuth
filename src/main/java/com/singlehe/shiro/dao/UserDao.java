package com.singlehe.shiro.dao;

import com.singlehe.shiro.entity.User;

import java.util.List;

public interface UserDao {
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long userId);

    /**
     * 通过用户编号查询指定用户
     * @param userId
     * @return
     */
    User findOne(Long userId);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAll();
    User findByUsername(String userName);
}

package com.singlehe.shiro.service.impl;

import com.singlehe.shiro.dao.UserDao;
import com.singlehe.shiro.entity.User;
import com.singlehe.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public User addUser(User user) {
        //需要对用户密码进行加密。
        User user1 = userDao.saveUser(user);
        return user1;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void changePassword(Long userId, String newPassword) {

    }

    @Override
    public User findOne(Long userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public Set<String> findRoles(String userName) {
        return null;
    }

    @Override
    public Set<String> findPermissions(String userName) {
        return null;
    }
}

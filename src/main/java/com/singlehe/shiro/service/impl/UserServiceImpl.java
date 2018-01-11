package com.singlehe.shiro.service.impl;

import com.singlehe.shiro.dao.UserDao;
import com.singlehe.shiro.entity.User;
import com.singlehe.shiro.service.RoleService;
import com.singlehe.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    PasswordHelper passwordHelper;
    @Autowired
    RoleService roleService;
    @Override
    public User addUser(User user) {
        //需要对用户密码进行加密。
        passwordHelper.encryptPassword(user);
        return userDao.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    @Override
    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    public Set<String> findRoles(String userName) {
        User user = userDao.findByUsername(userName);
        if(user == null){
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    @Override
    public Set<String> findPermissions(String userName) {
        User user = userDao.findByUsername(userName);
        if(user == null){
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }
}

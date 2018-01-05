package com.singlehe.shiro.service;

import com.singlehe.shiro.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(User user);

    void changePassword(Long userId, String newPassword);

    User findOne(Long userId);
    List<User> findAll();
    User findByUserName(String userName);

    /**
     * 查询指定用户的角色
     * @param userName
     * @return
     */
    Set<String> findRoles(String userName);
    Set<String> findPermissions(String userName);
}

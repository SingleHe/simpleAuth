package com.singlehe.shiro.dao;

import com.singlehe.shiro.entity.Role;

import java.util.List;

public interface RoleDao {
    Role saveRole(Role role);
    Role updateRole(Role role);
    void deleteRole(Long roleId);

    Role findOne(Long roleId);
    List<Role> findAll();
}

package com.singlehe.shiro.service;

import com.singlehe.shiro.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Role addRole(Role role);
    Role updateRole(Role role);
    void deleteRole(Long roleId);

    Role findOne(Long roleId);
    List<Role> findAll();

    /**
     * 通过角色编号查询角色标识符，1-->admin?
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}

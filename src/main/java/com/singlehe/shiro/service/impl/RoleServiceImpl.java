package com.singlehe.shiro.service.impl;

import com.singlehe.shiro.dao.RoleDao;
import com.singlehe.shiro.entity.Role;
import com.singlehe.shiro.service.ResourceService;
import com.singlehe.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleDao roleDao;
    @Autowired
    ResourceService resourceService;
    @Override
    public Role addRole(Role role) {
        return roleDao.saveRole(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public Role findOne(Long roleId) {
        return roleDao.findOne(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds){
            Role role = findOne(roleId);
            if(role != null){
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<>();
        for(Long roleId : roleIds){
            Role role = findOne(roleId);
            if(role != null){
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }
}

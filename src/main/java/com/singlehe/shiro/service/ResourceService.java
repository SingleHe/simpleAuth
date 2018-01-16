package com.singlehe.shiro.service;

import com.singlehe.shiro.entity.Resource;

import java.util.List;
import java.util.Set;

public interface ResourceService {
    Resource addResource(Resource resource);
    Resource updateResource(Resource resource);
    void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();

    /**
     * 通过资源id找到对应资源的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限字符串得到对应的菜单
     * @param permissions
     * @return
     */
    List<Resource> findMenus(Set<String> permissions);

}

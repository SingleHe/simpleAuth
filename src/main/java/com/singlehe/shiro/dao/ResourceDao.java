package com.singlehe.shiro.dao;

import com.singlehe.shiro.entity.Resource;

import java.util.List;

public interface ResourceDao {
    Resource saveResource(Resource resource);
    Resource updateResource(Resource resource);
    void deleteResource(Long resourceId);

    Resource findOne(Long resourceId);
    List<Resource> findAll();
}

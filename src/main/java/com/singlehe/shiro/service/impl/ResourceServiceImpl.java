package com.singlehe.shiro.service.impl;

import com.singlehe.shiro.dao.ResourceDao;
import com.singlehe.shiro.entity.Resource;
import com.singlehe.shiro.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
@Service
public class ResourceServiceImpl implements ResourceService{
    @Autowired
    ResourceDao resourceDao;
    @Override
    public Resource addResource(Resource resource) {
        return resourceDao.saveResource(resource);
    }

    @Override
    public Resource updateResource(Resource resource) {
        return resourceDao.updateResource(resource);
    }

    @Override
    public void deleteResource(Long resourceId) {
        resourceDao.deleteResource(resourceId);
    }

    @Override
    public Resource findOne(Long resourceId) {
        return resourceDao.findOne(resourceId);
    }

    @Override
    public List<Resource> findAll() {
        return resourceDao.findAll();
    }

    @Override
    public Set<String> findPermissions(Set<Long> resourceIds) {
        //todo
        return null;
    }

    @Override
    public List<Resource> findMenus(Set<String> permissions) {
        //todo
        return null;
    }
}

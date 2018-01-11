package com.singlehe.shiro.service.impl;

import com.singlehe.shiro.dao.OrganizationDao;
import com.singlehe.shiro.entity.Organization;
import com.singlehe.shiro.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrganizationServiceImpl implements OrganizationService{
    @Autowired
    OrganizationDao organizationDao;
    @Override
    public Organization addOrg(Organization org) {
        return organizationDao.saveOrganization(org);
    }

    @Override
    public Organization updateOrg(Organization org) {
        return organizationDao.updateOrganization(org);
    }

    @Override
    public void deleteOrg(Long orgId) {
        organizationDao.deleteOrganization(orgId);
    }

    @Override
    public Organization findOne(Long orgId) {
        return organizationDao.findOne(orgId);
    }

    @Override
    public List<Organization> findAll() {
        return organizationDao.findAll();
    }

    @Override
    public Object findAllWithExclude(Organization excludeOrg) {
        //todo
        return null;
    }

    @Override
    public void move(Organization source, Organization target) {
        //todo
    }
}

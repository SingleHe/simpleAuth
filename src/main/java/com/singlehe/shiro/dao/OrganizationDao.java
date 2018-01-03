package com.singlehe.shiro.dao;

import com.singlehe.shiro.entity.Organization;

import java.util.List;

public interface OrganizationDao {
    Organization saveOrganization(Organization org);
    Organization updateOrganization(Organization org);
    void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();


}

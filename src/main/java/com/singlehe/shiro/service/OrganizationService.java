package com.singlehe.shiro.service;

import com.singlehe.shiro.entity.Organization;

import java.util.List;

public interface OrganizationService {
    Organization addOrg(Organization org);
    Organization updateOrg(Organization org);
    void deleteOrg(Long orgId);

    Organization findOne(Long orgId);
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOrg);

    /**
     * 调整部门关系
     * @param source
     * @param target
     */
    void move(Organization source,Organization target);
}

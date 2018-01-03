package com.singlehe.shiro.dao.impl;

import com.singlehe.shiro.dao.OrganizationDao;
import com.singlehe.shiro.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Repository
public class OrganizationDaoImpl implements OrganizationDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Organization saveOrganization(final Organization org) {
        final String sql = "insert into sys_organization(name,parent_id,parent_ids,available) values(?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql,new String[]{"id"});
                int count = 1;
                psst.setString(count++,org.getName());
                psst.setLong(count++,org.getParentId());
                psst.setString(count++,org.getParentIds());
                psst.setBoolean(count++,org.getAvailable());
                return psst;
            }
        },keyHolder);
        org.setId(keyHolder.getKey().longValue());
        return org;
    }

    @Override
    public Organization updateOrganization(Organization org) {
        String sql = "update sys_organization set name=?,parent_id=?,parent_ids=?,available=? where id=?";
        jdbcTemplate.update(sql,org.getName(),org.getParentId(),org.getParentIds(),org.getAvailable(),org.getId());
        return org;
    }

    @Override
    public void deleteOrganization(Long organizationId) {
        Organization org = findOne(organizationId);
        String deleteSelfSql = "delete from sys_organization where id=?";
        jdbcTemplate.update(deleteSelfSql,organizationId);
        //删除所有下属机构
        String deleteDescendantsSql = "delete from sys_organization where parent_ids like ?";
        jdbcTemplate.update(deleteDescendantsSql,org.makeSelfAsParentIds()+ "%");
    }

    @Override
    public Organization findOne(Long organizationId) {
        String sql = "select id,name,parent_id,parent_ids,available from sys_organization where id=?";
        List<Organization> organizationList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Organization.class), organizationId);
        if(organizationList.size() == 0){
            return null;
        }
        return organizationList.get(0);
    }

    @Override
    public List<Organization> findAll() {
        String sql = "select id,name,parent_id,parent_ids,available from sys_organization";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper(Organization.class));
    }
}

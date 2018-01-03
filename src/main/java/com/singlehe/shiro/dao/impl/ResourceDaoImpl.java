package com.singlehe.shiro.dao.impl;

import com.singlehe.shiro.dao.ResourceDao;
import com.singlehe.shiro.entity.Resource;
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
public class ResourceDaoImpl implements ResourceDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public Resource saveResource(final Resource resource) {
        final String sql = "insert into sys_resource(name,type,url,permission,parent_id,parent_ids,available) values(?,?,?,?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql,new String[]{"id"});
                int count = 1;
                psst.setString(count++,resource.getName());
                psst.setString(count++,resource.getType().name());
                psst.setString(count++,resource.getUrl());
                psst.setString(count++,resource.getPermission());
                psst.setLong(count++,resource.getParentId());
                psst.setString(count++,resource.getParentIds());
                psst.setBoolean(count++,resource.getAvailable());
                return psst;
            }
        },keyHolder);
        resource.setId(keyHolder.getKey().longValue());
        return resource;
    }

    @Override
    public Resource updateResource(Resource resource) {
        String sql = "update sys_resource set name=?, type=?, url=?, permission=?, parent_id=?, parent_ids=?, available=? where id=?";
        jdbcTemplate.update(
                sql,
                resource.getName(), resource.getType().name(), resource.getUrl(), resource.getPermission(), resource.getParentId(), resource.getParentIds(), resource.getAvailable(), resource.getId());
        return resource;
    }

    @Override
    public void deleteResource(Long resourceId) {
        Resource resource = findOne(resourceId);
        String deleteSelfSql = "delete from sys_resource where id=?";
        jdbcTemplate.update(deleteSelfSql,resourceId);
        String deleteDescendantSql = "delete from sys_resource where parent_ids like ?";
        jdbcTemplate.update(deleteDescendantSql,resource.makeSelfAsParentIds() + "%");
    }

    @Override
    public Resource findOne(Long resourceId) {
        final String sql = "select id, name, type, url, permission, parent_id, parent_ids, available from sys_resource where id=?";
        List<Resource> resourceList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Resource.class), resourceId);
        if(resourceList.size() == 0) {
            return null;
        }
        return resourceList.get(0);
    }

    @Override
    public List<Resource> findAll() {
        final String sql = "select id, name, type, url, permission, parent_id, parent_ids, available from sys_resource order by concat(parent_ids, id) asc";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Resource.class));
    }
}

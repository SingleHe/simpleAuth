package com.singlehe.shiro.dao.impl;

import com.singlehe.shiro.dao.RoleDao;
import com.singlehe.shiro.entity.Role;
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
public class RoleDaoImpl implements RoleDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Role saveRole(final Role role) {
        final String sql = "insert into sys_role(role,description,resource_ids,available) value(?,?,?,?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql,new String[]{"id"});
                int count = 1;
                psst.setString(count++,role.getRole());
                psst.setString(count++,role.getDescription());
                psst.setString(count++,role.getResourceIdsStr());
                psst.setBoolean(count++,role.getAvailable());
                return psst;
            }
        },keyHolder);
        role.setId(keyHolder.getKey().longValue());
        return role;
    }

    @Override
    public Role updateRole(Role role) {
        final String sql = "update sys_role set role=?, description=?, resource_ids=?, available=? where id=?";
        jdbcTemplate.update(sql,
                            role.getRole(),
                            role.getDescription(),
                            role.getResourceIdsStr(),
                            role.getAvailable(),
                            role.getId());
        return role;
    }

    @Override
    public void deleteRole(Long roleId) {
        final String sql = "delete from sys_role where id=?";
        jdbcTemplate.update(sql,roleId);
    }

    @Override
    public Role findOne(Long roleId) {
        final String sql = "select id, role, description, resource_ids as resourceIdsStr, available from sys_role where id=?";
        List<Role> roleList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Role.class), roleId);
        if(roleList.size() == 0) {
            return null;
        }
        return roleList.get(0);
    }

    @Override
    public List<Role> findAll() {
        final String sql = "select id, role, description, resource_ids as resourceIdsStr, available from sys_role";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Role.class));
    }
}

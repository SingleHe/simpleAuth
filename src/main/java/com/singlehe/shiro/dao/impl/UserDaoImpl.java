package com.singlehe.shiro.dao.impl;

import com.singlehe.shiro.dao.UserDao;
import com.singlehe.shiro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User saveUser(final User user) {
        final String sql = "insert into sys_user(organization_id,username,password,salt,role_ids,locked) value(?,?,?,?,?,?)";
        //Spring利用GeneratedKeyHolder，提供了一个可以返回新增记录对应主键值的方法：
        //Spring为KeyHolder接口指代了一个通用的实现类GeneratedKeyHolder，该类返回新增记录时的自增长主键值。
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql,new String[]{"id"});
                int count = 1;
                psst.setLong(count++,user.getOrganizationId());
                psst.setString(count++,user.getUserName());
                psst.setString(count++,user.getPassword());
                psst.setString(count++,user.getSalt());
                psst.setString(count++,user.getRoleIdsStr());
                psst.setBoolean(count++,user.getLocked());
                return psst;
            }
        },keyHolder);
        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    public User updateUser(User user) {
        String sql = "update sys_user set organization_id=?,username=?,password=?,salt=?,role_ids=?,locked=? where id=?";
        jdbcTemplate.update(sql,user.getOrganizationId(),user.getUserName(),user.getPassword()
                            ,user.getSalt(),user.getRoleIdsStr(),user.getLocked());
        return user;
    }

    public void deleteUser(Long userId) {
        String sql = "delete from sys_user where id=?";
        jdbcTemplate.update(sql,userId);
    }

    public User findOne(Long userId) {
        String sql = "select id,organization_id,username,password,salt,role_ids as roleIdsStr,locked from sys_user where id=?";
        List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),userId);
        if(userList.size() == 0){
            return null;
        }
        return userList.get(0);
    }

    public List<User> findAll() {
        String sql = "select id,organization_id,username,password,salt,role_ids as roleIdsStr,locked from sys_user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    public User findByUsername(String userName) {
        String sql = "select id,organization_id,username,password,salt,role_ids as roleIdsStr,locked from sys_user where username=?";
        List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class),userName);
        if(userList.size() == 0){
            return null;
        }
        return userList.get(0);
    }
}

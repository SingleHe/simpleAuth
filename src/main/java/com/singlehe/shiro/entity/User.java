package com.singlehe.shiro.entity;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private Long id;
    private Long organizationId;
    private String userName;
    private String password;
    private String salt;
    private List<Long> roleIds;
    private Boolean locked = Boolean.FALSE;
    public User(){}
    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Long> getRoleIds() {
        if(roleIds == null){
            roleIds = new ArrayList<Long>();
        }
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
    public String getCredentialsSalt(String salt){
        return userName + salt;
    }

    /**
     * 将列表形式的角色列表转换成字符串
     * @return
     */
    public String getRoleIdsStr(){
        if(CollectionUtils.isEmpty(roleIds)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(Long roleId : roleIds){
            sb.append(roleId);
            sb.append(",");
        }
        return sb.toString();
    }

    /**
     * 页面提交上来的角色列表是字符串，这里进行转换，
     * 将字符串转为列表；
     * @param roleIdsStr
     */
    public void setRoleIdsStr(String roleIdsStr){
        if(StringUtils.isEmpty(roleIdsStr)){
            return ;
        }
        String[] roleIdStrs = roleIdsStr.split(",");
        for(String roleIdStr : roleIdStrs){
            if(StringUtils.isEmpty(roleIdsStr)){
                continue;
            }
            getRoleIds().add(Long.valueOf(roleIdsStr));
        }
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }
        User user = (User)o;
        //id 不相等 则两用户不相同
        if(id != null ? !id.equals(user.id) : user.id != null){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", roleIds=" + roleIds +
                ", locked=" + locked +
                '}';
    }
}

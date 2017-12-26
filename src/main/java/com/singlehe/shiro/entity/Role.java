package com.singlehe.shiro.entity;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role implements Serializable {
    private Long id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;
    private List<Long> resourceIds;
    public Role(){}
    public Role(String role,String description,Boolean available ){
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Long> getResourceIds() {
        if(resourceIds == null){
            resourceIds = new ArrayList<Long>();
        }
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }
    public String getResourceIdsStr(){
        if(CollectionUtils.isEmpty(resourceIds)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(Long resourceId : resourceIds){
            sb.append(resourceIds);
            sb.append(",");
        }
        return sb.toString();
    }
    public void setResourceIdsStr(String resourceIdsStr){
        if(StringUtils.isEmpty(resourceIdsStr)){
            return;
        }
        String[] resourceIdStrs = resourceIdsStr.split(",");
        for(String resourceIdStr : resourceIdStrs){
            if(StringUtils.isEmpty(resourceIdStr)){
                continue;
            }
            getResourceIds().add(Long.valueOf(resourceIdStr));
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
        Role role = (Role)o;
        if(id != null ? !id.equals(role.id) : role.id != null){
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
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", resourceIds=" + resourceIds +
                '}';
    }
}

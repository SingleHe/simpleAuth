package com.singlehe.shiro.entity;

import java.io.Serializable;

public class Organization implements Serializable{
    private Long id;
    private String name;
    private Long parentId;
    private String parentIds;//父编号：0/1/2/
    private Boolean available = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    /**
     * 判断是否为最高层次的组织机构（总公司）
     * @return
     */
    public boolean isRootNode(){
        return parentId == 0;
    }

    /**
     * 将自己设置为父节点
     * @return
     */
    public String makeSelfAsParentIds(){
        return getParentIds()+ getId()+"/";
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Organization org = (Organization)o;
        if(id != null ? !id.equals(org.id) : org.id != null){
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
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                '}';
    }
}

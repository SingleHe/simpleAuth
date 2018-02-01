package com.singlehe.shiro.entity;

import java.io.Serializable;

public class Resource implements Serializable{
    private Long id;
    private String name;
    private String url;//资源路径
    private String permission;//权限字符串
    private Long parentId;//父编号
    private String parentIds;//父编号列表
    private Boolean available = Boolean.FALSE;
    //资源类型:使用了枚举类型
    private ResourceType type = ResourceType.menu;
    public static enum ResourceType{
        menu("菜单"),button("按钮");
        private final String info;
        private ResourceType(String info){
            this.info = info;
        }
        public String getInfo(){
            return info;
        }
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
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

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    /**
     * 判断是否根节点
     * @return
     */
    public boolean isRootNode(){
        return parentId == 0;
    }

    /**
     * 设置自己为父节点
     * @return
     */
    public String makeSelfAsParentIds(){
        return getParentIds() + id + "/";
    }
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Resource res = (Resource) o;
        if(id != null ? !id.equals(res.id) : res.id != null){
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
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", permission='" + permission + '\'' +
                ", parentId=" + parentId +
                ", parentIds='" + parentIds + '\'' +
                ", available=" + available +
                ", type=" + type +
                '}';
    }
}

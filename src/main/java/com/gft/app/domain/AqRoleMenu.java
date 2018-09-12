package com.gft.app.domain;

import java.util.Date;

public class AqRoleMenu {
    /**  */
    private String id;

    /** 角色ID */
    private String roleId;

    /** 菜单ID */
    private String menuId;

    /** 生成日期 */
    private Date scrq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }
}
package com.gft.app.domain;

import java.util.Date;

public class AqUserRole {
    /**  */
    private String id;

    /** 用户ID */
    private String userId;

    /** 角色ID */
    private String roleId;

    /** 生成日期 */
    private Date scrq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }
}
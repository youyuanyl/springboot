package com.gft.app.domain;

import java.util.Date;

public class AqRole {
    /**  */
    private String id;

    /** 角色名称 */
    private String rolename;

    /** 角色描述 */
    private String description;

    /** 生成日期 */
    private Date scrq;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }
}
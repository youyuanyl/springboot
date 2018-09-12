package com.gft.app.domain;

import java.util.Date;

public class AqUser {
    /** 物理主键 */
    private String id;

    /** 登录名 */
    private String username;

    /** 登录密码 */
    private String password;

    /** 姓名 */
    private String name;

    /** 生成日期 */
    private Date scrq;

    /** 验证码 */
    private String checkcode;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getScrq() {
        return scrq;
    }

    public void setScrq(Date scrq) {
        this.scrq = scrq;
    }

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
    
}
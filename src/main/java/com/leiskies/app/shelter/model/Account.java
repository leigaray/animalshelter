package com.leiskies.app.shelter.model;

import java.sql.Date;

public class Account {
	private Integer id;
	private String type;
	private Date created;
	private String username;
	private String password;
	private String email;
	private String phone;
	public Account(Integer id, String type, Date created, String username, String password, String email,
			String phone) {
		this.id = id;
		this.type = type;
		this.created = created;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public Account(String type, Date created, String username, String password, String email, String phone) {
		this.type = type;
		this.created = created;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public Account() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", created=" + created + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	}
}

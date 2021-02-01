package com.leiskies.app.shelter.model;

public class Location {
	private Integer id;
	private String name;
	private String phone;
	private Integer address;
	public Location(Integer id, String name, String phone, Integer address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Location(String name, String phone, Integer address) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public Location() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getAddress() {
		return address;
	}
	public void setAddress(Integer address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
}

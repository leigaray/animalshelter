package com.leiskies.app.shelter.model;

import java.sql.Date;

import com.leiskies.app.shelter.enums.AnimalStatus;
import com.leiskies.app.shelter.enums.AnimalType;
import com.leiskies.app.shelter.enums.Color;

public class Animal {

	private Integer id;
	private String status;
	private Integer age;
	private String name;
	private String type;
	private String color;
	private double weight;
	private Date admitted;
	private Date adopted;
	private Integer location;
	private Integer user;
	public Animal() {
	}
	public Animal(Integer id, String status, Integer age, String name, String type, String color, double weight,
			Date admitted, Date adopted, Integer location, Integer user) {
		this.id = id;
		this.status = status;
		this.age = age;
		this.name = name;
		this.type = type;
		this.color = color;
		this.weight = weight;
		this.admitted = admitted;
		this.adopted = adopted;
		this.location = location;
		this.user = user;
	}
	public Animal(AnimalStatus status, Integer age, String name, AnimalType type, Color color, double weight, Date admitted,
			Date adopted, Integer location, Integer user) {
		this.status = status.name();
		this.age = age;
		this.name = name;
		this.type = type.getName();
		this.color = color.toString().toLowerCase();
		this.weight = weight;
		this.admitted = admitted;
		this.adopted = adopted;
		this.location = location;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getAdmitted() {
		return admitted;
	}
	public void setAdmitted(Date admitted) {
		this.admitted = admitted;
	}
	public Date getAdopted() {
		return adopted;
	}
	public void setAdopted(Date adopted) {
		this.adopted = adopted;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", status=" + status + ", age=" + age + ", name=" + name + ", type=" + type
				+ ", color=" + color + ", weight=" + weight + ", admitted=" + admitted + ", adopted=" + adopted
				+ ", location=" + location + ", user=" + user + "]";
	}
}

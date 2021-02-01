package com.leiskies.app.shelter.model;

import java.util.List;

import com.leiskies.app.shelter.dao.ModelDAO;

public class Animal_Images {
	private Integer id;
	private String description;
	private String path;
	public Animal_Images(Integer id, String description, String path) {
		this.id = id;
		this.description = description;
		this.path = path;
	}
	public Animal_Images(String description, String path) {
		this.description = description;
		this.path = path;
	}
	public Animal_Images() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Animal_Images [id=" + id + ", description=" + description + ", path=" + path + "]";
	}
	
	public static void main(String[] args) {
		
	}
}

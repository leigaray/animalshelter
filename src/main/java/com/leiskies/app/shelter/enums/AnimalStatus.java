package com.leiskies.app.shelter.enums;

public enum AnimalStatus {
	ADOPTED("Adopted"),
	AVAILABLE("Available");
	
	private String name;

	private AnimalStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
}

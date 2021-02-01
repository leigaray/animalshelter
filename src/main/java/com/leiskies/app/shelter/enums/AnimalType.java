package com.leiskies.app.shelter.enums;

public enum AnimalType {
	
	DOG("Dog"),
	CAT("Cat"),
	HAMSTER("Hamster"),
	PARROT("Parrot");
	
	
	AnimalType(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

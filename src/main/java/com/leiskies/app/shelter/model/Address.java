package com.leiskies.app.shelter.model;

import com.leiskies.app.shelter.enums.US_State;

public class Address {
	
	private Integer id; 
	private String street;
	private String unit;
	private String city;
	private String state;
	private String zipcode;
	
	public Address(Integer id, String street, String unit, String city, US_State state, String zipcode) {
		this.id = id;
		this.street = street;
		this.unit = unit;
		this.city = city;
		this.state = state.getAbbreviation();
		this.zipcode = zipcode;
	}
	
	public Address(String street, String unit, String city, US_State state, String zipcode) {
		this.street = street;
		this.unit = unit;
		this.city = city;
		this.state = state.getAbbreviation();
		this.zipcode = zipcode;
	}
	
	public Address() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", unit=" + unit + ", city=" + city + ", state=" + state
				+ ", zipcode=" + zipcode + "]";
	}
}

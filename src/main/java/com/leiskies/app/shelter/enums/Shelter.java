package com.leiskies.app.shelter.enums;

public enum Shelter {
	TN("Tennessee", 1),
	NH("New Hampshire", 2),
	MD("Maryland", 3),
	AZ("Arizona", 4);
	
	private String place;
	private Integer code;
	private Shelter(String place, Integer code) {
		this.setPlace(place);
		this.setCode(code);
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}

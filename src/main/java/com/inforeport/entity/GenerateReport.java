package com.inforeport.entity;

import lombok.Data;

@Data
public class GenerateReport {
	
	private String document;
	private String name;
	private String mobile;
	private String city;
	private String status;
	private String email;
	private String imageByte;
	
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImagePath() {
		return imageByte;
	}
	public void setImagePath(String imageByte) {
		this.imageByte = imageByte;
	}


}

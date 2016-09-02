package com.level.bean;

public class NameEntity {

	String name;
	String imageUrl;
	public NameEntity(String name, String imageUrl) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Entity [name=" + name + ", imageUrl=" + imageUrl + "]";
	}
	
	
}

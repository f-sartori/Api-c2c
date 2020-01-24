package com.c2c.c2c_api.model;

public class Product {
	
	private int id;
	private double price;
	private String name;
	private String description;
	private String imgUrl;
	
	
	public Product() {
		

	}
	
	
	public Product(int id, double price, String name, String description, String imgUrl) {
		
		this.id = id;
		this.price = price;
		this.name = name;
		this.description = description;
		this.imgUrl = imgUrl;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}

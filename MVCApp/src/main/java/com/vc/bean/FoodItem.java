package com.vc.bean;

public class FoodItem {
	int id;
	String name;
	String description;
	double price;
	boolean status;
	
	public FoodItem() {}
	
	public FoodItem(int id, String name, String description, double price, boolean status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	
	public FoodItem(String name, String description, double price, boolean status) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}

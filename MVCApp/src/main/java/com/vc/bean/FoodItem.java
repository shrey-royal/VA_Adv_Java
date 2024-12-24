package com.vc.bean;

public class FoodItem {
	String name;
	String description;
	double price;
	boolean status;
	
	public FoodItem() {}
	
	public FoodItem(String name, String description, double price, boolean status) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
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

package com.vc.bean;

public class OrderBean {
	private String name;
	private int quantity;
	private double price;
	private double totalItemPrice;
	
	public OrderBean() {}
	
	public OrderBean(String name, int quantity, double price, double totalItemPrice) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.totalItemPrice = totalItemPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalItemPrice() {
		return totalItemPrice;
	}
	public void setTotalItemPrice(double totalItemPrice) {
		this.totalItemPrice = totalItemPrice;
	}
}

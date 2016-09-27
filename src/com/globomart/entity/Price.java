package com.globomart.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Price {
	int productId;
	double price;
	double quantity;
	String unit;
		
	public Price(){
		
	}

	public Price(int productId, double price, double quantity, String unit) {
		super();
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
		this.unit = unit;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
	
	
	
	
}
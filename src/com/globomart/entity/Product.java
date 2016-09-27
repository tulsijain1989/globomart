package com.globomart.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	int productId;
	String name;
	String description;
	String productType;
		
	public Product(){
		
	}
	public Product(String name, String description,
			String productType) {
		super();
		
		this.name = name;
		this.description = description;
		this.productType = productType;
		
	}
	
	public Product(int productId, String name, String description,
			String productType) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.productType = productType;
		
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	
	
	
	
}
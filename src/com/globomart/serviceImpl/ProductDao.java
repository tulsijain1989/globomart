package com.globomart.serviceImpl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globomart.entity.Product;


public interface ProductDao {	
	
	public List<Product> getProductList();
	public boolean 	addProduct(Product product);
	public List<Product> getProductByType(String type);
	public boolean deleteProduct(int productId);
	public Product getProductById(int id);
	
	
}

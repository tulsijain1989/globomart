package com.globomart.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.globomart.client.DBConnector;
import com.globomart.entity.Product;


public class ProductDaoImpl implements ProductDao {
	private Connection conn;

	public ProductDaoImpl() {
		conn = DBConnector.getConnection();
	}

	public List<Product> getProductList() {
		 ResultSet rs; List<Product> list= new ArrayList<Product>(); 
		 try {
		 Statement stmt = conn.createStatement();
		 String sql = "Select * from PRODUCT";
		 rs = stmt.executeQuery(sql);
		 while(rs.next()){
			  Product product= new Product();
			  product.setProductId(rs.getInt(1));
			  product.setName(rs.getString(2));
			  product.setDescription(rs.getString(3));
			  product.setProductType(rs.getString(4));
			  list.add(product); 
			  }			  
			  } 
		 catch (SQLException e) { 
			  e.printStackTrace(); 
			  }
		 return list; 
		 }
	

	public Product getProductById(int productId) {
		 Product product= new Product();
			 try {
			 Statement stmt = conn.createStatement();
			 String sql = "Select * from PRODUCT where PRODUCT_ID= '"+productId+"'   ";
			 ResultSet rs = stmt.executeQuery(sql);
			
			 while(rs.next()){				  
				  product.setProductId(rs.getInt(1));
				  product.setName(rs.getString(2));
				  product.setDescription(rs.getString(3));
				  product.setProductType(rs.getString(4));
				  return product; 
				  }			  
				  } 
			 catch (SQLException e) { 
				  e.printStackTrace(); 
				  }
			return null;

	}

	public List<Product> getProductByType(String productType) {
		ResultSet rs;
		List<Product> list= new ArrayList<Product>(); 
		 try {
		 Statement stmt = conn.createStatement();
		 String sql = "Select * from PRODUCT where TYPE= '"+productType+"'";
		 rs = stmt.executeQuery(sql);
		 while(rs.next()){
			  Product product= new Product();
			  product.setProductId(rs.getInt(1));
			  product.setName(rs.getString(2));
			  product.setDescription(rs.getString(3));
			  product.setProductType(rs.getString(4));
			  list.add(product); 
			  }			  
			  } 
		 catch (SQLException e) { 
			  e.printStackTrace(); 
			  }
		 return list; 
		 }
	

	
	@Override
	public boolean addProduct(Product product) {
		String sql= "INSERT INTO PRODUCT VALUES (NULL,'"+product.getName()+"',"
				+ "'"+product.getDescription()+"','"+product.getProductType()+"');";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {
		 Product product= new Product();
		 try {
		 Statement stmt = conn.createStatement();
		 String sql = "Delete from PRODUCT where PRODUCT_ID= '"+productId+"'   ";
		 stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
	}

	public boolean updateProduct(Product product) {
		String query= "UPDATE PRODUCT SET NAME=?,DESCRIPTION=?,TYPE=? where PRODUCT_ID= ?;";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query); 
			preparedStmt.setString(1, product.getName());
			preparedStmt.setString(2, product.getDescription());
			preparedStmt.setString(3, product.getProductType());
			preparedStmt.setInt(4, product.getProductId());
			
			
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}

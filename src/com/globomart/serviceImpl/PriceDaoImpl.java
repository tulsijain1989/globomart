package com.globomart.serviceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.globomart.client.DBConnector;
import com.globomart.entity.Price;
import com.globomart.entity.Product;

public class PriceDaoImpl implements PriceDao{
	private Connection conn;
	
	public PriceDaoImpl() {
		conn = DBConnector.getConnection();
	}

	@Override
	public Price getPrice(int productId) {
		Price price= new Price();
		 try {
		 Statement stmt = conn.createStatement();
		 String sql = "Select * from PRICE where PRODUCT_ID= '"+productId+"' ";
		 ResultSet rs = stmt.executeQuery(sql);
		 	 while(rs.next()){
			  price.setProductId(rs.getInt(1));
			  price.setPrice(rs.getDouble(2));
			  price.setQuantity(rs.getDouble(3));
			  price.setUnit(rs.getString(4));
			  
			  }			  
			  } 
		 catch (SQLException e) { 
			  e.printStackTrace(); 
			  }
		return price;
	}

}

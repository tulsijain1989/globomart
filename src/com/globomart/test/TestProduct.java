package com.globomart.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.junit.Assert.assertEquals;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.junit.BeforeClass;
import org.junit.Test;

import com.globomart.App;
import com.globomart.client.NetClient;

public class TestProduct {
	Server server;
	
	@BeforeClass
	public static void startDB() {
		App.initDB();
	}

	@BeforeClass
	public static void startServer() throws Exception {
		ResourceConfig config = new ResourceConfig();
		config.packages("com.globomart.service");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(2222);
		server.setStopAtShutdown(true);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");
		server.start();
	}

	@Test
	public void AddProduct() throws UnsupportedEncodingException {
		String urlParameters =
		        "name=" + URLEncoder.encode("Fevicol", "UTF-8") +
		        "&description=" + URLEncoder.encode("Sticky Liquid", "UTF-8")+
		        "&productType=" + URLEncoder.encode("Adhesive", "UTF-8");
	 	String targetURL="http://localhost:2222/productservice/product";
	 	NetClient.executePost(targetURL,urlParameters);
	}
	
	@Test
	public void GetProduct() {
		
			String targetURL = "http://localhost:2222/productservice/product";
			String result=	NetClient.executeGet(targetURL);
			System.out.println(result);
			String reqOutput = "[{\"productId\":1,\"name\":\"APPLE\",\"description\":\"APPLE IS GOOD FOR HEALTH\",\"productType\":\"FRUIT\"},{\"productId\":2,\"name\":\"MANGO\",\"description\":\"BAD FOR HEALTH\",\"productType\":\"FRUIT\"},{\"productId\":3,\"name\":\"TOMATO\",\"description\":\"Good for health\",\"productType\":\"VEGETABLE\"}]";
			assertEquals(reqOutput, result);
	}
	
	@Test
	public void GetProductById() {
			String targetURL = "http://localhost:2222/productservice/product/id/1";
			String result=	NetClient.executeGet(targetURL);
			String reqOutput = "{\"productId\":1,\"name\":\"APPLE\",\"description\":\"APPLE IS GOOD FOR HEALTH\",\"productType\":\"FRUIT\"}";
			assertEquals(reqOutput, result);
	}

	@Test
	public void GetProductByType() {
			String targetURL = "http://localhost:2222/productservice/product/type/VEGETABLE";
			String result=	NetClient.executeGet(targetURL);
			String reqOutput = "[{\"productId\":3,\"name\":\"TOMATO\",\"description\":\"Good for health\",\"productType\":\"VEGETABLE\"}]";
			assertEquals(reqOutput, result);
	}
	
	
}
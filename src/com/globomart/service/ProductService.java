package com.globomart.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;




import org.apache.log4j.Logger;

import com.globomart.entity.Product;
import com.globomart.serviceImpl.ProductDaoImpl;


@Path("/productservice")
public class ProductService {
	
	@GET
	@Path("product")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductList(){
		final Logger logger = Logger.getLogger(ProductService.class);
		logger.info("Get product list called");
		ProductDaoImpl prod=new ProductDaoImpl();
		List<Product> list=prod.getProductList();
		for(Product p:list){
			System.out.println(p.getName());
		}
		return list;
		
	}
	
	@GET
	@Path("product/id/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductbyId(@PathParam("productId") int productId){
		ProductDaoImpl prod= new ProductDaoImpl();
		Product product=prod.getProductById(productId);
		return product;
	}
	
	@GET
	@Path("product/type/{productType}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductbyType(@PathParam("productType") String productType){		
		ProductDaoImpl prod= new ProductDaoImpl();
		List<Product> list=prod.getProductByType(productType);
		return list;
	}
	
	@POST
	@Path("/product")
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED)
		public Response addProduct(@FormParam("name") String name,
				@FormParam("description")String description,
				@FormParam("productType") String productType){
		System.out.println("Create product called with parameters as"+name+" "+description+" "+productType);
		ProductDaoImpl prod= new ProductDaoImpl();
		Product product= new Product(name,description,productType);
		boolean status=prod.addProduct(product);
		if(status){
		return Response.status(Status.OK).build();
		}
		else return Response.status(Status.NO_CONTENT).build();
	
	}
	@DELETE
	@Path("product/id/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProductById(@PathParam("productId") int productId){
		System.out.println("deletion id is "+productId	);
		ProductDaoImpl prod= new ProductDaoImpl();
		prod.deleteProduct(productId);
		return Response.status(Status.OK).build();
	}
	
	@PUT
	@Path("/product")
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED)
		public Response updateProduct(@FormParam("productId")int productId, 
				@FormParam("name") String name,
				@FormParam("description")String description,
				@FormParam("productType") String productType){
		System.out.println("update product called with parameters as"+productId+" "+name+" "+description+" "+productType);
		ProductDaoImpl prod= new ProductDaoImpl();
		Product product= new Product(productId,name,description,productType);
		boolean status=prod.updateProduct(product);
		if(status){
		return Response.status(Status.OK).build();
		}
		else return Response.status(Status.NO_CONTENT).build();
	
	}
	


}



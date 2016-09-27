package com.globomart.service;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.globomart.entity.Price;
import com.globomart.serviceImpl.PriceDaoImpl;


@Path("/priceservice")
public class PriceService {

	@GET
	@Path("price/id/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Price getPriceByProductId(@PathParam("productId") int productId){
		PriceDaoImpl prod=new PriceDaoImpl();
		Price price=prod.getPrice(productId);
		return price;
	}
	
}
package com.globomart.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.globomart.App;
import com.globomart.client.NetClient;

public class TestPrice {
 static Server server;
 
 @BeforeClass
 public static void startDB() {
  App.initDB();
 }
 @BeforeClass
 public static void startServer() throws Exception {
  ResourceConfig config = new ResourceConfig();
  config.packages("com.globomart.service");
  ServletHolder servlet = new ServletHolder(new ServletContainer(config));

  server = new Server(2222);
  server.setStopAtShutdown(true);
  ServletContextHandler context = new ServletContextHandler(server, "/*");
  context.addServlet(servlet, "/*");
  server.start();
 }
 
 @AfterClass
 public static void stopServer() throws Exception {
  server.stop();
 }
 
 @Test
 public void GetPriceById() {
   String targetURL = "http://localhost:2222/priceservice/price/id/1";
   String result= NetClient.executeGet(targetURL);
   String reqOutput = "{\"productId\":1,\"price\":20.0,\"quantity\":1.0,\"unit\":\"KG\"}";
   assertEquals(reqOutput, result);
 }
}
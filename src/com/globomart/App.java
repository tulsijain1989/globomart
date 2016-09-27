package com.globomart;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import com.globomart.client.DBConnector;

public class App {

	public static void initDB() {
		DBConnector db = new DBConnector();
		try {
			boolean status = db.dbcreation();
			if (status) {
				System.out.println("DBb created successfully");
			} else
				System.out.println("DB creation failed successfully");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void main(String args[]) {
		App.initDB();
		ResourceConfig config = new ResourceConfig();
		config.packages("com.globomart.service");
		ServletHolder servlet = new ServletHolder(new ServletContainer(config));

		Server server = new Server(2222);
		server.setStopAtShutdown(true);
		ServletContextHandler context = new ServletContextHandler(server, "/*");
		context.addServlet(servlet, "/*");

		try {
			server.start();
			server.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.destroy();
		}
	}

}

package com.globomart.client;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;


// H2 Database Example

public class DBConnector {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    
    
    

    public boolean dbcreation() throws Exception {
        try {
            // delete the H2 database named 'test' in the user home directory
            DeleteDbFiles.execute("~", "test", true);
            insertWithStatementProduct();
            insertWithStatementPrice();
            return true;
           } catch (SQLException e) {
            e.printStackTrace();
        }
		return false;
    }

   
    // H2 SQL Statement Example
    private static void insertWithStatementProduct() throws SQLException {
        Connection connection = getConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE PRODUCT (PRODUCT_ID int primary key auto_increment, NAME varchar(255),DESCRIPTION varchar(255),TYPE varchar(255))");
            stmt.execute("INSERT INTO PRODUCT VALUES(NULL,'APPLE', 'APPLE IS GOOD FOR HEALTH', 'FRUIT')");
            stmt.execute("INSERT INTO PRODUCT VALUES(NULL,'MANGO', 'BAD FOR HEALTH', 'FRUIT')");
            stmt.execute("INSERT INTO PRODUCT VALUES(NULL,'TOMATO', 'Good for health', 'VEGETABLE')");

            ResultSet rs = stmt.executeQuery("select * from PRODUCT");
            System.out.println("H2 Database inserted through Statement");
            while (rs.next()) {
                System.out.println("Id "+rs.getInt("PRODUCT_ID")+" Name "+rs.getString("NAME"));
            }
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
    
    private static void insertWithStatementPrice() throws SQLException {
        Connection connection = getConnection();
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.execute("CREATE TABLE PRICE (PRODUCT_ID int primary key, PRICE double,QUANTITY double,UNIT varchar(255))");
           stmt.execute("INSERT INTO PRICE VALUES(1, 20.0, 1, 'KG')");
                   ResultSet rs = stmt.executeQuery("select * from PRICE");
            System.out.println("H2 Database inserted through Statement");
            while (rs.next()) {
                System.out.println("ProductId "+rs.getInt("PRODUCT_ID")+" Price "+rs.getString("PRICE"));
            }
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }


    public static Connection getConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}

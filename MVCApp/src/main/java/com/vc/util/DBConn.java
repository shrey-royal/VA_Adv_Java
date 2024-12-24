package com.vc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	
	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/vc";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName(DRIVERCLASS);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			if (conn != null) {
				System.out.println("Connected to Database");
			} else {
				System.out.println("Failed to connect to Database");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}

package com.vc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vc.bean.FoodItem;
import com.vc.util.DBConn;

public class FoodItemDao {
	private static Connection conn = null;
	private static String sql = null;

	public void addFoodItem(FoodItem item) {
		try {
			sql = "INSERT INTO hotel_menu(name, description, price, status) VALUES(?, ?, ?, ?)";
			conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getDescription());
			pstmt.setDouble(3, item.getPrice());
			pstmt.setBoolean(4, item.isStatus());
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("New item added to the menu!");
			} else {
				System.out.println("Failed to add a new item in the menu!");
			}
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println("Error: addFoodItem -> ");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing connection(addFoodItem())");
			}
		}
	}
}

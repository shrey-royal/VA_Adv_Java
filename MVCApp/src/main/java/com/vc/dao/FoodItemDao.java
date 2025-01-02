package com.vc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vc.bean.FoodItem;
import com.vc.util.DBConn;

public class FoodItemDao {
	private static Connection conn = null;
	private static String sql = null;

	public boolean addFoodItem(FoodItem item) {
		boolean flag = false;
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
				flag = true;
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
		return flag;
	}
	
	public List<FoodItem> getAllFoodItem() {
		List<FoodItem> listItems = null;
		try {
			sql = "SELECT * FROM hotel_menu";
			conn = DBConn.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			listItems = new ArrayList<FoodItem>();
			if (rs != null) {
				while(rs.next()) {
					listItems.add(
							new FoodItem(
									rs.getInt("item_id"),
									rs.getString("name"),
									rs.getString("description"),
									rs.getDouble("price"),
									rs.getBoolean("status")
							)
					);
				}
				System.out.println("Fetched all items from the menu!");
			} else {
				System.out.println("Failed to fetch items from the menu!");
			}
		} catch (Exception e) {
			System.out.println("Error: getAllFoodItems() -> ");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing connection(getAllFoodItems())");
			}
		}
		return listItems;
	}

	public FoodItem getFoodItemById(int id) {
		FoodItem item = null;
		PreparedStatement p = null;
		try {
			sql = "SELECT * FROM hotel_menu WHERE item_id = ?";
			conn = DBConn.getConnection();
			p = conn.prepareStatement(sql);
			p.setInt(1, id);
			
			ResultSet rs = p.executeQuery();
			
			if (rs.next()) {
				item = new FoodItem(
						id,
						rs.getString("name"),
						rs.getString("description"),
						rs.getDouble("price"),
						rs.getBoolean("status")
				);
				System.out.println("item fetched from the menu!");
			} else {
				System.out.println("Failed to fetch item from the menu!");
			}
		} catch (Exception e) {
			System.out.println("Error: getFoodItemById() -> ");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing connection(getFoodItemById())");
			}
		}
		return item;
	}

	public boolean updateFoodItem(FoodItem item) {
		boolean flag = false;
		try {
			sql = "UPDATE hotel_menu SET name=?, description=?, price=?, status=? WHERE item_id = ?";
			conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(5, item.getId());
			pstmt.setString(1, item.getName());
			pstmt.setString(2, item.getDescription());
			pstmt.setDouble(3, item.getPrice());
			pstmt.setBoolean(4, item.isStatus());
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("item updated to the menu!");
				flag = true;
			} else {
				System.out.println("Failed to update an item in the menu!");
			}
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println("Error: updateFoodItem -> ");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing connection(updateFoodItem())");
			}
		}
		return flag;
	}

	public boolean deleteFoodItemById(int id) {
		boolean flag = false;
		try {
			sql = "DELETE FROM hotel_menu WHERE item_id = ?";
			conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("Item deleted from the menu!");
				flag = true;
			} else {
				System.out.println("Failed to delete item from the menu!");
			}
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println("Error: deleteFoodItemById() -> ");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing connection(deleteFoodItemById())");
			}
		}
		return flag;
	}
}

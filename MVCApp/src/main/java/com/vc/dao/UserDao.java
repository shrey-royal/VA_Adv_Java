package com.vc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.vc.bean.UserBean;
import com.vc.util.DBConn;

public class UserDao {
	private static Connection conn = null;
	private static String sql = null;
	ResultSet rs = null;

	private String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}

	private Boolean checkPassword(String userPassword, String hashedpassword) { 
		if (BCrypt.checkpw(userPassword, hashedpassword)) return true;
		return false;
	 }

	public boolean addUser(UserBean bean) {
		boolean flag = false;
		try {
			// check if userName is unique.
			sql = "INSERT INTO users(username, password, role) VALUES(?, ?, ?)";
			conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getUsername());
			pstmt.setString(2, hashPassword(bean.getPassword()));
			pstmt.setString(3, bean.getRole());

			if (pstmt.executeUpdate() > 0) {
				System.out.println("New user added!");
				flag = true;
			} else {
				System.out.println("Failed to add a new user!");
			}

			pstmt.close();
		} catch (Exception e) {
			System.out.println("Error: addUser() -> ");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Error closing connection(addUser())");
			}
		}
		return flag;
	}

	public boolean authUser(UserBean bean) {
		boolean isUserValid = false;
		try {
			sql = "SELECT * FROM users WHERE username = ? AND role = ?";
			conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bean.getUsername());
			pstmt.setString(2, bean.getRole());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (checkPassword(bean.getPassword(), rs.getString("password"))) {
					System.out.println("Authentication successful!");
					isUserValid = true;
				}
			} else {
				System.out.println("Invalid username or password!");
			}
			pstmt.close();
		} catch (Exception e) {
			System.out.println("Error: authUser() -> ");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("Error closing connection(authUser())");
			}
		}
		return isUserValid;
	}

}

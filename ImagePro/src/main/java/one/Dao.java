package one;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	public boolean addImage(Bean bean) {
		boolean flag = false;
		String query = "INSERT INTO img (name, data) VALUES (?, ?)";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, bean.getName());
			ps.setBytes(2, bean.getData());
			if (ps.executeUpdate() > 0) flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}		
		return flag;
	}
	
	public List<Bean> getAllImages() {
		List<Bean> list = new ArrayList<Bean>();
		String query = "SELECT * FROM img";
		try {
			Connection conn = DBConnection.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				list.add(new Bean(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getBytes("data")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Bean getImgById(int productId) {
		Bean bean = null;
		String query = "SELECT * FROM img WHERE id=?";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,productId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bean = new Bean(rs.getInt("id"), rs.getString("name"), rs.getBytes("data"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public boolean updateImg(Bean bean) {
		boolean flag = false;
		String query = "UPDATE img SET name=?, data=? WHERE id = ?";
		
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, bean.getName());
			ps.setBytes(2, bean.getData());
			ps.setInt(3, bean.getId());
			
			if(ps.executeUpdate() > 0) {
				flag = true;
				System.out.println("img updated successfully!");
			}else {
				System.out.println("Failed to update img!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	public boolean deleteImgById(int id) {
		boolean flag = false;
		try {
			String query = "delete from img WHERE id = ?";
			Connection conn = DBConnection.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			if(ps.executeUpdate() > 0) {
				flag = true;
				System.out.println("img deleted successfully");
			}else {
				System.out.println("Failed to delete img!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}

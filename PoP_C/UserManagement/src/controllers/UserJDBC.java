package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.User;

public class UserJDBC {
	public boolean save(User user) {
		//connect and insert
		boolean result=false;
		String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/level4c", "root", "");
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setInt(1, user.getUid());
			pstat.setString(2, user.getFullname());
			pstat.setString(3, user.getPhone());
			pstat.setString(4, user.getEmail());
			pstat.setString(5, user.getLoginname());
			pstat.setString(6, user.getLoginpass());
			pstat.setString(7, user.getRole());
			pstat.executeUpdate(); //Save
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return result;
	}
	public User search(int uid) {
		//connect and insert
		User user=null;
		String sql = "SELECT * FROM users WHERE uid=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/level4c", "root", "");
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setInt(1, uid);
			ResultSet rs = pstat.executeQuery(); //Search
			if(rs.next()==true) { //if record found in table
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpass(rs.getString("loginpass"));
				user.setRole(rs.getString("role"));
			}
			pstat.close();
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return user;
	}
	public boolean edit(User user) {
		//connect and insert
		boolean result=false;
		String sql = "UPDATE users SET fullname=?, phone=?, email=?, loginname=?, 	loginpass=?, role=? WHERE uid=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/level4c", "root", "");
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setString(1, user.getFullname());
			pstat.setString(2, user.getPhone());
			pstat.setString(3, user.getEmail());
			pstat.setString(4, user.getLoginname());
			pstat.setString(5, user.getLoginpass());
			pstat.setString(6, user.getRole());
			pstat.setInt(7, user.getUid());
			pstat.executeUpdate(); //Save, Update, Delete
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return result;
	}
	public boolean delete(int uid) {
		//connect and insert
		boolean result=false;
		String sql = "DELETE FROM users WHERE uid=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/level4c", "root", "");
			PreparedStatement pstat=conn.prepareStatement(sql);
			pstat.setInt(1, uid);
			pstat.executeUpdate(); //Save, Edit, Delete
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return result;
	}
	public ArrayList all() {
		//connect and insert
		ArrayList users =new ArrayList();
		String sql = "SELECT * FROM users";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load database driver
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/level4c", "root", "");
			PreparedStatement pstat=conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery(); //Search
			if(rs.next()==true) { //if record found in table
				User user=new User();
				user.setUid(rs.getInt("uid"));
				user.setFullname(rs.getString("fullname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpass(rs.getString("loginpass"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
			pstat.close();
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return users;
	}
}

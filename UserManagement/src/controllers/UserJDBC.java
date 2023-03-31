package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
}

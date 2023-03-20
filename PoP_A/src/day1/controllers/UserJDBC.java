package day1.controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day1.models.User;

public class UserJDBC {
	public boolean login(User user) {
		//receive user info
		boolean result = false;
		try {
			//connect with db
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/level4a","root", "");
			String sql = "SELECT * FROM tbl_users WHERE userName=? and userPass=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, user.getUserName());
			pstat.setString(2, user.getPassword());
			//search user in db table
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				result=true;
			}
			//return result
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}
}

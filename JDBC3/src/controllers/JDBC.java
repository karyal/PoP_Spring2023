package controllers;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	public Connection connect() {
		Connection conn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return conn;
	}
}
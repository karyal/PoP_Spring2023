package controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import models.Student;

public class StudentController {
	public boolean save(Student student) {
		boolean result=false;
		String url = "jdbc:mysql://localhost/demo1";
		try {
			Connection conn = DriverManager.getConnection(url, "root", "");
			String sql = "INSERT INTO tbl_students VALUES(?, ?, ?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, student.getSid());
			pstat.setString(2, student.getName());
			pstat.setString(3, student.getCourse());
			pstat.executeUpdate(); //Save
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return result;
	}
}

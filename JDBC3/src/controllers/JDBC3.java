package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.NewPerson;

public class JDBC3 {
	public List allPersons() {
		List persons = new ArrayList<NewPerson>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String sql = "SELECT * FROM tbl_newpersons";
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String email = rs.getString("email");
				persons.add(new NewPerson(pid, name, address, email));
			}
			rs.close();
			pstat.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return persons;
	}

	public NewPerson search(int id) {
		NewPerson person = new NewPerson();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String sql = "SELECT * FROM tbl_newpersons WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, id);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String email = rs.getString("email");
				person.setPid(pid);
				person.setName(name);
				person.setAddress(address);
				person.setEmail(email);
			}
			rs.close();
			pstat.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return person;
	}

	public boolean update(int pid, String name, String address, String email) {
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String sql = "UPDATE tbl_newpersons set name=?, address=?, email=? WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, name);
			pstat.setString(2, address);
			pstat.setString(3, email);
			pstat.setInt(4, pid);
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}

	public boolean insert(int pid, String name, String address, String email) {
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String sql = "INSERT INTO tbl_newpersons values(?, ?, ?, ?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, pid);
			pstat.setString(2, name);
			pstat.setString(3, address);
			pstat.setString(4, email);
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}

	public boolean delete(int pid) {
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String sql = "DELETE FROM tbl_newpersons WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, pid);
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return result;
	}
}
package day2.myjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC {
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			conn.close();
			System.out.println("Connect and Close database connection!");
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}

	public void insert() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "INSERT INTO tbl_persons(pid, name, address) VALUES(?, ?, ?)";
			PreparedStatement pstat = conn.prepareStatement(strSql);
			pstat.setInt(1, 2);
			pstat.setString(2, "Rajan Thapa");
			pstat.setString(3, "KTM");
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			System.out.println("Record inserted!");
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}
	public void select() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "SELECT * FROM tbl_persons";
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(strSql);
			while (rs.next()) {
				System.out.println(rs.getInt("pid") + ", " + rs.getString("name") + ", " + rs.getString("address"));
			}
			rs.close();
			stat.close();
			stat.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}

	public void update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "UPDATE tbl_persons SET name=?, address=? WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(strSql);
			pstat.setString(1, "New Name");
			pstat.setString(2, "New Address");
			pstat.setInt(3, 1);
			pstat.executeUpdate();
			conn.close();
			System.out.println("Record inserted!");
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}

	public void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "DELETE FROM tbl_persons WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(strSql);			
			pstat.setInt(1, 2);
			pstat.executeUpdate();
			conn.close();
			System.out.println("Record deleted!");
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}
	
	public boolean insert(Person person) {
		boolean result = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "INSERT INTO tbl_persons(pid, name) VALUES(?, ?)";
			PreparedStatement pstat = conn.prepareStatement(strSql);
			pstat.setInt(1, person.getPid());
			pstat.setString(2, person.getName());			
			pstat.executeUpdate();
			pstat.close();
			conn.close();
			System.out.println("Record inserted!");
			result = true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
			result = false;
		}
		return result;
	}
	
	public Person search(int pid) {
		Person person=new Person();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "SELECT * FROM tbl_persons WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(strSql);
			pstat.setInt(1, pid);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				person.setPid(rs.getInt("pid"));
				person.setName(rs.getString("name"));
			}
			rs.close();
			pstat.close();			
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return person;
	}
	
	public ArrayList all() {
		ArrayList persons =new ArrayList<Person>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "SELECT * FROM tbl_persons";
			PreparedStatement pstat = conn.prepareStatement(strSql);		
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				Person person = new Person();
				person.setPid(rs.getInt("pid"));
				person.setName(rs.getString("name"));
				persons.add(person);
			}
			rs.close();
			pstat.close();			
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return persons;
	}
	
	public boolean update(Person person) {
		boolean result=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "UPDATE tbl_persons SET name=? WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(strSql);
			pstat.setString(1, person.getName());
			pstat.setInt(2, person.getPid());
			pstat.executeUpdate();
			conn.close();
			System.out.println("Record Updated!");
			result=true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
			result=false;
		}
		return result;
	}
	public boolean delete(int pid) {
		boolean result=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c", "root", "");
			String strSql = "DELETE FROM tbl_persons WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(strSql);
			pstat.setInt(1, pid);
			pstat.executeUpdate();
			conn.close();
			System.out.println("Record Deleted!");
			result=true;
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
			result=false;
		}
		return result;
	}
}
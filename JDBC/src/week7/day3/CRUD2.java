package week7.day3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CRUD2 {

	public CRUD2() {
		Person p1 = new Person(7, "Rohan");
		boolean res = inserRecord(p1);
		if(res) {
			System.out.println("Insert record successfully");
		}
		else {
			System.out.println("Error to insert record");
		}
		
		ArrayList persons = selectAll();
		System.out.println(persons.size());
		
	}
	
	public boolean inserRecord(Person p1) {
		boolean result=false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c","root", "");//Connect with database
			//Insert
			String sql = "INSERT INTO tbl_persons(pid, name) VALUES(?, ?)";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, p1.getPid());
			pstat.setString(2, p1.getName());
			pstat.executeUpdate();//save
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return result;
	}
	
	public Person search(int pid) {
		Person p1=new Person();
		try {
			//connect
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c","root", "");//Connect with database
			//retrieve record
			String sql = "SELECT * FROM tbl_persons WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, pid);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				p1 = new Person(rs.getInt("pid"), rs.getString("name"));
			}
			pstat.close();
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return p1;
	}
	
	public ArrayList selectAll() {
		ArrayList persons = new ArrayList<Person>();
		try {
			//connect
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c","root", "");//Connect with database
			//retrieve record
			String sql = "SELECT * FROM tbl_persons";
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				Person tmpPerson = new Person(rs.getInt("pid"), rs.getString("name"));
				persons.add(tmpPerson);
			}
			pstat.close();
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return persons;
	}
	
	public boolean updateRecord(Person p1) {
		boolean result=false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c","root", "");//Connect with database
			//Insert
			String sql = "UPDATE tbl_persons SET name=? WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1, p1.getName());
			pstat.setInt(2, p1.getPid());
			pstat.executeUpdate();//save
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return result;
	}
	
	public boolean deleteRecord(Person p1) {
		boolean result=false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c","root", "");//Connect with database
			//Insert
			String sql = "DELETE FROM tbl_persons WHERE pid=?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, p1.getPid());
			pstat.executeUpdate();//save
			pstat.close();
			conn.close();
			result=true;
		}
		catch(Exception ex) {
			System.out.println("Erro : "+ex.getMessage());
		}
		return result;
	}
	public static void main(String[] args) {
		new CRUD2();
	}

}

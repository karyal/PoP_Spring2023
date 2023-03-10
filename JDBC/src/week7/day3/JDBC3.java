package week7.day3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class JDBC3 {
	public List allPersons() {
		List persons = new ArrayList<NewPerson>();		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/level4c","root","");
			String sql = "SELECT * FROM tbl_persons";
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				int pid=rs.getInt("pid");
				String name=rs.getString("name");
				String address=rs.getString("address");
				String email=rs.getString("email");
				persons.add(new NewPerson(pid, name, address, email));
			}
			rs.close();
			pstat.close();
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		return persons;
	}
}
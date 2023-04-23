package week9.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MyDatabase {
	
	public ArrayList getAges() {
		String sql = "SELECT * FROM tbl_agegroups";
		//aid, agegroup
		ArrayList ages=new ArrayList();
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/level4c", "root", "");
			PreparedStatement pstat = conn.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				String ag = rs.getString("agegroup");
				ages.add(ag);
			}
			rs.close();
			pstat.close();
			conn.close();
		}
		catch(Exception ex) {
			System.out.println("Error "+ ex.getMessage());
		}
		return ages;
	}
	
}

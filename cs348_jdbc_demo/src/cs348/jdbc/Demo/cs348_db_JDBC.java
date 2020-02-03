package cs348.jdbc.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class cs348_db_JDBC {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 驱动连接数据库
			String url = "jdbc:mysql://35.223.114.125:3306/cs348_db";
			String user = "w22yuan";
			String password = "";
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *  from uw_user;");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1)+ "," + rs.getString(2) + "," + rs.getString(3)); 
			}
			
			if (rs != null) rs.close();
			if (stmt != null) rs.close();
			if (con != null) rs.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
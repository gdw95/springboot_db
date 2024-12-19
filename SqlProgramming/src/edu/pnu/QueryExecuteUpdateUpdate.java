package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryExecuteUpdateUpdate {
	public static void main(String[] args) {
		
	Connection con = null;
	String home = "집";
	int id = 4;

	try {
		con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/myfirstdb", "root", "tiger");
		String sql = "update phonebook set home=? where id=?";
		PreparedStatement psmt = con.prepareStatement(sql);
		psmt.setString(1, home);
		psmt.setInt(2, id);
		psmt.executeUpdate();

	} catch (SQLException e) {
		System.out.print("연결실패 : " + e.getMessage());
	}finally {
		try {
			if (con != null) con.close();
		}catch (SQLException e) {}
	}
	
}
}
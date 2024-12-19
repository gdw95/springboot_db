package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryExecuteUpdateDelete {
	public static void main(String[] args) {
		
		Connection con = null;
		int id = 4;
		String sql = "delete from phonebook where where id=?";

		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/myfirstdb", "root", "tiger");
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
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

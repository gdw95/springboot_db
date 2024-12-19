package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryExecuteUpdateInsert {

	//자료를 읽어야 하기때문에 main 에 선언

	public static void main(String[] args) {
		//서버연결이 가장 비용이 많이 듦 connection
		Connection con = null;
		String name = "김";
		String mobile = "1234";
		

		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/myfirstdb", "root", "tiger");
			String sql = "insert into phonebook(name, mobile) values(?,?)";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, mobile);
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

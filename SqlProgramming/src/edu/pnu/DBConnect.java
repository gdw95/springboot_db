package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","tiger");
			System.out.println("연결성공");
			con.close();
		}catch (Exception e) {
			System.out.println("연결실패: " + e.getMessage());
		}
	}
} 
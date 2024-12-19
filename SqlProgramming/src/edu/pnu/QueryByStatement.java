package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryByStatement {
	public static void main(String[] args) {
		//try{} 문 밖에 선언-> finally{} 블럭이 읽을 수 있도록 위함
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/world";
			con = DriverManager.getConnection(url, "root", "tiger");
			st = con.createStatement();//질의객체 생성-> new 생성자 사용 안함
			rs = st.executeQuery("select id, name, countrycode, "
					+ "district, population from city");//result 객체 생성
		while(rs.next()) {//rs.next() //getSting()모든데이터타입 읽기 가능
			System.out.print(rs.getInt("id") + ",");
			System.out.print(rs.getString("name") + ",");
			System.out.print(rs.getString("countrycode") + ",");
			System.out.print(rs.getString("district") + ",");
			System.out.print(rs.getInt("population") + "\n");
		}
	}catch (Exception e) {
		System.out.print("연결실패 : " + e.getMessage());
	}finally {//데이터베이스를 닫아주는 블럭, 위치 중요
		try {
			if (rs != null) rs.close();
			if (st != null) st.close();
			if (con != null) con.close();
		}catch (Exception e) {}
	}
}
}

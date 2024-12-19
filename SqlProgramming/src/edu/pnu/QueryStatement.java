package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QueryStatement {

	//자료를 읽어야 하기때문에 main 에 선언
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//서버연결이 가장 비용이 많이 듦 connection
		Connection con = null;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/world", "root", "tiger");
			queryStatement1(con);
			queryStatement2(con);
		} catch (SQLException e) {
			System.out.print("연결실패 : " + e.getMessage());
		}finally {
			try {
				if (con != null) con.close();
			}catch (SQLException e) {}
		}
	}

	//1. 인구 수를입력받아서그보다많은인구를가진도시를검색해서출력하세요.
	private static void queryStatement1(Connection con) {
		Statement st = null;
		ResultSet rs = null;

		try {
			System.out.print("인구수 : ");
			int val = sc.nextInt();

			st = con.createStatement();
			rs = st.executeQuery("select * from city where population >" + val);

			//work bench 데이터자료형 확인
			while(rs.next()) {
				System.out.print(rs.getInt("id") + ",");
				System.out.print(rs.getString("name") + ",");
				System.out.print(rs.getString("countrycode") + ",");
				System.out.print(rs.getString("district") + ",");
				System.out.print(rs.getInt("population") + "\n");
			}
		}catch (SQLException e) {
			System.out.print("연결실패 : " + e.getMessage());
		}finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			}catch (SQLException e) {}
		}
	}
	//2. 국가 명의일부또는국가코드를입력받아서해당국가의도시의이름과인구를검색해서출력하세요.
	private static void queryStatement2(Connection con) {
		Statement st = null;
		ResultSet rs = null;

		try {
			System.out.print("국가코드 : ");
			String val = sc.next();//국가코드 입력 
			st = con.createStatement();
			rs = st.executeQuery("select name from city where countrycode='" + val +"'");

			while(rs.next() ) {
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			System.out.print("연결실패 : " + e.getMessage());


			try {
				System.out.print("인구수 : ");
				int val2 = sc.nextInt();//인구수 입력

				st = con.createStatement();
				rs = st.executeQuery("select population from city where countrycode" + val2);

				while(rs.next() ) {
					System.out.print(rs.getString("population") + ",");
				}

			} catch (SQLException e2) {
				System.out.print("연결실패 : " + e.getMessage());
			}finally {
				try {
					if (rs != null) rs.close();
					if (st != null) st.close();
				}catch (SQLException e2) {}
			}
		}
	}
}

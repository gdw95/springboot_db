package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QueryPreparedStatement {

	//자료를 읽어야 하기때문에 main 에 선언
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//서버연결이 가장 비용이 많이 듦 connection
		Connection con = null;
		try {
			con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/world", "root", "tiger");
			//queryPreparedStatement1(con);
			//queryPreparedStatement2(con);
			//queryPreparedStatement3(con);
			queryPreparedStatement4(con);
			//queryPreparedStatement5(con);
		} catch (SQLException e) {
			System.out.print("연결실패 : " + e.getMessage());
		}finally {
			try {
				if (con != null) con.close();
			}catch (SQLException e) {}
		}
	}

	//1. 인구 수를입력받아서그보다많은인구를가진도시를검색해서출력하세요.
	private static void queryPreparedStatement1(Connection con) {
		Statement st = null;
		ResultSet rs = null;

		try {
			System.out.print("인구수 : ");
			int val = sc.nextInt();

			PreparedStatement stmt = con.prepareStatement("select * from city where population > ?");
			stmt.setInt(1, val);
			rs = stmt.executeQuery();

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
		private static void queryPreparedStatement2(Connection con) {
			Statement st = null;
			ResultSet rs = null;

			try {
				System.out.print("국가코드 : ");
				String val = sc.next();//국가코드 입력 
				
				PreparedStatement stmt = con.prepareStatement("select name from city where countrycode=?");
				stmt.setString(1, val);
				rs = stmt.executeQuery();

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
		
	//3. 대륙을입력받아서해당대륙에위치한국가를검색해서출력하세요. (Continent)
		private static void queryPreparedStatement3(Connection con) {
			Statement st = null;
			ResultSet rs = null;
			
			try {
				System.out.print("대륙 : ");
				String val3 = sc.next();//대륙코드 입력
				
				PreparedStatement stmt = con.prepareStatement("select name from country where Continent=?");
				stmt.setString(1, val3);
				rs = stmt.executeQuery();
				
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
		
		//4. 넓이(10,0002 km)를 입력 받아서 입력 값보다 작은 면적을 가진 국가의 이름과면적을면적오름차순으로검색해서출력하세요.
		private static void queryPreparedStatement4(Connection con) {
			Statement st = null;
			ResultSet rs = null;
			
			try {
				System.out.print("넓이 : ");
				int val4 = sc.nextInt();
				
				PreparedStatement stmt = con.prepareStatement("select name, surfaceArea from country where SurfaceArea<? order by SurfaceArea asc");
				stmt.setInt(1, val4);
				rs = stmt.executeQuery();
				
				while(rs.next() ) {
					System.out.println(rs.getString("name") + "," + rs.getInt("surFaceArea"));
					}
				} catch (SQLException e2) {
					System.out.print("연결실패 : " + e2.getMessage());
				}finally {
					try {
						if (rs != null) rs.close();
						if (st != null) st.close();
					}catch (SQLException e2) {}
			}
		}
		// 5. 대한민국의District를 입력 받아서 해당 지역에 있는모든도시를검색해서출력하세요. (예:‘Kyonggi’)
		private static void queryPreparedStatement5(Connection con) {
			Statement st = null;
			ResultSet rs = null;
			
			try {
				System.out.print("한국의 district : ");
				String val5 = sc.next();
				
				PreparedStatement stmt = con.prepareStatement("select * from city where countrycode='kor' and District=?");
				stmt.setString(1, val5);
				rs = stmt.executeQuery();
				
				while(rs.next() ) {
					System.out.println(rs.getString("name"));
					}
				}catch (SQLException e2) {
					System.out.print("연결실패 : " + e2.getMessage());
				}finally {
					try {
						if (rs != null) rs.close();
						if (st != null) st.close();
					}catch (SQLException e2) {}
			}
			
			
		}
}
package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class PhoneBookDao {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/phonebook";
	private static String user = "root";
	private static String pass = "tiger";
	
	private static void selectAllPhonebook(Connection con) {
		System.out.println("selectAllPhonebook");
		
	}

	private static void deletePhonebook(Connection con) {
		System.out.println("deletePhonebook");
		
	}

	private static void updatePhonebook(Connection con) {
		System.out.println("updatePhonebook");
		
	}

	private static void insertPhonebook(Connection con) {
		System.out.println("inserPhoebook");
		
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection(url, user, pass);
		boolean flag = true;
		
		while(flag) {
			System.out.print("[I]nsert/[U]pdate/[D]elete/[S]elect/e[X]it:");
			String s = sc.next().toUpperCase();
			switch(s) {
			case "I" : insertPhonebook(con); break; 
			case "U" : updatePhonebook(con); break; 
			case "D" : deletePhonebook(con); break; 
			case "S" : selectAllPhonebook(con); break; 
			case "X" : flag = false; 
			}
		}
		System.out.println("Bye~");
	}
}

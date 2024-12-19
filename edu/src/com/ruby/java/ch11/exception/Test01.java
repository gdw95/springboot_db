package com.ruby.java.ch11.exception;

public class Test01 {

	public static void test01() throws Exception {
		test02();
	}
	public static void test02() throws Exception {
		test03();
	}
	public static void test03() throws Exception {
		test04();
	}
	public static void test04() throws Exception{//예외던지기 throws 문, 최종적으로 main 까지감

		int arr[] = new int[3];
		arr[3] = 30;

		//		try {
		//			int arr[] = new int[3];
		//			arr[3] = 30;
		//		} catch(Exception e) {
		//			System.out.println(e.getMessage());
		//			e.printStackTrace();
		//		}finally {
		//			System.out.println("final");
		//		}

	}


	public static void main(String[] args) {
		try {
			test01();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("ok");
	}
}
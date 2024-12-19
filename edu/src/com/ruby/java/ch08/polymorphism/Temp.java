package com.ruby.java.ch08.polymorphism;


//이상현 교수님 예시
interface GPI{//
	void test();
}
class GP implements GPI{
	public void test() {
		System.out.println("1 - test");
	}
}

class PP extends GP{
	public void test() {
		System.out.println("2 - test");
	}
}

class CD extends PP{
	public void test() {
		System.out.println("3 - test");
	}
}

public class Temp{
	public static void main(String[] args) {
		CD obj = new CD();
		
		print(obj);
	}
	
	private static void print(CD obj) {
		obj.test();
	}
}
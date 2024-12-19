package com.ruby.java.ch06;//스태틱 메소드(함수)


public class StaticMethodTest {
	public static void main(String[] args) {
		StaticMethodTest.print();//스태틱메소드함수 사용하는 방법		//퍼블릭메소드함수사용하는 방법
		StaticMethodTest exam=new StaticMethodTest();
		exam.print2("!");
	}
	public static void print() {
		System.out.println("hello");
	}
	public void print2(String s) {
		System.out.println("java" +s);
	}
}
//스태틱 안에서는 스태틱만 
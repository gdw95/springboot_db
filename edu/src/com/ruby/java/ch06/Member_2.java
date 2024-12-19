package com.ruby.java.ch06;

public class Member_2 {
	private String name;
	private int age;
	
	//메소드호출 
	public Member_2() {
		this ("guest");
	}
	
	public Member_2(String name) {
		this(name, 0);
	}
	public Member_2(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public String toString() {
		return name+":"+age;
	}
	
	public static void main(String[] args) {
		Member_2 m1 = new Member_2();
		Member_2 m2 = new Member_2("Amy");
		Member_2 m3 = new Member_2("Amy", 23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
	}
}

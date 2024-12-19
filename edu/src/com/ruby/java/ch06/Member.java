package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;
	
	//컨트롤 스페이스 생성자 단축키
	public Member() {
		System.out.println("Method() 생성자 실행");
		
	}
	public void setName(String name) {
		System.out.println("Member(String) 생성자 실행 : ");
		System.out.println(name);
		
	}
	
	public void setName(String name, int age) {
		System.out.println("Member(String, int) 생성자 실행 : ");
		System.out.println(name+":"+age);
		
	}
	
	public void setName() {
		
	}
	
	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		new Member();
	}
}

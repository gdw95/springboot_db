package com.ruby.java.ch08.polymorphism;
//이상현 교수님 예시2// == 과 equals 차이 중요// == : 기본데이터 값이냐 참조일 때와 다름// 메모리 저장 개념 알아야함
class DD{

	String name;

	public DD(String name) {
		this.name = name;
	}
	
//	@Override //@Override 유무 차이 중요
//	public boolean equals(DD D) {
//		if (name.equals(d.name))
//			return true;
//		return false;
//	}

}

public class Temp2{

	public static void main(String[] args) {
		DD a = new DD("A");
		DD b = new DD("B");
		DD c = new DD("C");
		DD d = a;

		System.out.println((a.equals(c))?"equal":"not equal");

	}
}
//참조형 변수를 비교할 경우는 equals 만 사용하길 추천.
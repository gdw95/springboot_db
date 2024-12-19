package com.ruby.java.ch06;

class Count1{
	public static int totalCount;
	int count;
}

public class CountTest_2 {
	public static void main(String[] args) {//스태틱은 인스턴스없이 접근 가능. 앞에 클래스이름이 붙음.
		
		Count1 c1 = new Count1();
		Count1 c2 = new Count1();
		Count1 c3 = new Count1();		
		
		c1.count++;
		Count1.totalCount++;
		c2.count++;
		Count1.totalCount++;
		c3.count++;
		Count1.totalCount++;
		
		System.out.println(Count1.totalCount + ":" + c1.count);
		System.out.println(Count1.totalCount + ":" + c2.count);
		System.out.println(Count1.totalCount + ":" + c3.count);
	}
}

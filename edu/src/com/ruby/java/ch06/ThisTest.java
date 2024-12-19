package com.ruby.java.ch06;

public class ThisTest {
	int i=1;



	public int first(){
		int i=2;
		int j=3;
		this.i=1+j;

		return second(4);
		
	}
	public void second( int i) {
		int j=5;
		this.i= i+j;
		return this.i;
	}
	
	public static void main(String[] args) {
		ThisTest exam=new ThisTest();
		
		System.out.println(exam.first());
	}
}//컨트롤 F11 실행단축키
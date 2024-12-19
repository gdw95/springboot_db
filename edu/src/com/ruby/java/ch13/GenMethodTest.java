package com.ruby.java.ch13;

public class GenMethodTest {
	public <T extends Number, V extends T> boolean isInclude(T num, V[] array) {

		for(int i =0; i< array.length; i++) {
			if(array[i] ==num)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		GenMethodTest gt= new GenMethodTest();

		
		Integer[] inum = {1,2,3,4,5};
		Double[] dnum = {1.0, 2.0, 3.0, 4.0, 5.0};
		String[] snum = {"1", "2","3","4","5"};

		boolean b1 = gt.isInclude(3, inum);
		System.out.println("결과: "+b1 );

		boolean b2 = gt.isInclude(3.0, dnum);
		System.out.println("결과: "+b2 );

		//genMethodTest.isInclude(3, inum);
		//genMethodTest2.isInclude(3.0, dnum);




	}
}

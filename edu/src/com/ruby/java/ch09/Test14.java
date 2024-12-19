package com.ruby.java.ch09;//p.435 cursor

import java.util.StringTokenizer;

public class Test14 {
	public static void main(String[] args) {
		String msg = "i love you, you love me.";
		StringTokenizer st1 = new StringTokenizer(msg);
		System.out.println("단어수 = "+st1.countTokens());
		
		while (st1.hasMoreTokens()) {
			System.out.println("남아있는토큰수 = "+st1.countTokens());
			System.out.println(st1.nextToken());
		}
	}

}

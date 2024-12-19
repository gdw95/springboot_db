package com.ruby.java.ch07.abstraction;

public interface Messenger {
	
	public static final int MIN_SIZE = 1;
	public static final int MMAX_SIZE = 104857600;
	
	public abstract String getMassage();//추상1
		
	public abstract void setMassage(String msg);//추상2
	
	public default void setLogin(boolean login) {
		log()://프라이빗 메서드
		if(login) {
			System.out.println("로그인 처리합니다.");
		}
	}


}

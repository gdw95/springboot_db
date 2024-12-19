
package com.ruby.java.ch07.abstraction;
public class IphoneMessenger implements Messenger {

	@Override
	public String getMassage() {
		return "iphone";
	}

	@Override
	public void setMassage(String msg) {
		System.out.println("좌우로 흔들어 문자열을 지웁니다.");
		
	}
}

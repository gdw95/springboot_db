package com.ruby.java.ch07.abstraction;

public class GalaxyMessenger implements Messenger {

	@Override
	public String getMassage() {
		return "galaxy";
	}

	@Override
	public void setMassage(String msg) {
		System.out.println("galaxy에서 메시지를 설정합니다 : " + msg);
	}
	public void changerKeyboard() {
		System.out.println("키보드아이콘 터지후 키보드를 변경합니다.");
	}

}

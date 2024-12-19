package com.ruby.java.ch13.test;


class Bag<T>{
	
	
	//생성자 삭제
//	public Bag(T thing) {
//		this.thing = thing;
//	}
	
	private T thing;

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	void showType() {
		System.out.println("T의 타입은"+ thing.getClass().getName());
	}


}

class Book{}

class PenceilCase{}

class NoteBook{}




public class BagTest2 {
	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>();//생성자를 삭제했기때문에 파라미터 받을 수가 없음 () 안 매개변수 삭제
		Bag<PenceilCase> bag2 = new Bag<>();
		Bag<NoteBook> bag3 = new Bag<>();

		bag.setThing(new Book());//각 인스턴스의 객체를 만들어줘야함
		bag2.setThing(new PenceilCase());
		bag3.setThing(new NoteBook());
		
		
		bag.showType();
		bag2.showType();
		bag3.showType();

	}
}

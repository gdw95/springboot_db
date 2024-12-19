package com.ruby.java.ch13;


class Bag<T>{
	private T thing;

	public Bag(T thing) {
		this.thing = thing;
	}

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




public class BagTest {
	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PenceilCase> bag2 = new Bag<>(new PenceilCase());
		Bag<NoteBook> bag3 = new Bag<>(new NoteBook());

		bag.showType();
		bag2.showType();
		bag3.showType();

	}
}

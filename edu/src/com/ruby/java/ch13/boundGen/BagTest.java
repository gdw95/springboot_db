package com.ruby.java.ch13.boundGen;

class Bag<T extends Solid>{
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

class Solid{}
class Liquid{}
class Book extends Solid{}

class PenceilCase extends Solid{}
class NoteBook extends Solid{}

class Water extends Liquid{}
class Coffee extends Liquid{}

public class BagTest {
	public static void main(String[] args) {
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PenceilCase> bag2 = new Bag<>(new PenceilCase());
		Bag<NoteBook> bag3 = new Bag<>(new NoteBook());

//		Bag<Water> bag4 = new Bag<>(new Water());//오류
//		Bag<Coffee> bag5 = new Bag<>(new Coffee());//오류

	}
}

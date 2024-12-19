
//목표
//
//Book 클래스 생성 및 기본 컬렉션 사용
//설계
//Book 클래스: 제목, 저자, 출판 연도, ISBN 등을 속성으로 가짐
//Library 클래스: 도서 목록을 관리하는 기능 (책 추가, 책 목록 출력)
//과제
//
//Book 클래스를 작성하고 도서 정보를 담는 객체를 생성하세요.
//Library 클래스를 작성해 ArrayList를 사용하여 도서를 관리하고, 도서 목록을 출력하세요
//=================
//
//st == st2
//
//
//
//제목정렬전 도서숫자 = 5
//
//도서명=자바, 저자 = 강감찬, 출판연도 = 1995, isbn = 12
//
//도서명=파이썬, 저자 = 이순신, 출판연도 = 2008, isbn = 9
//
//도서명=자바스크립트, 저자 = 을지문덕, 출판연도 = 2008, isbn = 8
//
//도서명=자료구조, 저자 = 연개소문, 출판연도 = 1994, isbn = 45
//
//도서명=리액트, 저자 = 김춘추, 출판연도 = 1999, isbn = 7
//
//
//
//제목정렬후 도서숫자 = 5
//
//도서명=리액트, 저자 = 김춘추, 출판연도 = 1999, isbn = 7
//
//도서명=자료구조, 저자 = 연개소문, 출판연도 = 1994, isbn = 45
//
//도서명=자바, 저자 = 강감찬, 출판연도 = 1995, isbn = 12
//
//도서명=자바스크립트, 저자 = 을지문덕, 출판연도 = 2008, isbn = 8
//
//도서명=파이썬, 저자 = 이순신, 출판연도 = 2008, isbn = 9
//
//
//
//ISBN정렬전 도서숫자 = 5
//
//도서명=리액트, 저자 = 김춘추, 출판연도 = 1999, isbn = 7
//
//도서명=자료구조, 저자 = 연개소문, 출판연도 = 1994, isbn = 45
//
//도서명=자바, 저자 = 강감찬, 출판연도 = 1995, isbn = 12
//
//도서명=자바스크립트, 저자 = 을지문덕, 출판연도 = 2008, isbn = 8
//
//도서명=파이썬, 저자 = 이순신, 출판연도 = 2008, isbn = 9
//
//
//
//ISBN정렬후 도서숫자 = 5
//
//도서명=리액트, 저자 = 김춘추, 출판연도 = 1999, isbn = 7
//
//도서명=자바스크립트, 저자 = 을지문덕, 출판연도 = 2008, isbn = 8
//
//도서명=파이썬, 저자 = 이순신, 출판연도 = 2008, isbn = 9
//
//도서명=자바, 저자 = 강감찬, 출판연도 = 1995, isbn = 12
//
//도서명=자료구조, 저자 = 연개소문, 출판연도 = 1994, isbn = 45
//
//
//
//도서명으로 검색한 도서도서명=자바, 저자 = 강감찬, 출판연도 = 1995, isbn = 12
//
//=======
package com.ruby.java.기본API;



import java.util.Arrays;



/*

도서 관리 시스템은 다양한 책을 관리하고, 고객이 도서를 대여하거나 반납할 수 있게 하는 기능을 제공합니다. 또한, 고객의 대여 기록을 관리하고, 특정 조건에 맞는 책을 검색하거나 필터링하는 기능도 구현합니다.



1단계: 기본 클래스 및 컬렉션 사용

목표: Book 클래스 생성 및 기본 컬렉션 사용

설계:

Book 클래스: 제목, 저자, 출판 연도, ISBN 등을 속성으로 가짐

Library 클래스: 도서 목록을 관리하는 기능 (책 추가, 책 목록 출력)

과제:

Book 클래스를 작성하고 도서 정보를 담는 객체를 생성하세요.

Library 클래스를 작성해 ArrayList를 사용하여 도서를 관리하고, 도서 목록을 출력하세요.

 */

// Book 클래스
class Book {//extends Object

	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	//생성자 Constructor
	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	//Getters
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public String getISBN() {
		return isbn;
	}
	@Override //annotation 어노테이션-코드 주석달기: 자바컴파일러에게 정보를 제공(상위클래스에 것의 재정의 등)
	public String toString() {//public 키워드 쓰는 이유, //toString이 자바의 Object 클래스에 있기때문에 재정의
		return "도서명="+title+", 저자="+author+", 풀판연도="+publicationYear+", isbn"+isbn;
	}

}

// Library 클래스
class Library {

	static final int CAPACITY = 20;
	private Book[] books = new Book[CAPACITY];
	private int top = 0;

	//Getter
	public int getTop() {
		return top;
	}


	//addBook()
	public void addBook(Book book) {
		if (top < CAPACITY) {
			books[top++] = book;
		} else {
			System.out.println("가득 찼습니다.");
		}
	}


	//printBooks()
	public void printBooks(String msg) {
		System.out.println(msg + " 도서숫자 = " + top);
		for(int i = 0; i<top; i++) {
			System.out.println(books[i].toString());//toString()호출
		}
	}


	//sortBooksByTitle()
	public void sortBooksByTitle(){
		//String 의 compareTo() 사용
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));//9.3.3 Arrays 클래스, 람다식
		//		Arrays.sort(books, 0, top, (b1, b2) -> b1.getISBN().compareTo(b2.getISBN()));//9.3.3 Arrays 클래스, 람다식
	}


	//sortBooksByISBN()
	public void sortBooksByISBN(){
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getISBN().compareTo(b2.getISBN()));
	}


	//searchBookByTitle()
	public Book searchBookByTitle(String title) {//method return type 을 Book 으로
		for (int i = 0; i < top; i++) {
			if (books[i].getTitle().equalsIgnoreCase(title)) {
				return books[i];
			}
		}
		return null;
	}
}

//class MyObject{
//	int num;
//}
//
public class 실습9_1기본API_과제 {
	public static void main(String[] args) {
		//		String st = "java";
		//		String st2 = "java";//string interning
		//
		//		//the process of storing one unique instance of each distinct string value in a pool to optimize memory,
		//
		//		//so that multiple references to the same string literal point to the same memory location.
		//
		//		if (st.equals(st2))
		//
		//			System.out.println("st == st2");
		//		MyObject obj4 = new MyObject();
		//		MyObject obj5 = new MyObject();
		//		if (obj4.equals(obj5))
		//			System.out.println("같다");
		//		else 
		//			System.out.println("다르다");
		//		if (obj4 == obj5)//등호기호는 숫자에만 적용. 객체 등 X//해쉬코드는 숫자라서 가능함.
		//		Object obj = new Book();
		//		obj.hashCode();
		//		Book bk =  new Book();
		//		System.out.println(obj.hashCode());
		//		System.out.println(obj);

		Library library = new Library();
		// 5개의 Book 객체 초기화

		// 5개의 책 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("자바스크립트", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		// 책 추가
		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		System.out.println("제목정렬전 도서숫자="+ library.getTop());
		library.printBooks("\n제목정렬전");

		// 도서 목록 정렬
		library.sortBooksByTitle();

		// 정렬된 도서 목록 출력
		System.out.println("제목정렬후 도서숫자 = " + library.getTop());
		library.printBooks("\n제목정렬후");

		// 특정 제목으로 도서 검색
		System.out.println("ISBN정렬전 도서숫자 = " + library.getTop());
		library.printBooks("\nISBN정렬전");

		// 도서 목록 정렬
		library.sortBooksByISBN();

		// 정렬된 도서 목록 출력
		System.out.println("ISBN정렬후 도서숫자 = " + library.getTop());
		library.printBooks("\nISBN정렬후");

		// 특정 제목으로 도서 검색
		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook == null)
			System.out.println("\n자바 책이 없다");
		else
			System.out.println("\n도서명으로 검색한 도서" + foundBook.toString());
	}
}
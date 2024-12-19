package com.ruby.java.ch11.exception;

import java.util.Arrays;

import com.ruby.java.기본API.Book;
//Overflow 예외 클래스
class OverflowException extends RuntimeException { //교재 553
	public OverflowException(String message) {
		super(message); 
	} 
}

//Underflow 예외 클래스
class UnderflowException extends RuntimeException {
	public UnderflowException(String message) { 
		super(message); 
	} 
}

//Book 클래스
class Book {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book(String title, String author, int publicationYear, String isbn) {
		this.author = author;
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Override
	public String toString() {
		return String.format(" ");
	}
}

class Library { 
	static final int CAPACITY = 5;  // 기본 용량을 5로 설정
	private Book[] books; 
	private int top; 
	
	public Library() {
		books = new Book[CAPACITY]; // books 배열 초기화
		top = 0;
	}

	public int getTop() { //게터
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
	public void sortBooksByTitle(){
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
	}
	public void sortBooksByISBN(){
		Arrays.sort(books, 0, top, (b1, b2) -> Integer.parseInt(b1.getIsbn()) - Integer.parseInt(b2.getIsbn()));
	}
	public Book searchBookByTitle(String title) {
	}
	public void printBooks(String book) {
		System.out.println("현재도서목록 : "+ book);	
		//for 문
		for(int i = 0; i<top; i++) {
			System.out.println(books[i].toString());//toString()호출
		}
	}
	public void removeBook(String book) {
	}
}


public class 실습11_1_예외처리_과제 {
	public static void main(String[] args) {
		try {
			String s = new String("java");
			System.out.println(s.length());
			s = null;
			System.out.println(s.length());
			int []arr = new int[2];
			arr[2] = 10;
		} catch(ArrayIndexOutOfBoundsException e1) {//교재534
			System.out.println("배열 색인 예외 발생");
			System.out.println(e1.getMessage());
		} catch(NullPointerException e2) {
			System.out.println("널 포인터 예외 발생");
			e2.printStackTrace();
		} catch(Exception e) {
			System.out.println("예외 발생");
		} finally {
			System.out.println("모든 것이 ok");//교재 543
			//할당된 자원을 자동으로 해제가 아니고 close(file)을 포함해야 한다
		}

		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("자바스크립트", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		// 예외 처리를 적용한 책 추가 및 삭제
		try {
			library.addBook(book1);
			library.addBook(book2);
			library.addBook(book3);
			library.addBook(book4);
			library.addBook(book5);

			// 도서관의 용량을 초과하여 책을 추가 (예외 발생)
			Book book6 = new Book("스프링", "이순신", 2020, "100");
			library.addBook(book6); // 이 부분에서 OverflowException 발생
		} catch (OverflowException e) {
			System.out.println(e.getMessage());
		}

		// 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		try {
			// 책 삭제
			library.removeBook(null); // 정상 삭제
			library.removeBook(null); // 정상 삭제
			library.removeBook(null); // 정상 삭제
			library.removeBook(null); // 정상 삭제
			library.removeBook(null); // 정상 삭제

			// 빈 도서관에서 책을 삭제 (예외 발생)
			library.removeBook(); // 이 부분에서 UnderflowException 발생
		} catch (UnderflowException e) {
			System.out.println(e.getMessage());
		}

		// 최종 도서 목록 출력
		library.printBooks("최종 도서 목록:");
	}
}
package com.ruby.java.ch12;

import java.io.Serializable;
import java.util.Arrays;

//Book 클래스
class Book {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book(String title, String author, int publicationYear, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
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
		return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
				+ "]";
	}

	public String getISBN() {
		return null;
	}

}


class Library implements Serializable{ 
	static final int CAPACITY = 5;  // 기본 용량을 5로 설정
	private Book[] books = new Book[CAPACITY]; 
	private int top;

	public void sortBooksByTitle(){
		Arrays.sort(books, 0, top, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
	}

	public void sortBooksByISBN(){
		Arrays.sort(books, 0, top, (b1, b2) -> Integer.parseInt(b1.getISBN()) - Integer.parseInt(b2.getISBN()));
	}

	public void searchBookByTitle(String title) {

	}

	public void addBook(Book book) {
		books[top] = book;
		top++;
	}



	public void printBooks(String string) {
		System.out.println(string);
		for(Book b : books) {
			System.out.println(b);
		}
	}
}
public class 실습12_1_입출력_과제 {

	private static void saveLibrary(실습12_1_입출력_과제 library, String filename) {
	}

	private static Library loadLibrary(String string) {
		return null;
	}

	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 배열 저장
		library.addBook(new Book("자바", "강감찬", 1995, "12"));
		library.addBook(new Book("파이썬", "이순신", 2008, "9"));
		library.addBook(new Book("자바스크립트", "을지문덕", 2008, "8"));
		library.addBook(new Book("자료구조", "연개소문", 1994, "45"));
		library.addBook(new Book("리액트", "김춘추", 1999, "7"));

		// 현재 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		// 라이브러리 저장
		//			saveLibrary(library, "library.dat");
		//
		//			System.out.println("-".repeat(80));
		//
		//			Library lib = loadLibrary("library.dat");
		//
		//			// 최종 도서 목록 출력
		//			lib.printBooks("최종 도서 목록:");
		//			

	}
}
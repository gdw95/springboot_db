package exam.examc4;

import java.util.ArrayList;

interface MediaBook {
	String getMediaType();
}


class Book implements MediaBook, Comparable<MediaBook> {
	private String title; 
	private String author; 
	private int publicationYear; 
	private String isbn;
	@Override 
	public int compareTo(MediaBook mbook) {
	}
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
}


class CDBook implements MediaBook, Comparable<MediaBook> {
	private String title;
	private String artist;
	private String catalogNumber;

	@Override 
	public int compareTo(MediaBook mbook) {
	}

	public CDBook(String title, String artist, String catalogNumber) {
		super();
		this.title = title;
		this.artist = artist;
		this.catalogNumber = catalogNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	@Override
	public String toString() {
		return "CDBook [title=" + title + ", artist=" + artist + ", catalogNumber=" + catalogNumber + "]";
	}

}


class USBBook implements MediaBook, Comparable<MediaBook> {
	private String title; 
	private int capacity; 
	private String serialNumber;
	
	public USBBook(String title, int capacity, String serialNumber) {
		super();
		this.title = title;
		this.capacity = capacity;
		this.serialNumber = serialNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	@Override
	public String toString() {
		return "USBBook [title=" + title + ", capacity=" + capacity + ", serialNumber=" + serialNumber + "]";
	} 



}
class Library<T extends MediaBook> {
	private ArrayList<T> items; 
	private int capacity;

	public Library(ArrayList<T> items, int capacity) {
		super();
		this.items = items;
		this.capacity = capacity;
	}
	public ArrayList<T> getItems() {
		return items;
	}
	// 항목 추가 
		public void addItem(T item) {
			if(items.size() < capacity) {
				items.add(item);
			} else {
				System.out.println("가득 찼습니다.");
			}
		
		}
	public void setItems(ArrayList<T> items) {
		this.items = items;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	// 항목 삭제 
	public void removeItem(T item) {
		if (items.remove(item)) {
            System.out.println(item + "이(가) 제거되었습니다.");
        } else {
            System.out.println(item + "을(를) 찾을 수 없습니다.");
        }
	}
	
	@Override
	public String toString() {
		return "Library [items=" + items + ", capacity=" + capacity + "]";
	}



//Main 클래스
	public class ExamC4 {

		public static void main(String[] args) {

			Library<MediaBook> library = new Library<MediaBook>(); 

			// 5개의 item 객체 초기화 및 추가
			library.addItem(new Book("자바", "강감찬", 1995, "1234567890"));
			library.addItem(new Book("파이썬", "이순신", 2008, "1234567891")); 
			library.addItem(new Book("자바스크립트", "을지문덕", 2008, "1234567892"));
			library.addItem(new Book("자료구조", "연개소문", 1994, "1234567893")); 
			library.addItem(new Book("리액트", "김춘추", 1999, "1234567894"));		
			library.addItem(new CDBook("노래1", "나훈아", "3333"));
			library.addItem(new CDBook("노래2", "남진", "2222"));
			library.addItem(new CDBook("노래3", "홍길동", "1111"));
			library.addItem(new USBBook("데이터1", 2000, "ABCD1234"));
			library.addItem(new USBBook("데이터2", 1000, "ABCD1235"));
			library.addItem(new USBBook("데이터3", 3000, "ABCD1235"));

			library.printItems();
			System.out.println("=".repeat(80));

			library.removeBook();
			library.removeBook();
			library.removeBook();
			library.printItems();
		}
	}

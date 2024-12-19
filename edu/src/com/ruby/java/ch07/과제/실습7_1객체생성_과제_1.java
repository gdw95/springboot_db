package com.ruby.java.ch07.과제;

class Item { // 제품 클래스
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

	// 생성자1
	public Item(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	// 접근자 메소드
	public int getStockQuantity() {
		return stockQuantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	// 재고 감소 메소드1
	public void reduceStock(int quantity) {
		if (quantity > stockQuantity) {
			System.out.println("재고가 부족합니다.");
		} else {
			stockQuantity -= quantity;
		}
	}

	// 재고 증가 메소드2
	public void increaseStock(int quantity) {
		quantity += stockQuantity;
	}

	// 정보 출력 메소드3
	public void show() {
		System.out.println("제품명="+name+","+"가격="+price+"재고량="+stockQuantity);
	}

	@Override //오버라이드1
	public String toString() {

	}
}

class Customer { //고객 클래스
	private String cname;
	private String city;
	private int age;

	// 생성자1
	public Customer(String cname, String city, int age) {

	}

	// 정보 출력 메소드1
	public void show() {

	}

	@Override// 오버라이드1
	public String toString() {

	}
}

class Order { //주문 클래스
	private Customer customer; // 고객
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String []orderDates;
	private int count; // 아이템 개수

	// 생성자1
	public Order(Customer customer, int maxItems) {
		items = new items[maxitems]

	}//maxItems는 배열의 사이즈를 의미함. 

	// 아이템 추가 메소드1
	public void addItem(Item item, int orderQuantity, String date) {

	}

	// 총액 계산 메소드2
	public double calculateTotal() {

	}

	// 주문 요약 출력 메소드3
	public void printOrderSummary() {

	}
}
public class 실습7_1객체생성_과제_1 {
	public static void main(String[] args) {
		// 아이템 생성
		Item laptop = new Item("노트북", 1200.00, 10);
		Item tshirt = new Item("티셔츠", 20.00, 50);
		Item phone = new Item("휴대폰", 800.00, 30);
		Item headphones = new Item("헤드폰", 150.00, 20);
		Item mouse = new Item("마우스", 30.00, 15);

		// 고객 생성
		Customer boy = new Customer("홍길동", "부산", 21);
		Customer girl = new Customer("계백", "양산", 22);

		// 주문 생성
		Order order1 = new Order(boy, 5); // 최대 5개 아이템
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);
		order1.addItem(phone, 1);
		order1.addItem(headphones, 1);
		order1.addItem(mouse, 1);

		Order order2 = new Order(girl, 5); // 최대 5개 아이템
		order2.addItem(laptop, 1);
		order2.addItem(tshirt, 1);
		order2.addItem(phone, 1);
		order2.addItem(headphones, 1);
		order2.addItem(mouse, 1);

		// 주문 요약 출력
		order1.printOrderSummary();
		order2.printOrderSummary();

	}
}
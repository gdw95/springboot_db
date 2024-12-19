package com.ruby.java.ch07.과제;

class Item { // 제품
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

	// 생성자
	public Item(String name, double price, int stockQuantity) {
		this.name=name;
		this.price=price;
		this.stockQuantity=stockQuantity;
	}

	// 재고 감소 메소드
	public void reduceStock(int quantity) {
		if (quantity > stockQuantity) {
			System.out.println("재고가 부족합니다.");
		} else {
			stockQuantity -= quantity;
		}
	}

	// 재고 증가 메소드
	public void increaseStock(int quantity) {
		quantity += stockQuantity;
	}

	// 정보 출력 메소드
	public void show() {
		System.out.println("제품명="+name+","+"가격="+price+"재고량="+stockQuantity);
	}

	@Override
	public String toString() {
		return "제품명="+name+","+"가격="+price+"재고량="+stockQuantity;
	}

	// 접근자 메소드
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
}

class Customer {
	private String cname;
	private String city;
	private int age;

	// 생성자
	public Customer(String cname, String city, int age) {
		this.cname=cname;
		this.city=city;
		this.age=age;
	}

	// 정보 출력 메소드
	public void show() {
		System.out.println("고객명= "+cname+", "+"도시명= "+city+", "+"나이= "+age);
	}

	@Override
	public String toString() {
		return "고객명= "+cname+", "+"도시명= "+city+", "+"나이= "+age;
	}
}

class Order {
	private Customer customer; // 고객
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String []orderDates;
	private int count; // 아이템 개수

	// 생성자
	public Order(Customer customer, int maxItems) {
		this.customer= customer;
		items = new Item[maxItems];
		quantities = new int [maxItems];
		count = 0;

	}//maxItems는 배열의 사이즈를 의미함. 

	// 아이템 추가 메소드
	public void addItem(Item item, int orderQuantity) {
		if (count < items.length) {
			items[count] = item;
			quantities[count] = orderQuantity;
			item.reduceStock(orderQuantity);
			count++;
		} else {
			System.out.println("주문할 수 있는 최대 아이템 수를 초과했습니다.");
		}
	}

	// 총액 계산 메소드
	public double calculateTotal() {
		double total = 0;
		for (int i = 0; i < count; i++) {
			total += items[i].getPrice() * quantities[i];
		}
		return total;
	}

	// 주문 요약 출력 메소드
	public void printOrderSummary() {
		System.out.println("주문 요약: ");
		customer.show();
		for (int i = 0; i < count; i++) {
			System.out.println(items[i].getName() + " - 수량: " + quantities[i] + ", 가격: " + (items[i].getPrice() * quantities[i]));
		}
		System.out.println("총액: " + calculateTotal());
		System.out.println();
	}
}

public class 실습7_1객체생성_과제 {
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
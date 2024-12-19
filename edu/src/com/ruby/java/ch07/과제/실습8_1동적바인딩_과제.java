package com.ruby.java.ch07.과제;


//2단계 - 문제 4: 동적바인딩
//Item 추상 클래스
abstract class Item1 { //제품 클래스
	private String name;    // 제품명
	private double price;   // 제품 가격
	private int stockQuantity; // 재고량

	// 생성자
	public Item1(String name, double price, int stockQuantity) {
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	//시스아웃 메소드()
	public void show() {
		System.out.println("제품명= "+name);
	}
}

//Electronics 클래스: Item 클래스 상속
class Electronics1 extends Item1 {
	int madeYear;
	//생성자
	public Electronics1(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear = madeYear;
	}
	public int getMadeYear() {
		return madeYear;
	}

	//오버라이드 메소드()
	@Override 
	public void show() {
		super.show();
		System.out.println("제조년도= "+madeYear);
	}
}


//Clothing 클래스: Item 클래스 상속
class Clothing1 extends Item1 {
	int size;
	//생성자 
	public Clothing1(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size = size;
	}
	//Getter
	public int getSize() {
		return size;
	}
	//오버라이드 메소드()
	@Override 
	public void show() {
		super.show();
		System.out.println("사이즈= "+size);
	}
}

//Discountable1 인터페이스 정의
interface Discountable1 {
	 public double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable1 인터페이스 구현
class SeasonalDiscount1 implements Discountable1 {
	private double discountRate;
	
	public double getDiscountedPrice(double price){
		return price*discountRate;
	}
	//생성자
	public SeasonalDiscount1(double discountRate) {
		this.discountRate = discountRate;
	}
	
}
//Order 클래스
class Order1 extends SeasonalDiscount1{
	private final int N = 20;
	private Customer customer; // 고객명
	private Item[] items;      // 주문 제품들
	private int[] quantities;  // 주문 제품 수량들
	private String[] orderDates; // 주문일자들 
	private int count = 0;
	
	//생성자
	public Order1(Customer customer, int numOrders) {//배열 유의
		super(0.5);//상위클래스 값 들고와야함
		this.customer = customer;
		items = new Item[numOrders];
		quantities = new int [numOrders];
		orderDates = new String [numOrders];
		this.count = 0;
	}
}

//Customer 추상 클래스 정의
abstract class Customer1 {
	private String name;


	abstract double applyDiscount(double totalAmount);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer1 extends Customer1 {
	static final double REGULARDISCOUNT_RATE = 0.03;

}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer1 extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;


}
public class 실습8_1동적바인딩_과제 {
	public static void main(String[] args) {
		// Item 타입의 배열 생성
		Item1[] items = new Item1[4];

		// 배열에 전자제품과 의류패션 객체 추가
		items[0] = new Electronics1("노트북", 1500, 24, 23);
		items[1] = new Clothing1("티셔츠", 50, 50, 95);
		items[2] = new Electronics1("휴대폰", 800, 12, 24);
		items[3] = new Clothing1("청바지", 80, 30, 90);

		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item1 item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}

		// 고객 생성 
		Customer1 regularCustomer = new RegularCustomer("홍길동");
		Customer1 premiumCustomer = new PremiumCustomer("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order1 regularOrder = new Order(regularCustomer);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");

		regularOrder.printOrderSummary();

		// 주문 생성 및 계산 (PremiumCustomer)
		Order1 premiumOrder = new Order(premiumCustomer);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");

		premiumOrder.printOrderSummary();
		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item1 item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}
	}
}
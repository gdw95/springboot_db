package com.ruby.java.ch07.과제;

//Item 클래스
class Item2 {
	private String name;
	private double price;
	private int stockQuantity;

	//생성자
	public Item2(String name, double price, int stockQuantity){
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

}

//Electronics 클래스 (Item 클래스를 상속)
class Electronics extends Item2 {
	private int warranty; // 제품 보증 기간


	//생성자 만들기
	public Electronics(String name, double price, int stockQuantity, int warranty) {
		super(name, price, stockQuantity);
		this.warranty = warranty;
	}

	public int getWarranty() {
		return warranty;
	}

}


//Clothing 클래스 (Item 클래스를 상속)
class Clothing extends Item2 {
	private String size;
	private String color;

	public Clothing(String name, double price, int stockQuantity, String size, String color) {
		super(name, price, stockQuantity);
		this.size = size;
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

}
//Customer 추상 클래스 정의
abstract class Customer2 {
	private String cname;
	private String city;
	private int age;

	public Customer2(String cname, String city, int age) {
		this.cname = cname;
		this.city = city;
		this.age = age;
	}

	public String getCname() {
		return cname;
	}

	public String getCity() {
		return city;
	}

	public int getAge() {
		return age;
	}

	abstract double applyDiscount(double totalAmount);
}



//RegularCustomer 클래스: Customer 클래스를 상속받음 //Customer 클래스가 추상클래스이므로, 상속받는 자식클래스는 추상메서드를 오버라이딩해주어야함. 안하면 추상으로 선언
class RegularCustomer extends Customer2 {
	static final double REGULARDISCOUNT_RATE = 0.03;
	public RegularCustomer(String cname, String city, int age) {
		super(cname, city, age);
	}
	@Override 
	double applyDiscount(double totalAmount) {
		return totalAmount * REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer2 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;
	public PremiumCustomer(String cname, String city, int age) {
		super(cname, city, age);
	}
	@Override 
	double applyDiscount(double totalAmount) {
		return totalAmount * PREMIUMDISCOUNT_RATE;
	}
}


//Order 클래스
/*
 * Order2(),addItem()
 * calculateTotal(),calculateDiscountedTotal(), printOrderSummary()
 */
class Order2 {
	private Customer2 customer;
	private Item2[] items;
	private int[] quantities;
	private int itemCount;

	// 생성자
	public Order2(Customer2 customer, int maxItems) {
		this.customer = customer;
		this.items = new Item2[maxItems];
		this.quantities = new int[maxItems];
		this.itemCount = 0;
	}
	// addItem() 생성자
	public void addItem(Item2 item, int quantity) {
		if (itemCount < items.length) {
			items[itemCount] = item;
			quantities[itemCount] = quantity;
			itemCount++;
		} else {
			System.out.println("Cannot add more items. Maximum limit reached.");
		}
	}
	//calculationTotal() 생성자 
	public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice() * quantities[i];
        }
        return total;
    }
	//calculateDiscountedTotal()생성자
	public double calculateDiscountedTotal() {
        double total = calculateTotal();
        return total - customer.applyDiscount(total);
    }
	//printOrderSummary()생성자
	 public void printOrderSummary() {
	        System.out.println("Customer: " + customer.getCname());
	        System.out.println("City: " + customer.getCity());
	        System.out.println("Age: " + customer.getAge());
	        System.out.println("Items:");
	        for (int i = 0; i < itemCount; i++) {
	            System.out.println(items[i].getName() + " - " + quantities[i] + " x $" + items[i].getPrice());
	        }
	        System.out.println("Total: $" + calculateTotal());
	        System.out.println("Discounted Total: $" + calculateDiscountedTotal());
	        System.out.println();
	    }
	}
	


public class 실습7_2클래스생성_과제 {
	public static void main(String[] args) {
		// 의류 및 전자제품 생성
		Electronics laptop = new Electronics("노트북", 1200.00, 10, 24);
		Electronics phone = new Electronics("휴대폰", 800.00, 30, 12);
		Clothing tshirt = new Clothing("티셔츠", 20.00, 50, "M", "Blue");
		Clothing jacket = new Clothing("자켓", 80.00, 20, "L", "Black");

		// 고객 생성
		PremiumCustomer premiumCustomer = new PremiumCustomer("홍길동", "부산", 30);
		RegularCustomer regularCustomer = new RegularCustomer("계백", "양산", 25);//생성자 잘 만들어야 오류가 안 남.

		// 주문 생성
		Order2 order1 = new Order2(premiumCustomer, 4);
		order1.addItem(laptop, 1);
		order1.addItem(tshirt, 2);

		Order2 order2 = new Order2(regularCustomer, 4);
		order2.addItem(phone, 1);
		order2.addItem(jacket, 1);

		// 주문 요약 출력
		System.out.println("Premium Customer Order:");
		order1.printOrderSummary();

		System.out.println("Regular Customer Order:");
		order2.printOrderSummary();
	}
}
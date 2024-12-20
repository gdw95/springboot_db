package com.ruby.java.ch07.abstraction;//p.309, p328

abstract class Employee {
	String name;
	int salary;
	
	public abstract void calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Employee{
	public void calcSalary() {
		System.out.println("Salesman 급여 =  기본급 + 판매 수당");
	}
	
	public void calcBonus() {
		System.out.println("Salesman 급여 =  기본급 *12*4");
	}

}
class Consultant extends Employee{
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}
	
	public void calcBonus() {
		System.out.println("Conalutant 급여 =  기본급 *12*2");
	}
}


abstract class Manager extends Employee{
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

class Director extends Manager{
	public void calcBonus() {
		System.out.println("Direstor 보너스 = 기본급 *12*6");
	}
}

public class HRSTest{
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
//		Manager m = new Manager();
		
		s.calcBonus();
		c.calcBonus();
		d.calcBonus();
//		m.calcSalary();
	}
}

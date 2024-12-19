package chapter5;
class Person2 {
	private String name;
	private int age;
	private float weight;
    // 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언
	 * 교재 p198 Armor.java 참조
	 */
    // name 메소드: setter, getter 함수, 교재 p199
    public void setName(String name) {
        this.name = name;
    }
    public void setName(int age) {
        this.age = age;
    }
    public void setName(float weight) {
        this.weight = weight;
    }
    public void getName(String name) {
    	this.name = name;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    public void setWeight(float weight) {
    	this.weight = weight;
    }
    
    // age 메소드:setter, getter 함수 구현, 교재 p199
    
    // weight 메소드: setter, getter 함수 구현, 교재 p199

    // 이름, 나이, 몸무게를 출력하는 show 메소드


    // 오버로딩된 show 메소드 (message를 출력)
    public void show(String msg) {
        System.out.println("메시지 = " + msg);
        System.out.println("이름 = " + name +", 나이="+ age+",몸무게="+weight);
        // 이름, 나이, 몸무게를 출력하는 코드 작성
        // 이름=**, 나이=**, 몸무게=**
    }
    public void show() {
    	System.out.println("name = " + name +", age="+ age+",weight="+weight);
        // 이름, 나이, 몸무게를 출력하는 코드 작성
        // 이름=**, 나이=**, 몸무게=**
    }
}
public class 실습5_2메소드오버로딩 {
	    public static void main(String[] args) {
	        // 객체 생성
	        Person2 p = new Person2();
	        //p.name = "홍길동";
	        p.setName("홍길동");
	        p.setAge(25);
	        p.setWeight(62.123f);
	        //다음 코드를 디버깅
	        //System.out.println("이름 = " + name + ", 나이 = " + age + ", 몸무게 = " + weight);

	        // 메소드 호출
	        p.show();
	        p.show("오버로딩");
	    }
	}


package chapter5;
class Armor{//클래스 정의
	String name;//field 필드 정의. 객체는 필드가 있어야함.private String name;->main의 mark.name에 name오류.Armor.name is not visible.
	int height;//필드
	int weight;//필드
	int speed;//필드
	int speedUp(int value) {
		speed+= value;
		return speed;
	}
}
//	public void speedUp(int value) {//메소드 정의. void는 해당 함수의 리턴값이 없다는 의미.	
//		speed=value;
//	}//int 는 return으로 값 돌려주기
//아머 마크16으로 마크16객체, 마크16.takeoff 참조변수마크16가 객체를 가르키고있고 메소드toff를 불러서 구한다.


class Person {
	String name;
	int age;
	float weight;	
    // 필드
	/*
	 * name은 String, age는 int, weight는 float로 필드 선언
	 */
    // 메소드
    void show() {
    	System.out.println("name ="+ name);
    	System.out.println("age ="+ age);
    	System.out.println("weight ="+ weight);
    	/*
    	 * name=**, age = **, weight = ** 형태로 출력
    	 */
		/*
//         * [강감찬, 55, 62.34] 객체를 만들어
//         * name=**, age = **, weight = ** 형태로 출력
//         */
    }
}

public class 실습5_1클래스객체 {	
	    public static void main(String[] args) {
	        // 객체 생성
	    	int a=10;
	    	int arr[]=new int[5];//int는 자바제공 예약어
	    	Armor mark16=new Armor();//아머는 내가만든 클래스, 아머()는 객체를 만드는 역할을하는 생성자
	    	int maxSpeed= mark16.speedUp(10);
	    	mark16.name="강감찬";//참조변수4바이트와 기본데이터의 차이를 알아야함. 강감찬6바이트은 스트링리터럴(문자상수)
	    	//mark16.takeOff();//참조변수 마크16 takeoff라는 메소드호출
	    	
	        Person p = new Person();//p는 참조변수
	        p.name = "강감찬";
	        p.age = 55;
	        p.weight = 62.34f;
	        // 메소드 호출
	        p.show();	    	                
	    }
	}
	



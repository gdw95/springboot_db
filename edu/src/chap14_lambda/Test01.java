package chap14_lambda;
interface MyInterface {
	public void print();//프린트함수를 구현할것을 요구, 추상함수 print ()
}
class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("myclass1");
	}
}
public class Test01 {
	public static void main(String[] args) {
		MyClass1 mc1 =  new MyClass1();
		mc1.print();
		
		MyInterface mi = new MyInterface() {//하나의 문장 //인터페이스의 참조변수 mi 가 인터페이스를 생성->불가능하나 익명함수. 자바컴파일러가 처리
			@Override
			public void print() {
				System.out.println("익명클래스");
			}
		};//세미콜론
		mi.print();//익명함수를 불러서 사용가능해짐
		
		new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스2");
			}
		}.print();//도 가능->가비지
	}
}
//익명함수의 소스코드는 변수값이므로 끝에 세미콜론을 대입함. 익명함수는 호풀 시 변수명을 함수명처럼 사용하면 됨, 인터페이스에 객체를 한번만들고 버릴때 익명함수사용(1회용 클래스). 계속사용할때는 사용하지않는다.
//함수이름이없는 함수(익명함수), 함수명을 신경쓰지않는다.: 람다함수 -간결한코딩
//람다식은 메소드 하나.p666 function 인터페이스는 메소드가 오직 하나.
//p675 람다식 인자, 파라미터로도 전달이 가능.
//p697 (Function 제네릭으로제공 설명부분)
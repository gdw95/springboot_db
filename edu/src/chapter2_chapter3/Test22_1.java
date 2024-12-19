package chapter2_chapter3;//스위치문은 조건식의 값에따라 해당 케이스 값을 실행, 케이스 값 이외의 값은 디폴트 값.

public class Test22_1 {
	public static void main(String[] args) {
		int a=12;
		int b=2;
		char op='+';
		
		switch(op) {
		case '+':
			System.out.println(a+b);break;
		case '-':
			System.out.println(a-b);break;
		case '*':
			System.out.println(a*b);break;
		case '/':
			System.out.println(a/b);break;
	
		}
	}
}
//논리적 오류를 항상 조심. 스위치 케이스 브레이크 디폴트

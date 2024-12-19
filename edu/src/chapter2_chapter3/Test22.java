package chapter2_chapter3;//스위치문은 조건식의 값에따라 해당 케이스 값을 실행, 케이스 값 이외의 값은 디폴트 값.

public class Test22 {
	public static void main(String[] args) {
		int a=12;
		int b=2;
		char op='+';
		
		switch(op) {
		case '+':
			System.out.println(a+b);
		case '-':
			System.out.println(a-b);
		case '*':
			System.out.println(a*b);
		case '/':
			System.out.println(a/b);
	
		}
	}
}

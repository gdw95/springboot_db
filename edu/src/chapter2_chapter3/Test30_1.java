package chapter2_chapter3;

public class Test30_1 {
	public static void main(String[] args) {		
		for (int i = 1; i <= 100; i++) {
			if ((i % 2) == 0) {
				System.out.println(i);
			}
			System.out.println(i + "은 2와 3의 공배수입니다");

			if ((i % 3) == 0) {
				System.out.println(i);
			}
			System.out.println(i + "은 2와 3의 공배수입니다");
		}
	}
//if문 중첩
//코드 블럭
//int cnt =0
//for (int i = 1; i <= 100; i++) {
//	if ((i % 2==0 && i%3==0) {
//		System.out.println(i+"2/3 공배수");
//		cnt++;
//	}
//	System.out.println(i + "Count:" +cnt);
//}
}
//반복문 중첩
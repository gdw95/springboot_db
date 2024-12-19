package chapter2_chapter3;

public class Test30_2 {
	public static void main(String[] args) {
		int cnt =0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2==0 && i%3==0) {
				System.out.println(i+"2/3 공배수");
				cnt++;
			}

			System.out.println(i + "Count:" +cnt);
		}
		}
	}
//미완

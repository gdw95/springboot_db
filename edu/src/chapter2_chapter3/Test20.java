package chapter2_chapter3;

public class Test20 {
	public static void main(String[] args) {
		int score=90;
		char grade;
		
		if(score>=80) {
			grade='A';
		}else if(score>=80) {
			grade='B';
		}else if(score>=70) {
			grade='C';
		}else if(score>=60) {
			grade='D';
		}else {
			grade='F';
		}
		System.out.println(grade);
	}
}
//스캐너 사용해볼것
package chapter2_chapter3;

public class 실습2과제_변수입출력 {
	public static void main(String[] args) {
		int depositAmount;
		depositAmount=50000;
		System.out.println(depositAmount);
	}
}
//성과목표:변수를 사용하여 입출력문  작성할 수 있는 능력
//
//1. 학생의 이름과 과목은 문자열로 입력받고, 성적은 정수로 입력받아 console에 출력하는 프로그램 작성
//
//2. 출력 형태는 "이름 =  ***, 과목 = ***, 성적 = **, 통과 = **". 
//
//3. 통과여부는 문자열로 성적 점수가 60점 이상이면 "합격", 미만이면  "과락"으로 표현하며 삼항연산자를 사용한다. 
//
//4. 입력을 위한 변수 선언과 사용은 다음과 같다.
//
// Scanner sc = new Scanner (System.in);
//
// int n = sc.nextInt(); //정수일 때
//
//String st = sc.next(); //문자열일 때
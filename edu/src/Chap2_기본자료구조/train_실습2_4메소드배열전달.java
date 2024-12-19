package Chap2_기본자료구조;
/*
 * 2장과제1: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */

import java.util.Random;
public class train_실습2_4메소드배열전달 {
	static int top = 0;//배열에 저장된 요소의 수
	static final int MAX_LENGTH = 20;//배열 최대 길이
	public static void main(String[] args) {
		int []data = new int[10];//크키가 10인 배열 생성
		inputData(data);//배열에 데이터 입력
		showData("소스데이터",data);//원본 데이터 풀력
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);//값 3의 존재 여부 확인
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 변경
		showData("역순 데이터", data);//역순 데이터 출력
		
	}
	
	//확장형 for 문-> for (데이터타입 요소 : 배열 또는 컬렉션) { 요소에 대한 작업 };
   
	
	//top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성
	static void showData(String a, int []data) {
		System.out.print(a + "[");
		for(int n: data) {
			System.out.print(n + ", ");
		}
		System.out.println("]");
	}

	static void inputData(int[] arr) {//교재 63 - 난수의 생성
		//top 이 배열에 저장된 갯수를 저장
		Random random = new Random();
		int len = arr.length;
		for (int i = 0; i <len ; i++) {
			arr[i] = random.nextInt(10);//0부터 9까지의 난수
		}
		System.out.println();
	}
	static int findMax(int[] data) {
		int max = data[0];
		for (int n: data) {
			if(n > max) {
				max = n;
			}
		}
		return max;//최대값을 리턴한다 
	}
	
	//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false 로 리턴
	static boolean findValue(int[] data, int value) {
		for(int i= 0; i < top; i++) {
			if(data[i] == value) {
			}
		}
		return true;
	}
	
	static void reverse(int []data) {
		for(int i = 0; i <top/2; i++) {//swap(data, i, top -1 -i);
			for()
		}
	}
	//swap(data, i, j)//배열, 인덱스, 인덱스. 알고리즘코딩: 함수를간단히만들고 내가만든 함수를 사용해서 알고리즘 구현
	static void swap(int[] data, int i, int j){
		
	}
}

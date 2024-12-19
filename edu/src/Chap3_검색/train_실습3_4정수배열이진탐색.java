package Chap3_검색;
/*
* 3장 1번 실습과제: 03-3 정수배열이진검색
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
* 3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class train_실습3_4정수배열이진탐색 {
static void inputData(int []data) {
	Random rand = new Random();
	for (int i=0; i<data.length; i++) {
		data[i] = rand.nextInt(100);
	}
}

static void showList(String msg, int []data) {
	System.out.println(msg + "=" + Arrays.toString(data));
	for (int a: data)
		System.out.print(a + " ");
}

static int linearSearch(int []data, int key) {//선형 검색
	//요솟수가 n 인 배열 data 에서 key 와 값이 같은 요소를 선형 검색
	
	int i = 0;
	
	while(true) {
		if (i == data.length)
			return -1; //검색실패(-1 반환)
		if (data[i] == key)
			return i; //검색성공(인덱스 반환)
		i++;
	}
}

static int binarySearch(int []data, int key) {//이진 검색
	//요솟수가 n 개인 배열 data 에서 key 와 같은 요소를 이진검색
	int pl = 0;
	int pr = data.length -1;
	
	do {
		int pc = (pl + pr) / 2;
		if (data[pc] == key)
			return pc;
		else if (data[pc] < key)
			pl = pc + 1;
		else 
			pr = pc -1;
	}while (pl <= pr);
	
	return -1;
}

	public static void main(String[] args) {
		Random rand = new Random();
		int []data = new int[30];
		inputData(data);// 구현 반복 숙달 훈련 - 100 이하 난수를 생성

		showList("정렬 전 배열[]:: ", data);
		Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = rand.nextInt(10);

		int resultIndex1 = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search 는 없기 때문에 구현해야 한다 
		System.out.println("\nlinearSearch1(13): key = " + key + ", result = " + resultIndex1);

		/*
		 * 교재 109~113
		 */
		resultIndex2 = binarySearch(data, key);//함수 구현이 필요
		System.out.println("\nbinarySearch2(19): key = " + key + ", result = " + resultIndex2);
		
		//key = 난수 입력;
		int key = rand.nextInt(10);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		Arrays.binarySearch;
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);

	}
}

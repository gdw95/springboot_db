package Chap2_기본자료구조;
/*
 * 2장 - 정수 배열 정렬
 */
import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class 실습2_5정수배열정렬_수정 {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("난수 입력", data);
		/*
		sortData(data);
		showData("정렬후", data);
		*/
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 재배치", data);

		//reverseSort(data);//역순으로 재배치 - 정렬 아님 
		//showData("역순 정렬후", data);
		sortData(data);
		int realData = 15;
		int []result = insertData(data, realData);//입력 실수보다 큰 숫자를 우측으로 이동
		showData("실수 삽입후", result);
	}
	
	static void showData(String msg, int[]data) {
		System.out.println(msg + "=" + Arrays.toString(data));
		for (int a: data)
			System.out.print(a + " ");
	}
	static void inputData(int []data) {
		Random rand = new Random();
		
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(20);
			
		}
	}
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		int t = arr[ind1]; arr[ind1] = arr[ind2]; arr[ind2] = t;
	}
	static void sortData(int []arr) {
		Arrays.sort(arr);
	}
	static void reverse(int[] a) {//교재 67페이지
		for (int i = 0; i < a.length / 2; i++)
			swap(a, i, a.length - i - 1);
	}
	//static void reverseSort(int []arr) {
		
	//}
	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 */
	static int[] insertData(int []data, int value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length+1];
		
	}


}

package Chap2_기본자료구조;

import java.util.Arrays;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert 하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class 실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "pear","blueberry", "strawberry", 
				"melon", "oriental melon"};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		//Arrays.sort();인터페이스 구별할 줄 알아야함. 2장, 3장 참고. 
		//Arrays.sort(Object[] a)-> compareTo() 오버라이드
		Arrays.sort(data);
		//String[] newData = insertString(data, "banana");//배열이초기화되어있으므로 추가하기위해선 새로 선언해야함
		showData("삽입후 크기가 증가된 정렬 배열", data);
		
	}
	static void showData(String msg, String[] data) {//확장된 for 문으로 출력 
		//정렬 전
		System.out.println(msg + "=" + Arrays.toString(data)); 
//		System.out.print(msg + "[");
//		for (String n: data) {
//			System.out.print(n + ", ");
//		}
//		System.out.println("]");
	}

	static void swap(String[]data, int ind1, int ind2) {//스트링의 맞교환 함수로 sortData()에서 호출됨
		String t = data[ind1]; data[ind1] = data[ind2]; data[ind2] = t;
	}
	
	static void sortData(String []data) {//올림차순으로 정렬 - for 문을 사용하여 직접 구현한다 
		//정렬 후
		//Arrays.sort(data);
		//System.out.println("정렬후" + "=" + Arrays.toString(data));
		
		//버블정렬
		for (int i = 0; i < data.length; i++) {
			for(int j = i+1; j < data.length; j++)
				if(data[i].compareTo(data[j])>0)
					swap(data, i, j);
		}
			}
		
	
//	static String insertString(){//배열의 사이즈를 1개 증가시킨후 insert 되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
//		return ;
//	}
}
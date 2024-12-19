package Chap2_기본자료구조;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */

//객체들을 정렬할때 compartTo();를 구현할 줄 알아야함.
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	@Override
	public String toString() {//Object 클래스 상속
		return name + " " + height + " " + vision;
	}
	@Override
	public int compareTo(PhyscData p) {
		//return name.compareTo(p.name);//데이터타입 주의
		//return (int)(vision - p.vision);
		if (vision > p.vision) {
			return 1;
		}else if (vision < p.vision){
			return -1;
		}else {
			return 0;
		}
	}
	
	public boolean equals(Object ob) {//Object 클래스 상속
		 PhyscData p = (PhyscData) ob;
		return true;
	}
}

public class train_실습2_14_1객체배열정렬 {
	static void swap(String string, int i, double d) {
		
	}
	static void sortData() {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		//compareTo()를 사용하여 구현
	}
	static void binarySearch() {
		//if (data[i].equals(key)) ***으로 구현
		
	} //equals()를 사용하여 구현
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7),
				new PhyscData("사이다", 172, 0.3),
				new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2),
				new PhyscData("다정해", 169, 0.5),
		};
		static void showData("정렬전",data);
		//sortData(data);->내가 구현해보기
		
		static void showData("정렬후", data);
		//Arrays.sort(data);
		int resultIndex = binarySearch(data, "사이다");
		PhyscData[] newData= insertObject(data, new PhyscData("소주다", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
		static void showData("삽입후", newData);
		
	}
	
	static void showData(String msg, String[] data) {
		//정렬 전
		System.out.println(msg + "=" + Arrays.toString(data));
	}
	
	static void sortData(PhyscData) {
		//정렬 후
		
	}

	static void insertObject(){//배열의 사이즈를 1개 증가시킨후 insert 되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
		
	}

}

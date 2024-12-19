package chapter2_chapter3;

public class Test31_1 {
	public static void main(String[] args) {
		System.out.println("##2단##\t\t##3단##\t\t##4단##\t\t##5단##\t\t##6단##\t\t##7단##\t\t##8단##\t\t##9단##\t\t");
		for(int i = 1; i <= 9; i++) { //i = 각 단 안에서 1~9까지 반복되는 수
			System.out.println("");
			for(int j = 2; j <= 9; j++) { //j = 단수 (2단 ~ 9단)
				System.out.print(j + " x " + i + " = " + j * i + "\t");
			}
		}
	}
		
	}
//어떤 것을 outter, inner로 잡을 지 
//outter가 1단계 끝나는 것으로 잡는다고 생각하면 편함(1~9), inner을 단수로(2단~9단)
//j에 해당하는 구문을 i*j에서 j*i로 바꾸었음

package Chap6_Sorting;
//https://gyoogle.dev/blog/algorithm/Insertion%20Sort.html
//selection sort에 비하여 성능 개선: 처리시간이 50% 감소
import java.util.Random;

//단순 삽입 정렬 - 6.4

import java.util.Scanner;

class 실습6_5InsertionSort {
	/*
	 * 단순 삽입(straight insertion) 정렬 
	 * 선택한 요소를 그보다 더 앞쪽의 알맞은 위치에 삽입
	 */

 static void insertionSort(int[] a, int n) {//코드를 이해하여 알고리즘을 파악한다.
	 int count = 0;
     for (int i = 1; i < n; i++) {
         int j;
         int tmp = a[i];//a[i]가 선택한 요소
         //선택한 카드의 좌측에 넣을 곳을 찾는다 
         for (j = i; j > 0 && a[j - 1] > tmp; j--) {//for 문에 조건을 달아둠 -> a[j-1]을 기준으로 이동
        	 count++;
        	 a[j] = a[j - 1];
         }
         count++;
         a[j] = tmp;//tmp를 insert한다 - 선택한 카드 a[i]를 왼쪽에 끼워 놓는다 
     }
     System.out.println("\n비교횟수 = " + count);
 }
 static void showData(int[] d) {
     for (int i = 0; i < d.length; i++)
         System.out.print(d[i] + " ");
 }
 public static void main(String[] args) {
     Scanner stdIn = new Scanner(System.in);

     System.out.println("단순 삽입 정렬");
   
     System.out.print("요솟수: ");
     int nx = stdIn.nextInt();
    
     int[] x = new int[nx];
     
     Random rand = new Random();

     for (int i = 0; i < nx; i++) {
    	x[i] = rand.nextInt(999);
     }
     System.out.println("정렬전:");
     showData(x);
     insertionSort(x, nx);        // 배열 x를 단순삽입정렬

     System.out.println("정렬후:");
     showData(x);
 }
}

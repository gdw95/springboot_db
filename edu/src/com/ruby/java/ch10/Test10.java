package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Test10 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();//디폴트 10
		list.add("서울"); list.add("북경"); list.add("상해");
		list.add("서울"); list.add("도쿄"); list.add("뉴욕");
		
		Vector<String> vec = new Vector<>();
		vec.add("abcd");
		
		
		for(int i =0; i <list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-".repeat(10));		

		for(String s : list) {//확장 for 문
			System.out.println(s);
		}
		list.add("런던"); list.add("로마"); list.add("방콕");
		list.add("북경"); list.add("도쿄"); list.add("서울");
		System.out.println("1 : "+ list.toString());//overflow


		//void add(int index, E element)
		list.add(1, "LA"); print(2, list);

		//int indexOf(Object o) / int lastIndexOf(Object o)
		System.out.println("3 : " + list.indexOf("서울"));
		System.out.println("4 : " + list.lastIndexOf("서울"));

		//boolean remove(Object o)
		list.remove("LA"); print(5, list);

		//E remove(int index)
		list.remove(2); print(5, list);

		//boolean contains(Object o)
		System.out.println("7 : " + list.contains("LA"));

		//Object[] toArray()
		Object obj[] = list.toArray();
		System.out.println("8 : " + Arrays.toString(obj));

		//<T> T[] toArray(T[] a )
		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("9 : "+ Arrays.toString(cities));

		//void clear()
		list.clear(); print(10, list);

		//boolean isEmpty()
		System.out.println("11 : " + list.isEmpty());

		list.add("파리");
		list.add("방콕");
		list.add("LA");

		// Arrays 클래스의 static <T> List<T> asList(T...a)
		List<String> list2 = Arrays.asList("서울", "뉴욕", "상해" );
		print(12, list2);

		//boolean addAll(Collection<? extends E> c)
		list.addAll(list2); print(13, list);
		
		

		//boolean addAll(Collection<? extends E> c)
		list.addAll(list2); print(13, list);


	}

	public static void print(int n, List<String> list) {
		System.out.println(n+" : " + list);
	}
}

package com.ruby.java.ch10;


import java.util.HashMap;

public class Test07 {
	public static void main(String[] args) {
		
		HashMap<String, String> dic= new HashMap<String, String>();
		
		dic.put("고진감래","a");
		dic.put("분골","b");
		dic.put("고진","c");
		dic.put("감래","d");
		dic.put(null, null);
		
		for(String key : dic.keySet()){
			System.out.println(String.format("%s : %S", key, dic.get(key)));
		}
	}
}

package com.ruby.java.ch10;

import java.util.HashMap;

public class Test06 {
	public static void main(String[] args) {
		
		String word[] = {"BumbleBee", "Heaven", "Although", "Wonder"};
		String meaning[] = {"꿀벌과에 속하는 호박벌", "천국", "그럼에도 불구하고", "호기심이 들다"};
		
		HashMap<String, String> dic = new HashMap<String, String>();
		for (int i = 0; i < word.length; i++) {
			dic.put(word[i], meaning[i]);
		}
		
		System.out.println(dic);
		System.out.println(dic.size());//4
		
		System.out.println(dic.keySet());
		System.out.println(dic.values());

		System.out.println("Heaven : "+ dic.get("Heaven"));
		dic.replace("Heaven", "dkwn godqhrgks rkawjd");
		System.out.println("Heaven : "+ dic.get("Heaven"));
		dic.put("Heaven","이상적인 세상");
		System.out.println("Heaven : "+ dic.get("Heaven"));

		System.out.println(dic.containsKey("BumbleBee"));
		System.out.println(dic.containsValue("자장가"));

		dic.remove("Heaven");
		System.out.println(dic.containsKey("Heaven"));
		
		dic.clear();
		System.out.println(dic.isEmpty());
		System.out.println(dic.size());
		
	}

}

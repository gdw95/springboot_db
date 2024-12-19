package com.ruby.java.ch12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test01_1 {

	public static void main(String[] args) {
		
//		File file = new File("b.txt");
//		if (file.exists()) {
//			Scanner sc = new Scanner(System.in);
//			while(true) {
//				System.out.print("이미 존재하는 파일입니다.");
//				System.out.println("덮어쓰시겠습니까?[Y/N]");
//				String ans = sc.next();
//				if(ans.equalsIgnoreCase("Y"))
//					break;
//				else if (ans.equalsIgnoreCase("N"))
//					return;
//			}
//		}//file 클래스 예시
		
		if(args.length !=2) {
			System.out.println("useage : java ArgsTest srcName targetName");
			return;
		}
		System.out.println(args[0]+" "+args[1]);
		
		
		long start = System.currentTimeMillis();
		copyFile(args[0], args[1]);
		System.out.println("copyFile :"+(System.currentTimeMillis()-start));
		
		start = System.currentTimeMillis();
		copyFile1(args[0], args[1]);
		System.out.println("copyFile :"+(System.currentTimeMillis()-start));

	}

	private static void copyFile1(String string, String string2) {
		try(BufferedInputStream fi = new BufferedInputStream(new FileInputStream(string));
				BufferedOutputStream fo = new BufferedOutputStream(new FileOutputStream(string2));){
			int c = 0;
			while((c = fi.read())!=-1) {
				fo.write(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void copyFile(String string, String string2) {
		try(FileInputStream fi = new FileInputStream(string);
				FileOutputStream fo = new FileOutputStream(string2);){
			int c = 0;
			while((c = fi.read())!=-1) {
				fo.write(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


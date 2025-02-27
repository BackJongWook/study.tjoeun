package com.the.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInput {
	private static Scanner sc=new Scanner(System.in);
	public static int inputInt(String st) {
	    System.out.print(st + " 정수>");
	    try {
	        return Integer.parseInt(sc.nextLine());
	    } catch (NumberFormatException e) {
	        System.out.println("올바른 정수를 입력하세요.");
	        return inputInt(st); // 재귀 호출로 재입력 받기
	    }
	}
	public static double inputDouble(String st) {
	    System.out.print(st + " 실수>");
	    try {
	        return Double.parseDouble(sc.nextLine());
	    } catch (NumberFormatException e) {
	        System.out.println("올바른 실수를 입력하세요.");
	        return inputDouble(st); // 재입력 받기
	    }
	}
	public static String inputString(String st) {
	    System.out.print(st + " 문자>");
	    return sc.nextLine();
	}
	public static LocalDateTime inputLocalDateTime(String str) {
	    System.out.print(str + " 시간입력(yyyy-MM-dd HH:mm:ss)>");        
	    try {
	        return LocalDateTime.parse(sc.nextLine(),
	                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	    } catch (Exception e) {
	        System.out.println("올바른 날짜/시간 형식을 입력하세요.");
	        return inputLocalDateTime(str); // 재입력
	    }
	}
}

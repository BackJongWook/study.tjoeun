package com.the.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
	private static Scanner sc=new Scanner(System.in);
	public static Long inputLong(String st) {
		System.out.print(st+" Long정수입력>>");
		return Long.parseLong(sc.nextLine());		
	}
	public static int inputInt(String st) {
		System.out.print(st+" 정수입력>>");
		return Integer.parseInt(sc.nextLine());		
	}
	public static double inputDouble(String st) {
		System.out.print(st+" 실수입력>>");
		return Double.parseDouble(sc.nextLine());		
	}
	public static String inputString(String st) {
		System.out.print(st+" 문자입력>>");
		return sc.nextLine();		
	}
	public static LocalDateTime inputLocalDateTime(String str) {
		System.out.print(str+" 시간입력(yyyy-MM-dd HH:mm:ss)>>");
		String input=sc.nextLine();
		if(input.equals("")) {
			return LocalDateTime.now();
		}else {					
			return LocalDateTime.parse(input,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}				
	}
	public static String dateToString(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern(
				"yyyy-MM-dd HH:mm:ss"));		
	}
}
package com.the.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
	private static Scanner sc=new Scanner(System.in);
	public static int inputInt(String st) {
		System.out.println(st+" �����Է�>>");
		return Integer.parseInt(sc.nextLine());		
	}
	public static double inputDouble(String st) {
		System.out.println(st+" �Ǽ��Է�>>");
		return Double.parseDouble(sc.nextLine());		
	}
	public static String inputString(String st) {
		System.out.println(st+" �����Է�>>");
		return sc.nextLine();		
	}
	public static Date inputDate(String st) {
		Date rValue=null;//���ڿ��� Date��ü�� ����� ���ؼ��� Ŭ����
		SimpleDateFormat transFormat
		=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(st+"��¥�Է�(yyyy/MM/dd HH:mm:ss)>>");
		try {
			rValue =transFormat.parse(sc.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return rValue;		
	}
	public static String dateToString(Date date) {
		SimpleDateFormat transFormat
		=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return transFormat.format(date);		
	}
}

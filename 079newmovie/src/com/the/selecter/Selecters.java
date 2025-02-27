package com.the.selecter;

import java.util.Scanner;

public class Selecters {
	 String[] selecters = {
			 "예매하기","예매 조회","예매 취소", "종료"
	 };
	 
	 public int input() {
			Scanner sc = new Scanner(System.in);
			int input = 0;
			System.out.println("----------------원하는 업무를 선택해주세요.");
			for(int i=1; i < (selecters.length)+1; i++) {
				System.out.println(i+" : "+selecters[i-1]);
			}
			while(true) {
				while(!sc.hasNextInt()) {
					System.out.println("숫자만 입력해주세요.");
					sc.next();
				}
				input = sc.nextInt()-1;
				if(input >= selecters.length) {
					System.out.println("유효한숫자만 입력해주세요.");
					continue;
				}
				System.out.println("----"+selecters[input]+" 업무를 선택하셨습니다.----");
				return input;
			}
	 }

}

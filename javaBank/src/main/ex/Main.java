package main.ex;

import main.bank.Bank;
import main.bank.ex.*;
import main.selecter.Selecter;

public class Main {
	public static void main(String[] args) {
		Selecter selecter = new Selecter();
		Bank bank = null;
		while(true) {
			switch(selecter.input()) {
				case 0:{ bank = new Creation(); } break; // 생성
				case 1:{ bank = new Reference();  } break; // 조회
				case 2:{ bank = new Deposit(); } break; // 입금 
				case 3:{ bank = new Withdraw(); } break; // 출금
				case 4:{ bank = new Exchange(); } break; // 송금
				case 5: default:{
					System.out.println("업무를 종료합니다.");
					selecter = null;
				} return;
			}
			bank.update();
		}
	}
}

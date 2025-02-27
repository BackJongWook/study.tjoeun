package main;
import main.selecter.*;
import main.works.*;

/*
 * Java 연습용 은행 예제.
 *  
 */

public class Main {
	public static void main(String[] args) {
		Works work = new Works();		
		while(work != null) {
			Selecter selecter = new Selecter(); // 선택기
			switch(selecter.input()) { // 선택 
				case 0:{ work = new Creation(); } break; // 생성
				case 1:{ work = new Inquiry(); } break; // 조회
				case 2:{ work = new Deposit(); } break; // 입금
				case 3:{ work = new Withdraw(); } break; // 출금
				case 4:{ work = new Remit(); } break; // 송금
				case 5: default:{
					System.out.println("업무를 종료합니다.");
					work = null;
					return;
				}
			}
			work.update();
		}
	}
}

package main.bank.ex;

import java.util.Scanner;

import main.bank.Bank;
import main.bank.account.Account;

public class Withdraw extends Bank{
	static { name = "출금"; }
	
	@Override
	protected boolean progress() {
		Scanner scanner = new Scanner(System.in);
		long input = 0;
		
		Account account = getAccount();
		System.out.println("------------------------");
		System.out.println(account);
		System.out.println("------------------------");
		while(true) {
			System.out.println("출금할 금액을 입력해주세요. 종료를 원하시면 0을 입력해주세요.");
			while (!scanner.hasNextLong()) {
				System.out.println("유효하지 않은 입력입니다. 숫자만 입력해 주세요.");
				scanner.next();
			}
			input = scanner.nextLong();
			if(input == 0) { return super.progress(); }
			if(!account.hasWithdraw(input)) {
				System.out.print("출금할 수 없습니다. 다시 ");
				continue;
			}
			account.setBalance(input);
			if(manager().setBalance(account)) {
				System.out.println(account.getName()+"의 계좌에 "+input+" 가 출금 되었습니다.");
				System.out.println(account);
			}
			else { System.out.println("오류로 인해, 출금이 실패하였습니다."); }
			return super.progress(); 
		}
	}
}

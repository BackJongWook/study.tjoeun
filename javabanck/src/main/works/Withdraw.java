package main.works;
import java.util.Random;
import java.util.Scanner;

import main.account.*;
import main.selecter.*;

public class Withdraw extends Works {

    public Withdraw(){
    	super();
    	name = SelecterEnum.출금.toString();
    }
    
    Account withdrawAmount(Account acc) {
		Scanner scanner = new Scanner(System.in);
		long input = 0;
		
		System.out.println("------------------------");
		while(true) {
			System.out.println("출금할 금액을 입력해주세요. 종료를 원하시면 0을 입력해주세요.");
			while (!scanner.hasNextLong()) {
				System.out.println("유효하지 않은 입력입니다. 숫자만 입력해 주세요.");
				scanner.next();
			}
			input = scanner.nextLong();
			if(input == 0) { return null; }
			if(!acc.withdrawAmount(input)){
				System.out.print("출금할 수 없습니다. 다시 ");
			}
			else { return acc; }
		}		
    }
    
	@Override
	public void progress() { 
	    super.progress();
		long acc = accountInput(); // 함수를 통해 계좌 여부를 가져온다.
		if(acc == 0) { setResult(); }
		Account guest = passward(acc); // 함수를 통해 계좌와 비밀번호가 일치하는지 보여준다.
		if(guest == null) { setResult(); }
		guest = withdrawAmount(guest); // 함수를 통해 계산이 가능한지 보내준다.
		if(guest == null) { setResult(); }
		else {
			manager.prtAccount(acc);
			setResult();
		}
	}
}


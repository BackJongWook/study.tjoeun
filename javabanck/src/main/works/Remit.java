package main.works;
import java.util.*;

import main.account.*;
import main.selecter.*;

public class Remit extends Works {
	
    public Remit(){
    	super();
    	name = SelecterEnum.송금.toString();
    }
    
    Account remit(long post,long set) {
		Scanner scanner = new Scanner(System.in);
		Map<String,Account> get = new HashMap<>();
		long input = 0;
		while(true) {
			System.out.println("송금할 금액을 입력해주세요. 종료를 원하시면 0을 입력해주세요.");
			while (!scanner.hasNextLong()) {
				System.out.println("유효하지 않은 입력입니다. 숫자만 입력해 주세요.");
				scanner.next();
			}
			input = scanner.nextLong();
			if(input == 0) { return null; }
			get = manager.postAccounts(post, set, input);
			for(String key: get.keySet()) {
				switch(key) {
					case "clear":{
						for(Account acc : get.values()) {
							return acc; 
						}
					}break;
					case "post":{
						System.out.print("보낼 계좌문제 다시 ");
					}break;
					case "set":{
						System.out.print("받을 계좌문제 다시 ");
					}break;
				}
			}
			
		}
    }
	
	@Override
	public void progress() { 
	    super.progress();
		long setAcc = accountInput(); // 보낼 계좌 여부를 가져온다.
		if(setAcc == 0) { setResult(); }
		Account setGuest = passward(setAcc); // 함수를 통해 계좌와 비밀번호가 일치하는지 보여준다.
		if(setGuest == null) { setResult(); }
		long getAcc = accountInput(); // 받을 계좌 여부를 가져온다.
		if(getAcc == 0) { setResult(); }
		setGuest = remit(setAcc,getAcc); // 송금을 진행한다.
		if(setGuest == null) { setResult(); }
		else {
			manager.prtAccount(setAcc);
			setResult();
		}
	}
    
    
}

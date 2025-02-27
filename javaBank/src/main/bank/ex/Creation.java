package main.bank.ex;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import main.bank.account.Account;
import main.bank.Bank;

public class Creation extends Bank {
	Random random;
	static { name = "계좌 생성"; }
	public Creation() { random = new Random(); }
	
	@Override
	protected boolean progress() {
		Account guest = new Account();
		Scanner scanner = new Scanner(System.in);
		String input = "";
		System.out.println("------------------------");
		while(true) {
			System.out.println("이름을 공백없이 입력해주세요. \n 종료를 원하시면 0을 입력해주세요.");
			input = scanner.nextLine();
			if("0".equals(input)) { return super.progress(); }
			if(!guest.hasName(input,true)) { 
				System.out.printf("형식에 맞지 않습니다. 다시");
				continue;
			}
			break;
		}
		System.out.println("------------------------");
		while(true) {
			System.out.println("비밀번호 4자리를 공백없이 입력해주세요. \n 종료를 원하시면 0을 입력해주세요.");
			input = scanner.nextLine();
			if("0".equals(input)) { return super.progress(); }
			if(!guest.hasPassword(input,true)) { 
				System.out.printf("형식에 맞지 않습니다. 다시");
				continue;
			}
			break;
		}
		System.out.println("------------------------");
		input = bankSelect();
		System.out.println("------------------------");
		String duplicated = "";
		do {
			duplicated = String.valueOf(1000000000L + random.nextLong(9000000000L));
		}while(manager().isDuplicatedAccountId(input,String.valueOf(duplicated)));
		guest.setAccount(input, duplicated);
		if(manager().newAccountId(guest)) {
			System.out.println(guest.getName()+"님의 계좌번호: "+input+" : "+duplicated+ "으로 생성되셧습니다.");
			System.out.println(guest);
		}
		else { System.out.println("오류로 인해, 생성이 실패하였습니다."); }
		System.out.println("------------------------");
		return super.progress();
	}
}

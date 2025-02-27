package main.bank;
import java.util.List;
import java.util.Scanner;
import main.bank.account.*;
import main.selecter.SelecterEnum;

// 계좌를 정리해준다.
public class Bank extends BankAbstract {
		
	public String bankSelect() { return bankSelect(""); }
	public String bankSelect(String post) {
		String bank = "";
		List<String> banks = manager().getBankName();
		Scanner scanner = new Scanner(System.in);
		while (true) { 
			System.out.printf(post+"은행을 입력해주세요. 종료를 원하시면 0를 입력해주세요.");
			System.out.printf(" 지원 은행( ");
			for (String i : banks) {
				System.out.printf(i + ", ");
			}
			System.out.println(")");
			bank = scanner.nextLine().toUpperCase();
			if("0".equals(scanner)) { return "0"; }
			for (String i : banks) {
				if(bank.equals(i)) { return bank; }
			}
			System.out.println("은행명을 정확히 입력해주세요.");
		}
	}
	
	// null 일 경우 없는것
	public Account getAccount() { return getAccount(""); }
	public Account getAccount(String post) {
		Scanner scanner = new Scanner(System.in);
		String account= "";
		String bank = "";
		while (true) {
			bank = bankSelect(post);
			while(true) {
				System.out.printf(post+bank+"은행 계좌를 입력해주세요. 종료를 원하시면 0를 입력해주세요.");
				account = scanner.nextLine();
				if("0".equals(account)) { return null; }
				return manager().getAccount(bank,account);	
			}
		}
	}
	
	public Account passward(long acc) {
		Scanner scanner = new Scanner(System.in);
		Account result = null;
		String input = "";
		while(true) {
			System.out.println("비밀번호를 공백없이 4자리를 입력해주세요. 종료를 원하시면 0을 입력해주세요.");
			input = scanner.next();
			if("0".equals(input)) {
			    System.out.print(name+" 업무를 취소합니다. ");
				return null; 
			}
//			result = manager().isAccountPassword(acc,input);
			if(result != null) { return result; }
			else {
				System.out.print("비밀번호가 다릅니다.");
			}
		}
	}


	protected boolean progress() { return false; }
}

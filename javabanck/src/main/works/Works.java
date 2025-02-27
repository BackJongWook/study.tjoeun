package main.works;

import java.util.Scanner;

import main.account.*;

public class Works implements WorkInterface {
	protected AccountManager manager;
	protected String name = "";
	protected boolean progress = true;
	public boolean exit = false;
	
	public Works() {
		manager = AccountManager.get();
	}
	
	public String getName() { return name; }
	
	@Override
	public boolean isProgress() { return progress; }
	
	public void setResult() {
		progress = false;
		System.out.println("초기 화면으로 넘어갑니다.");
	}
	
	public long accountInput() { return accountInput(""); }
	
	public long accountInput(String post) {
		Scanner scanner = new Scanner(System.in);
		long input = 0;
		while(true) {
			System.out.println(post+"계좌를 입력해주세요. 종료를 원하시면 0를 입력해주세요");
			input = scanner.nextLong();
			if(input == 0) {
			    System.out.print(name+" 업무를 취소합니다. ");
			    return 0;
			}
			System.out.println(input);
			if(manager.prtAccount(input)) {
				return input; 
				}
			else {
				System.out.print("해당 계좌가 없습니다. 다시"); 
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
			result = manager.isAccountPassword(acc,input);
			if(result != null) { return result; }
			else {
				System.out.print("비밀번호가 다릅니다.");
			}
		}
	}
}

package main.bank;
import main.bank.account.AccountManager;

public abstract class BankAbstract {
	protected static String name;
	public AccountManager manager() { return AccountManager.get(); }
	protected boolean progress() { 
		System.out.println(name+" 업무를 종료합니다.\n초기 화면으로 넘어갑니다.");
		return false; 
	}
	public void update() { while(progress()); }
}
package main.bank.ex;
import main.bank.Bank;
import main.bank.account.Account;

public class Reference extends Bank{
	static { name = "계좌 조회"; }

	@Override
	protected boolean progress() {
		Account account = getAccount();
		System.out.println("------------------------");
		System.out.println(account);
		return super.progress();
	}
}

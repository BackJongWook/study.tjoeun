package main.bank.account;

public class Account {
	String bank;
	String name;
	String id;
	String password;
	long balance;
	
	public Account() { }
	public Account(String bank, String name, String id, String password, long balance){
		this.bank = bank;
		this.name = name;
		this.password = password;
		this.balance = balance;
		this.id = id;
	}
	
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public boolean hasName(String name) { return hasName(name,false); }
	public boolean hasName(String name, boolean change) {
		if(name.contains(" ") || "".equals(name) || name.matches(".*\\d.*")){ return false; }
		if(change) { this.name = name; }
		return true;
	}
	
	public void setPassword(String pw) { this.password = pw; }
	public boolean hasPassword(String pas) { return hasPassword(pas,false); }
	public boolean hasPassword(String pas, boolean change) {
		if (pas == null || pas.contains(" ") || pas.isEmpty() || !pas.matches(".*\\d.*") || pas.length() != 4) { return false; }
		if(change) { this.password = pas; }
		return true;
	}
	
	public void setBalance(long balance) { this.balance = balance; } 
	
	public boolean hasDepositAmount(long balance) {
		if(balance <= 0) { return false; }
		long copy = this.balance + balance;
		if(copy < 0) { return false; }	
		return true;
	}
	public boolean hasWithdraw(long balance) {
		if(balance <= 0) { return false; }
		long copy = this.balance + (-1*(balance));
		if(copy < 0) { return false; }	
		return true;
	}
	
	// 크로스체크..?
	public boolean hasExchange(Account acc, long balance) {
		// 1. 내 계좌에서 출금이 되는가.
		// 2. 상대방 계좌에서 입금이 되는가.
		// 3. 확인해서 둘다 되면 true, 안되면 false
		if(hasWithdraw(balance) && acc.hasDepositAmount(balance)) {
			return true;
		}
		return false;
	}
	
	public void setAccount(String bank, String id) {
		this.bank = bank;  	
		this.id = id;
	}
	
	@Override
	public String toString(){
		return ""
			+"이름 : "+this.name+",\n"
			+"계좌 : ( "+this.bank+" ) "+this.id+",\n"
			+"잔액 : " +this.balance + "(원)"
			;
	}

}

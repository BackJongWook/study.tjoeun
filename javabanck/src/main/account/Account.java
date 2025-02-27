package main.account;

public class Account {
	private long amount;
	private String holder;
	private String password;
	
	public Account(){
		amount = 0;
		holder = "";
		password = "";
	}
	
	//글자인지 확인 추가 
	public boolean hasName(String name) {
		if(name.contains(" ") || "".equals(name)){ return false; }
		else {
			holder = name; 
			return true; 
		}
	}
	
	public boolean hasPassword(String pas) {
		if(pas.contains(" ") && pas != ""  && pas .length() != 4){ return false; }
		else { 
			password = pas;
			return true; 
		}
	}
	
	public boolean isPassword(String pas) {
		return password.equals(pas);
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean depositAmount(long mAmount) {
		return depositAmount(mAmount,false);
	}
	
	public boolean depositAmount(long mAmount,boolean modify) {
		long copy = (amount + mAmount) < 0 ?-1 :amount + mAmount;
		if(copy >= 0) { 
			if(modify) { amount = copy; } 
			return true; 
		} 
		else { return false; }
	}
	
	public boolean withdrawAmount(long mAmount) {
		return withdrawAmount(mAmount,false);
	}
	
	public boolean withdrawAmount(long mAmount,boolean modify) {
		long copy = (amount - mAmount) < 0 ?-1 :amount + mAmount;
		if(copy >= 0) { 
			if(modify) { amount = copy; } 
			return true; 
		} 
		else { return false; }
	}	
	
	public String getHolder() {
		return holder;
	}
	
	public long getAmount() {
		return amount;
	}
}
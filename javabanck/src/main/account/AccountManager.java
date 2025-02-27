package main.account;
import java.util.*;

public class AccountManager {
	static AccountManager mManager;
	Map<Long,Account> accounts = new HashMap<>();
	
	static { get(); }
	
	public static AccountManager get() {
		if(mManager == null) {
			mManager = new AccountManager();
		}
		return mManager;
	}
	
	public boolean prtAccount(long num) {
		return prtAccount(num,false);
	}
	
	public boolean prtAccount(long num,boolean isPassward) {
		Account i = accounts.get(num);
		if(i != null) {
		    System.out.println("------------------------\n");
		    System.out.println("\t계좌정보");
		    System.out.println("\t예금주 :"+i.getHolder());
		    System.out.println("\t계좌번호 :"+num);
		    System.out.println("\t유치 금액:"+i.getAmount()+"원");
		    if(isPassward) { System.out.println("\t비밀번호 :"+i.getPassword()); }
		    System.out.println("\n------------------------");
			return true;
		}
		 return false;
	}
	
	public long notDuplicatedNumber() {
	    Random rand = new Random();
		long result = 1000000000L + rand.nextLong(9000000000L);
		while(true) {
			result =  1000000000L + rand.nextLong(9000000000L);
			if(accounts.get(result) == null) { return result; }
		}
	}
	
	public void add(long num, Account acc) {
		if(accounts.get(num) == null) {
			accounts.put(num, acc);
		}
	}
	
	public Account isAccountPassword(long acc, String pas) {
		if(accounts.get(acc) == null) { return null; }
		else {
			if(accounts.get(acc).isPassword(pas)) { return accounts.get(acc); }
			else { return null; }
		}
	}
	
	public Map<String,Account> postAccounts(long post,long set,long amount) {
		Map<String,Account> result =  new HashMap<>();
		Account postAcc = accounts.get(post);
		Account setAcc = accounts.get(set);
		if(!postAcc.withdrawAmount(amount,false)) {
			//보낼수가 없음
			result.put("post",null);
		}
		else if(!setAcc.depositAmount(amount,false)) {
			//받을수가 없음 
			result.put("set",null);
		}
		else {
			// 완벽하니 보내주어야함 
			postAcc.withdrawAmount(amount);
			setAcc.depositAmount(amount);
			result.put("clear", postAcc);
		}
		return result;
	}

}

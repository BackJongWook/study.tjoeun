package main.bank.account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class AccountManager extends AccountSql {
	static AccountManager mManager;
	static { get(); }	
	public static AccountManager get() {
		if(mManager == null) {
			mManager = new AccountManager();
		}
		return mManager;
	}
	
	public Account getAccount(String bank, String id) {
		Account result = null;
		ResultSet read = read("select bank, account_id, balance, user_name from account where"
				+" bank='"+bank+"' or"
				+" account_id="+id);		
		try {
			if(read == null) { return result; }
			result = new Account();
			while (read.next()) {
				result.name = read.getString("USER_NAME");
				result.bank = read.getString("BANK");
				result.id = read.getString("ACCOUNT_ID");
				result.balance = read.getLong("BALANCE");
	        }
		}catch (SQLException e) {
			
		}
		finally { close(); }
		return result;
	}
	
	public List<String> getBankName() {
		List<String> result = new ArrayList<String>();
		ResultSet read = read("select * from bank");
		try {
			while (read.next()) {
	            result.add(read.getString("name"));
	        }	
		}catch (SQLException e) { }
		finally { close(); }
		return result;
	}
	
	public boolean isDuplicatedAccountId(String bank,String id) {
		int result = 0;
		ResultSet read = read("select count(*) as count from account where"
				+" bank = '"+bank+"' and"
				+" account_id = "+id);
		try {
			while (read.next()) {
				result = read.getInt("count");
			}
		}catch (SQLException e) { }
		finally { close(); }
		// 1
		return result < 1 ?false :true;
	}
	
	public boolean newAccountId(Account account) {
		int result = 0;	
		try {
			result = update("INSERT INTO account (account_id, bank, password, balance, user_name) VALUES ("
		            + account.id + ", "
		            + "'" + account.bank + "', "
		            + "'" + account.password + "', "
		            + account.balance + ", "
		            + "'" + account.name + "')");
			System.out.println(result);
		}
		finally { close(); }
		return result != 0 ?true :false;
	}
	
	public boolean setBalance(Account acc) {
		int result = 0;	
		try {
			result = update("update account set"
				+" balance = "+ acc.balance
				+" where account_id = '" + acc.id+"'"
			);
			System.out.println(result);
		}
		finally { close(); }
		return result != 0 ?true :false;	
	}
	
	public boolean setBalance(Account first, Account second) {
		int result = 0;	
		try {
			result = update("update account set balance = case account_id"
					+ " when '"+first.id+"' then "+0
					+ " when '"+second.id+"' then "+0
					+ "end where"
					+ "(account_id = '"+first.id+"' and bank = '"+first.bank+"') or"
					+ "(account_id = '"+second.id+"' and bank = '"+second.bank+"')"
				);
		
		System.out.println(result);			
		}
		finally { close(); }
		return result != 0 ?true :false;	
	}
}

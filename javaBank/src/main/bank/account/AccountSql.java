package main.bank.account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AccountSql {
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static String user = "c##javaBank";
	static String pw = "javaBank";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
 
	void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,pw);
			st=con.createStatement();
		} 
		catch(SQLException e) { e.printStackTrace(); } 
		catch(ClassNotFoundException e) { e.printStackTrace(); }
	}
	
	public ResultSet read(String sql) {
	    connect();
	    try { rs = st.executeQuery(sql); } 
	    catch (SQLException e) { e.printStackTrace(); }
	    return rs;
	}
	
	public int update(String sql)
	{
		int result = 0;
		connect();
		try {
			result = st.executeUpdate(sql);
		} catch (SQLException e) { e.printStackTrace(); }
		return result;
	}
	
	public static void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rs = null;
			st = null;
			con = null;
		}
	}
}

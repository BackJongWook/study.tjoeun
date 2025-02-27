package com.the.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Sql {
	public String url = "jdbc:oracle:thin:@localhost:1521:xe";
	public String user = "c##human";
	public String password = "human";
}

// 테이블 3개이하, 수강신청, ppt,  

public class SqlConnector {
	private static Sql sql = new Sql();
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	
	public static void connect() { connect(sql); }
	public static void connect(Sql sql)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(sql.url,sql.user,sql.password);
			st=con.createStatement();
		} 
		catch (SQLException e) { e.printStackTrace(); } 
		catch (ClassNotFoundException e) { e.printStackTrace(); }
	}
	
	public static void close() {
		try {
			if (rs != null) { rs.close(); }
			if (st != null) { st.close(); }
			if (con != null){ con.close(); }
		} 
		catch (Exception e) { e.printStackTrace(); } 
		finally {
			rs = null;
			st = null;
			con = null;
		}
	}
}

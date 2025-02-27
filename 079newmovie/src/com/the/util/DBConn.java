package com.the.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//DBConn 쉽게 데이터베이스를 사용할 수 있는 클래스
//DBConn.statementQuery(String sql)		select		esultSet
//DBConn.statementUpdate(String sql)	insert,update,delete	변경된 개수

public class DBConn {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static String user = "c##projectmovie";
	private static String pw = "movie";
	private static String url = "jdbc:oracle:thin:@localhost:1522:xe";
	public static void connect()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("연결");
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("접속 성공");
			st=con.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void connect(String user, String pw)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("연결");
			
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("접속 성공");
			st=con.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static ResultSet statementQuery(String sql)
	{
		connect();
		try {
			rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return rs;
    }
	
	public static void statementUpdate(String sql)
	{
		connect();
		if(con == null)
		{
			System.out.println("fail");
		}else
		{
			try {
				int n = st.executeUpdate(sql);
				if(n != 0)
					System.out.println(n + "개의 작업을 성공적으로 수행했습니다");
				else
					System.out.println("작업된 내용이 없습니다");
			}catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
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

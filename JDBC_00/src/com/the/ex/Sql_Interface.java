package com.the.ex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.sql.Types;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public interface Sql_Interface {
	// 데이터의 형태를 알려준다.
	Object getSql(ResultSet rs);
	default String url() {
		return "jdbc:oracle:thin:@localhost:1521:xe";
	}
	default String[] login() {
		return new String[] { "c##tiger", "tiger" };
	}
	
	default List<Object> get(String path) {
	    List<Object> result = new ArrayList<>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = url();
			conn = DriverManager.getConnection(url, login()[0], login()[1]);
			st = conn.createStatement();
			rs = st.executeQuery(path);
			while (rs.next()) { result.add(result); }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

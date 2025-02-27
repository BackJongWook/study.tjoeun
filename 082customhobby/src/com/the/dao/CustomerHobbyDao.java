package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.the.util.DBConn;

public class CustomerHobbyDao {
	//가장 최근에 입력한 고객ID
	public Long getCustomerMaxId() {
		Long returnValue=0L;
		String sql ="select max(id) as max_id from customer";
		ResultSet rs=DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				returnValue=rs.getLong("max_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}
}



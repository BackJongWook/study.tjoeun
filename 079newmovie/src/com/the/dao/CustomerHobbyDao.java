package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.the.dto.CustomerHobbyDto;

import com.the.util.DBConn;

public class CustomerHobbyDao {
	// 가장 최근에 입력한 고객ID
	public Long getCustomerMaxId() {
		Long returnValue = 0L;
		String sql = "select max(id) as max_id from customer";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				returnValue = rs.getLong("max_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	public ArrayList<CustomerHobbyDto> selectCustomerHobbys(){

		ArrayList<CustomerHobbyDto> dtos = new ArrayList<CustomerHobbyDto>();
		String sql =
				"select customer.*,id as hobby_id,hobby.hobby from customer,hobby "
				+ "where customer.id=hobby.custom_id(+)";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				dtos.add(new CustomerHobbyDto(
						rs.getLong("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime(),
						rs.getLong("hobby_id"),
						rs.getString("hobby")));
				
//				private Long id;
//				private String name;
//				private Integer age;
//				private Double height;
//				private LocalDateTime birthday;
//				
//				private Long hobby_id;
//				private String hobby;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;
	}

	public void deleteCustomerHobbys(Long customId) {
		DBConn.statementUpdate("delete from hobby where custom_id="+customId);
		DBConn.statementUpdate("delete from customer where id="+customId);
		
	}
}

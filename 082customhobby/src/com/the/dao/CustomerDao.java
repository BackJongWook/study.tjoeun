package com.the.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.the.dto.CustomerDto;
import com.the.util.DBConn;
import com.the.util.UserInput;

// CUSTOMER 테이블 CRUD 작업을 수행하는 클래스
public class CustomerDao {
//	TO_DATE('2025-02-21 16:15:13.730619500', 'YYYY-MM-DD HH24:MI:SS')
	public void insert(CustomerDto dto) {
		String sql = String.format(
				"INSERT INTO CUSTOMER (name, age, height, birthday)"
				+ " VALUES ('%s', %d, %.2f, TO_DATE('%s', 'YYYY-MM-DD HH24:MI:SS'))",
				dto.getName(), dto.getAge(), dto.getHeight(),
				UserInput.dateToString(dto.getBirthday()));
		DBConn.statementUpdate(sql);
	}

	public ArrayList<CustomerDto> selectAll() {
		ArrayList<CustomerDto> dtos = new ArrayList<>();
		String sql = "SELECT * FROM CUSTOMER ORDER BY id";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				dtos.add(new CustomerDto(rs.getLong("id"), rs.getString("name"), rs.getInt("age"),
						rs.getDouble("height"), rs.getTimestamp("birthday").toLocalDateTime()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public void delete(Long id) {
		String sql = String.format("DELETE FROM CUSTOMER WHERE id = %d", id);
		DBConn.statementUpdate(sql);
	}

	public void update(Long id, String name, Integer age, Double height, String birthday) {
		String sql = String.format(
				"UPDATE CUSTOMER SET name = '%s', age = %d, height = %.2f, birthday = TO_DATE('%s', 'YYYY-MM-DD HH24:MI:SS') WHERE id = %d",
				name, age, height, birthday, id);
		DBConn.statementUpdate(sql);
	}
}
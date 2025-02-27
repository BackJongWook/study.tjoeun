package com.the.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.the.dto.HobbyDto;
import com.the.util.DBConn;

//Hobby 테이블 CRUD 작업하는 클래스
public class HobbyDao {

	public void insert(HobbyDto dto) {
		String sql = String.format("insert into hobby (custom_id, hobby) values(%d,'%s')", dto.getCustomerId(),
				dto.getHobby());
		DBConn.statementUpdate(sql);

	}

	public ArrayList<HobbyDto> selectAll() {
		ArrayList<HobbyDto> dtos = new ArrayList<HobbyDto>();
		String sql = "select * from hobby order by id";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while (rs.next()) {
				dtos.add(new HobbyDto(rs.getLong("id"), rs.getLong("custom_id"), rs.getString("hobby")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	public void delete(Long id) {
		String sql = String.format("delete from hobby where custom_id = %d", id);
		DBConn.statementUpdate(sql);
	}

	public void update(Long id, String hobby) {
		String sql = String.format("update hobby set hobby = '%s' where custom_id = %d", hobby, id);
	}
}

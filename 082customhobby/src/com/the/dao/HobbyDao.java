package com.the.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.the.dto.HobbyDto;
import com.the.util.DBConn;

//Hobby테이블 CRUD작업하는 클래스
public class HobbyDao {
	
	public void insert(HobbyDto dto) {
		String sql = String.format("INSERT INTO HOBBY (custom_id, hobby) VALUES (%d, '%s')"
				, dto.getCustomerId(),dto.getHobby());
		DBConn.statementUpdate(sql);
	}
	
	public ArrayList<HobbyDto> selectAll(){
		ArrayList<HobbyDto> dtos=new ArrayList<HobbyDto>();
		String sql ="select * from hobby order by id";
		ResultSet rs=DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				dtos.add(new HobbyDto(
						rs.getLong("id"),
						rs.getLong("custom_id"),
						rs.getString("hobby")
						));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	
	public void delete(Long id) {
		String sql = String.format("DELETE FROM HOBBY WHERE id = %d", id);
		DBConn.statementUpdate(sql);
	}
	
	public void update(Long id, String hobby) {
		String sql = String.format("UPDATE HOBBY SET hobby = '%s' WHERE id = %d", hobby, id);
		DBConn.statementUpdate(sql);
	}
	

}





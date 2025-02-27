package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.the.dto.ScreeningDto;
import com.the.util.DBConn;

public class ScreeningDao {

    // 모든 상영 정보 조회
    public ArrayList<ScreeningDto> selectAllScreening() {
        ArrayList<ScreeningDto> screening = new ArrayList<>();
        ResultSet rs = DBConn.statementQuery("SELECT * FROM Screening");

        try {
            while (rs.next()) {
                screening.add(new ScreeningDto(
                    rs.getInt("screening_id"),
                    rs.getInt("movie_id"),  
                    rs.getTimestamp("screening_time").toLocalDateTime()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return screening;
    }
}

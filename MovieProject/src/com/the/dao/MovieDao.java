package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.the.dto.MovieDto;
import com.the.util.DBConn;

public class MovieDao {

    // 모든 영화 조회
    public ArrayList<MovieDto> selectAllMovies() {
        ArrayList<MovieDto> movies = new ArrayList<>();
        ResultSet rs = DBConn.statementQuery("SELECT * FROM Movie");
        
        try {
            while (rs.next()) {
                movies.add(new MovieDto(
                    rs.getInt("movie_id"),
                    rs.getString("title"),
                    rs.getString("genre")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close(); // 리소스 해제
        }
        return movies;
    }
}
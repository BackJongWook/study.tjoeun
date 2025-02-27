package com.the.selecter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import com.the.util.*;

class ReservationMovieScreen {
	int movie_id;
	String title;

	int screening_id;
	Timestamp screening_time;

	int reservation_id;
	int seat_count;
	int password_pw;
}

public class Search extends Program {
	DBConn sql = new DBConn();

	@Override
	boolean progress() {
		
		// MovieList 에서 예매한 정보를 확인하기
		int inputRsvId = UserInput.inputInt("예매 번호를 입력하세요.");
		List<ReservationMovieScreen> srch = selectAll(inputRsvId);
		if (srch == null || srch.isEmpty()) {
            System.out.println("해당 예매 정보가 없습니다.");
            return false;
        }
		System.out.println("------------");

		boolean pwCorrect = false;
		while (!pwCorrect) {
			int inputPW = UserInput.inputInt("비밀번호를 입력하세요.");
			
			for (ReservationMovieScreen i : srch) {
				if (i.password_pw == inputPW) {
					System.out.println("예매 주문 번호: " + i.reservation_id);
					System.out.println("영화 제목: " + i.title);
					System.out.println("상영 시간: " + i.screening_time);
					pwCorrect = true;
					break;
				}
			}
			if (!pwCorrect) {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}
		
		return super.progress();
	}

	List<ReservationMovieScreen> selectAll(int id) {
		List<ReservationMovieScreen> rsv = new ArrayList<ReservationMovieScreen>();
		ReservationMovieScreen temp = null;

		try {
			ResultSet rsvData = sql.statementQuery(
					String.format("select r.reservation_id,r.screening_id,m.title,s.screening_time,r.password_pw"
							+ " from reservation r join screening s on r.screening_id = s.screening_id"
							+ " join movie m on s.movie_id = m.movie_id" + " where reservation_id='%d'", id));
			while (rsvData.next()) {
				temp = new ReservationMovieScreen();
				temp.reservation_id = rsvData.getInt("reservation_id");
				temp.screening_id = rsvData.getInt("screening_id");
				temp.title = rsvData.getString("title");
				temp.screening_time = rsvData.getTimestamp("screening_time");
				temp.password_pw = rsvData.getInt("password_pw");
				rsv.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return rsv;
	}
}

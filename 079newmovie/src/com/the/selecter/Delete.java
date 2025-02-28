package com.the.selecter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Timestamp;
import com.the.util.*;
import java.sql.Timestamp;

public class Delete extends Program { // 현재 java파일이 delete하는것을 기준으로 작성
	DBConn sql = new DBConn();

	boolean progress() {
		int inputRsvId = UserInput.inputInt("예매 번호를 입력하세요.");
		List<ReservationMovieScreen> srch = selectAll(inputRsvId);
		if (srch == null || srch.isEmpty()) {
            System.out.println("해당 예매 정보가 없습니다.");
            return false;
        }
		System.out.println("------------");

		boolean pwCorrect = false;
		while (!pwCorrect) {
			System.out.println("비밀번호를 입력하세요.(취소시 'cancel'입력)");
			String inputPW = new Scanner(System.in).nextLine();
			
			if("cancel".equalsIgnoreCase(inputPW)) { //입력값이 'cancel'일 시 반복 취소
				System.out.println("입력이 취소됐습니다.");
				return false;
			}
			
			int inputPassword;
			try {
				inputPassword = Integer.valueOf(inputPW); //입력값을 문자로
			} catch(Exception e) {
				System.out.println("올바른 값을 입력하세요.");
				continue; //잘못된 입력값일 경우 다시 입력 받음.
			}
			
			for (ReservationMovieScreen i : srch) {
				if (inputPassword == i.password_pw) {
					System.out.println("예매 주문 번호: " + i.reservation_id);
					System.out.println("예매 영화: " + i.title);
					String inputDelete = UserInput.inputString("삭제하시겠습니까? Y/N");
					if (inputDelete.equals("y")) {
						String sql = String.format("delete from reservation where reservation_id='%d'", inputRsvId);
						DBConn.statementUpdate(sql);
					} else if (inputDelete.equals("n")) {
						System.out.println("취소됐습니다.");
					} else {
						System.out.println("다시 입력해주십시요.");
					}
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
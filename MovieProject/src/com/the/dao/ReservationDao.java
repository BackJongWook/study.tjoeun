package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.the.dto.ReservationDto;
import com.the.util.DBConn;

public class ReservationDao {
    public boolean isValidScreeningId(int screeningId) {
        String sql = "SELECT COUNT(*) FROM Screening WHERE screening_id = " + screeningId;
        ResultSet rs = DBConn.statementQuery(sql);
        try {
            if (rs != null && rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close();
        }
        return false;
    }

    public void insertReservation(ReservationDto reservation) {
        if (!isValidScreeningId(reservation.getScreening_id())) {
            System.out.println("유효하지 않은 상영 ID입니다. 다시 확인해주세요.");
            return;
        }

        String sql = String.format(
        	    "INSERT INTO Reservation (screening_id, seat_count, password_pw) VALUES (%d, %d, '%s')",
        	    reservation.getScreening_id(),
        	    reservation.getSeat_count(),
        	    reservation.getPassword_pw()
        	);
        int result = DBConn.statementUpdate(sql);
        if (result > 0) {
            System.out.println("예매가 성공적으로 추가되었습니다!");
        } else {
            System.out.println("예매 추가에 실패했습니다.");
        }
    }


    public void updateReservation(int reservation_id, int new_seat_count, String password_pw) {
        String checkSql = String.format(
            "SELECT COUNT(*) FROM Reservation WHERE reservation_id = %d AND password_pw = '%s'",
            reservation_id, password_pw
        );

        ResultSet rs = DBConn.statementQuery(checkSql);
        try {
            if (rs != null && rs.next() && rs.getInt(1) > 0) { 
                String updateSql = String.format(
                    "UPDATE Reservation SET seat_count = %d WHERE reservation_id = %d",
                    new_seat_count, reservation_id
                );
                DBConn.statementUpdate(updateSql);
                System.out.println("좌석 수가 성공적으로 수정되었습니다.");
            } else {
                System.out.println("비밀번호가 틀렸습니다. 수정을 취소합니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close();
        }
    }

    public void deleteReservation(int reservationId) {
        String sql = "DELETE FROM Reservation WHERE reservation_id = " + reservationId;
        DBConn.statementUpdate(sql);
        System.out.println("예매 취소 완료!");
    }

    public ArrayList<ReservationDto> selectAllReservations() {
        ArrayList<ReservationDto> reservations = new ArrayList<>();
        ResultSet rs = DBConn.statementQuery("SELECT reservation_id, screening_id, seat_count, password_pw FROM Reservation");
        try {
            while (rs.next()) {
                reservations.add(new ReservationDto(
                    rs.getInt("reservation_id"),
                    rs.getInt("screening_id"),
                    rs.getInt("seat_count"),
                    rs.getString("password_pw")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConn.close();
        }
        return reservations;
    }
}

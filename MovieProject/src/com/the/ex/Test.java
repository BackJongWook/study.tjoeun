package com.the.ex;

import java.util.ArrayList;
import java.util.Scanner;
import com.the.dao.MovieDao;
import com.the.dao.ScreeningDao;
import com.the.dao.ReservationDao;
import com.the.dto.MovieDto;
import com.the.dto.ScreeningDto;
//import com.the.movie.*;
import com.the.dto.ReservationDto;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieDao movieDao = new MovieDao();
        ScreeningDao screeningDao = new ScreeningDao();
        ReservationDao reservationDao = new ReservationDao();

        while (true) {
            System.out.println("1. 영화 조회");
            System.out.println("2. 상영 일정 조회");
            System.out.println("3. 영화 예매");
            System.out.println("4. 예매 수정 (좌석 수 변경)");
            System.out.println("5. 예매 취소");
            System.out.println("6. 예매 내역 조회");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
   
//            // move <- 부모객체를 만든다
//            // move를 부모로 쓰는 자식을 쓴다.
//            // move를 선언하고 자식을 넣는다.
//            // move를 업데이트 시킨다.
//            Movie ex = null;
//            ex = new MovieFirst();
//            ex.update();
            

            switch (choice) {
                case 1:
                    ArrayList<MovieDto> movies = movieDao.selectAllMovies();
                    for (MovieDto movie : movies) {
                        System.out.println(movie);
                    } break;
                case 2:
                    ArrayList<ScreeningDto> screenings = screeningDao.selectAllScreening();
                    for (ScreeningDto screening : screenings) {
                        System.out.println(screening);
                    }
                    break;
                case 3:
                    System.out.print("상영 ID 입력: ");
                    int screening_id = scanner.nextInt();
                    System.out.print("좌석 수 입력: ");
                    int seat_count = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("비밀번호 입력 (4자리): ");
                    String password_pw = scanner.nextLine();
                    ReservationDto reservation = new ReservationDto(0, screening_id, seat_count, password_pw);
                    reservationDao.insertReservation(reservation);
                    break;
                case 4:
                    // 예매 수정 (좌석 수 변경)
                    System.out.print("예매 ID 입력: ");
                    int reservation_id = scanner.nextInt();
                    System.out.print("새 좌석 수 입력: ");
                    int new_seat_count = scanner.nextInt();
                    scanner.nextLine(); // 버퍼 비우기
                    System.out.print("비밀번호 입력: ");
                    String password_pw1 = scanner.nextLine();
                    reservationDao.updateReservation(reservation_id, new_seat_count, password_pw1);
                    break;
                case 5:
                    System.out.print("예매 ID 입력: ");
                    int deleteReservationId = scanner.nextInt();
                    reservationDao.deleteReservation(deleteReservationId);
                    break;
                case 6:
                    ArrayList<ReservationDto> reservations = reservationDao.selectAllReservations();
                    for (ReservationDto res : reservations) {
                        System.out.println(res);
                    }
                    break;
                case 0:
                    System.out.println("프로그램 종료!");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 입력!");
            }
        }
    }
}
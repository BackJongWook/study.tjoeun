package com.the.selecter;
import com.the.util.DBConn;
import java.util.*;
import java.sql.Timestamp;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.the.util.*;

class Movies {
	int id;
	String title;
	String genre;
}
class Screening {
	int screening_id;
	int movie_id;
	Timestamp screening_time;
}

class Reservation {
	int reservation_id;
	int screening_id;
	int seat_count;
	String password_pw;
}


public class Reserve extends Program  {
	public Reserve() {}
	Scanner sc = new Scanner(System.in);
	DBConn sql = new DBConn();
		
	@Override
	boolean progress() {
		List<Movies> mv = getMovies();
		System.out.println("---------------");
		
		List<String> movieInfo = new  ArrayList<>();
		for(int i=0;i<mv.size();i++) {
			Movies movies = mv.get(i);
			String info = (i+1) + " : " + movies.title + " : " + movies.genre;
			movieInfo.add(info);
			System.out.println(info);
		}
		System.out.println("영화를 선택하십시오.");
		int movieInputIndex = sc.nextInt(); //입력받은 영화 번호
		int movieInput = movieInputIndex-1; //실제 영화 인덱스 변호
		
		//선택한 영화 정보 저장
		Movies selectedMovie = mv.get(movieInput);
		
		List<Screening> scr = getScreening(selectedMovie.id);
		System.out.println("");
		System.out.println("선택한 영화: " + selectedMovie.title + " (" + selectedMovie.genre + ")");
		
		List<String> screeningInfo = new ArrayList<>();
		for(int i=0;i<scr.size();i++) {
			Screening screening = scr.get(i);
			String info = (i+1) + " : " + "상영시간: " + screening.screening_time;
			screeningInfo.add(info);//상영정보 리스트에 추가
			System.out.println(info); //콘솔 출력
		}
//		for(Screening i: scr) {
//			System.out.printf(screeningIndex+" : ");
//			System.out.println("상영시간: "+i.screening_time);
//			}
		System.out.println("상영시간을 선택하십시오.");
		int screeningInput = sc.nextInt();
		
		System.out.println("예매할 좌석 수를 입력하세요.");
		int seatInput = sc.nextInt();
		
		System.out.println("해당 주문의 비밀번호를 입력하세요.");
		int pwInput = sc.nextInt();
		
		insertMovieAndScreening(scr.get(screeningInput-1).screening_id, seatInput, pwInput);
		int rsId = getReservationMaxId();
		System.out.println("예매 완료");
		System.out.println("예매 번호는 "+rsId+"입니다. 비밀번호를 기억해주세요.");
		
		return super.progress();
	}
	
	List<Movies> getMovies() {
		List<Movies> movies = new ArrayList<Movies>(); 
		Movies temp = null;
		try {
			ResultSet movieData = sql.statementQuery("select * from movie");
			while(movieData.next()){
				temp = new Movies();
				temp.id = movieData.getInt("MOVIE_ID");
				temp.title = movieData.getString("TITLE");
				temp.genre = movieData.getString("GENRE");
				movies.add(temp);
			}
		}
		catch(SQLException e) {  }
		finally { sql.close(); }
		return movies;
	}
	List<Screening> getScreening(int movieInput) {
		List<Screening> scr = new ArrayList<Screening>();
		Screening temp = null;
		try {
			ResultSet screeningData = sql.statementQuery(String.format("select * from screening where movie_id='%d'", movieInput));
			while(screeningData.next()) {
				temp = new Screening();
				temp.screening_id = screeningData.getInt("SCREENING_ID");
				temp.movie_id = screeningData.getInt("movie_id");
				temp.screening_time = screeningData.getTimestamp("screening_time");
				scr.add(temp);
			}
		} catch(SQLException e) {}
		finally {
			sql.close();
		}
		return scr;
	}		
	List<Reservation> getReservation() {
		List<Reservation> rsv = new ArrayList<Reservation>();
		Reservation temp = null;
		try {
			ResultSet reservationData = sql.statementQuery("select * from reservation");
			while(reservationData.next()) {
				temp = new Reservation();
				temp.reservation_id = reservationData.getInt("reservation_id");
				temp.screening_id = reservationData.getInt("screening_id");
				temp.seat_count	= reservationData.getInt("seat_count");
				temp.password_pw = reservationData.getString("password_pw");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return rsv;
	}
	void insertMovieAndScreening(int screeningInput, int seatInput, int pwInput) {
		String sql = "insert into reservation (screening_id,seat_count,password_pw) values ("+screeningInput+","+seatInput+","+pwInput+")";
		DBConn.statementUpdate(sql);
		}
	int getReservationMaxId() {
		int returnId = 0;
		String sql = "select max(reservation_id) as max_id from reservation";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				returnId = rs.getInt("max_id");
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
		return returnId;
	}
	
}

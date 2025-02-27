package com.the.dto;

public class ReservationDto {
    private int reservation_id;
    private int screening_id;
    private int seat_count;
    private String password_pw;

    public ReservationDto(int reservation_id, int screening_id, int seat_count, String password_pw) {
        this.reservation_id = reservation_id;
        this.screening_id = screening_id;
        this.seat_count = seat_count;
        this.password_pw = password_pw;
    }

    public int getReservation_id() { return reservation_id; }
    public int getScreening_id() { return screening_id; }
    public int getSeat_count() { return seat_count; }
    public String getPassword_pw() { return password_pw; }

    public void setReservation_id(int reservation_id) { this.reservation_id = reservation_id; }
    public void setScreening_id(int screening_id) { this.screening_id = screening_id; }
    public void setSeat_count(int seat_count) { this.seat_count = seat_count; }
    public void setPassword_pw(String password_pw) { this.password_pw = password_pw; }

    @Override
    public String toString() {
        return "ReservationDto [reservation_id=" + reservation_id + ", screening_id=" + screening_id + ", seat_count=" + seat_count + ", password_pw=" + password_pw + "]";
    }
}
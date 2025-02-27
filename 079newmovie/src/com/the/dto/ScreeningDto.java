package com.the.dto;
import java.util.Objects;
import java.sql.Date;

public class ScreeningDto {
	private int screening_id;
	private int movie_id;
	private Date screening_time;
	
	public int getScreening_id() {
		return screening_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movie_id, screening_id, screening_time);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScreeningDto other = (ScreeningDto) obj;
		return movie_id == other.movie_id && screening_id == other.screening_id
				&& Objects.equals(screening_time, other.screening_time);
	}
	public void setScreening_id(int screening_id) {
		this.screening_id = screening_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public Date getScreening_time() {
		return screening_time;
	}
	public void setScreening_time(Date screening_time) {
		this.screening_time = screening_time;
	}
	@Override
	public String toString() {
		return "ScreeningDto [screening_id=" + screening_id + ", movie_id=" + movie_id + ", screening_time="
				+ screening_time + "]";
	}
	public ScreeningDto(int screening_id, int movie_id, Date screening_time) {
		super();
		this.screening_id = screening_id;
		this.movie_id = movie_id;
		this.screening_time = screening_time;
	}
	
}

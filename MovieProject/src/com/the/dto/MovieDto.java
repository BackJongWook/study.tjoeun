package com.the.dto;


import java.time.LocalDate;
import java.util.Objects;

public class MovieDto {
    private int movie_id;
    private String title;
    private String genre;
    
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(genre, movie_id, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDto other = (MovieDto) obj;
		return Objects.equals(genre, other.genre) && movie_id == other.movie_id && Objects.equals(title, other.title);
	}
	
	@Override
	public String toString() {
		return "MovieDto [movie_id=" + movie_id + ", title=" + title + ", genre=" + genre + "]";
	}
	
	public MovieDto() {}
	
	public MovieDto(int movie_id, String title, String genre) {
		super();
		this.movie_id = movie_id;
		this.title = title;
		this.genre = genre;
	}

    
}
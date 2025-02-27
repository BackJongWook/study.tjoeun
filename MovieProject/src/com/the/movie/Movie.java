package com.the.movie;

public class Movie  {
	String name;
	// 오버로딩
	boolean progress() {
		return false;
	}
	public void update() {
		while(progress());
	}
}

//extends

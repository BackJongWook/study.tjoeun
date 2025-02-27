package com.the.ex;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.sql.Types;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Human{
	String name;
	int age;
	double height;
	LocalDateTime birthday;
	Human(String name, int age, double height, LocalDateTime birthday ){
		this.name = name;
		this.age = age;
		this.height = height;
		this.birthday = birthday;
	}
}

public class Sql implements Sql_Interface {
	public Object getSql(ResultSet rs) {
		try {
			String name = rs.getString(1);
			int age = rs.getInt(2);
			double height = rs.getDouble(3);
			LocalDateTime birthday = rs.getTimestamp(4).toLocalDateTime();
			System.out.println(name);
			return new Human(name,age,height,birthday);
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
		return null;
	}
}
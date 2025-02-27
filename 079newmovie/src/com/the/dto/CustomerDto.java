package com.the.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class CustomerDto {
	private Long id;
	private String name;
	private Integer age;
	private Double height;
	private LocalDateTime birthday;

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", birthday="
				+ birthday + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, height, birthday);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		CustomerDto other = (CustomerDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(age, other.age)
				&& Objects.equals(height, other.height) && Objects.equals(birthday, other.birthday);
	}

	public CustomerDto() {
	}

	public CustomerDto(Long id, String name, Integer age, Double height, LocalDateTime birthday) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.birthday = birthday;
	}
}
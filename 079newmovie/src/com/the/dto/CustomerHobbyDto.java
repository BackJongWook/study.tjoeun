package com.the.dto;
import java.time.LocalDateTime;
import java.util.Objects;

public class CustomerHobbyDto {
	private Long id;
	private String name;
	private Integer age;
	private Double height;
	private LocalDateTime birthday;
	
	private Long hobby_id;
	private String hobby;
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
	public Long getHobby_id() {
		return hobby_id;
	}
	public void setHobby_id(Long hobby_id) {
		this.hobby_id = hobby_id;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, birthday, height, hobby, hobby_id, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerHobbyDto other = (CustomerHobbyDto) obj;
		return Objects.equals(age, other.age) && Objects.equals(birthday, other.birthday)
				&& Objects.equals(height, other.height) && Objects.equals(hobby, other.hobby)
				&& Objects.equals(hobby_id, other.hobby_id) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "CustomHobbyDto [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", birthday="
				+ birthday + ", hobby_id=" + hobby_id + ", hobby=" + hobby + "]";
	}
	public CustomerHobbyDto(Long id, String name, Integer age, Double height, LocalDateTime birthday, Long hobby_id,
			String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.birthday = birthday;
		this.hobby_id = hobby_id;
		this.hobby = hobby;
	}
	
}

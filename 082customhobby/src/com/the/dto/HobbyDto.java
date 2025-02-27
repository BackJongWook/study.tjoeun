package com.the.dto;

import java.util.Objects;

public class HobbyDto {
	private Long id;
	private Long customerId;
	private String hobby;
	
	
	@Override
	public String toString() {
		return "HobbyDto [id=" + id + ", customerId=" + customerId + ", hobby=" + hobby + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerId, hobby, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HobbyDto other = (HobbyDto) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(hobby, other.hobby)
				&& Objects.equals(id, other.id);
	}
	public HobbyDto() {}
	public HobbyDto(Long id, Long customerId, String hobby) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.hobby = hobby;
	}
	
	
	
}

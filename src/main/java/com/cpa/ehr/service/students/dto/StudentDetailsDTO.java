package com.cpa.ehr.service.students.dto;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class StudentDetailsDTO 
{
	private Long stuId;
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String firstName;

	
	@NotBlank
	private String lastName;
	
	
	public Long getStuId() {
		return stuId;
	}
	public void setStuId(Long stuId) {
		this.stuId = stuId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "StudentDetailsDTO [stuId=" + stuId + ", userName=" + userName
				+ ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}



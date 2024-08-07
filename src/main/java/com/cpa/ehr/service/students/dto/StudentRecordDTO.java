package com.cpa.ehr.service.students.dto;
import java.util.Date;
import java.util.Arrays;

import javax.validation.constraints.Size;
public class StudentRecordDTO 
{
private Long stuId;
	
	
	@Size(max = 100)
	private String userName;

	@Size(max = 100)
	private String password;

	@Size(max = 100)
	private String firstName;
	
	
	@Size(max = 100)
	private String lastName;
	
//	private Date createdDate;
//	
//	@Size(max = 100)
//	private String createdBy;
//	
//	private Date lastUpdatedDate;
//	
//	@Size(max = 100)
//	private String lastUpdatedBy;
//	

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

//		public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public Date getLastUpdatedDate() {
//		return lastUpdatedDate;
//	}
//
//	public void setLastUpdatedDate(Date lastUpdatedDate) {
//		this.lastUpdatedDate = lastUpdatedDate;
//	}
//
//	public String getLastUpdatedBy() {
//		return lastUpdatedBy;
//	}
//
//	public void setLastUpdatedBy(String lastUpdatedBy) {
//		this.lastUpdatedBy = lastUpdatedBy;
//	}
//
//	
	@Override
	public String toString() {
		return "StudentRecordDTO [stuId=" + stuId + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}





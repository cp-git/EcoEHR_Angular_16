package com.cpa.ehr.backend.dao.students.entities;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cpa.ehr.converters.StringCryptoConverter;



@Entity
@Table(name = "student_vw")

public class StudentRecord 
{
	@Id
	@Column(name = "student_id")
	private Long stuId;
	
	@Column(name = "user_name")
//	@Convert(converter = StringCryptoConverter.class)
	private String userName;
	
	@Column(name = "password")
//	@Convert(converter = StringCryptoConverter.class)
	private String password;
	
	@Column(name = "first_name")
//	@Convert(converter = StringCryptoConverter.class)
	private String firstName;
	
	
	@Column(name = "last_name")
//	@Convert(converter = StringCryptoConverter.class)
	private String lastName;
	
	    
//	@Column(name="created_date")
//	private Date createdDate;
//	
//	@Column(name="created_by")
//	private String createdBy;
//	
//	@Column(name="last_updated_date")
//	private Date lastUpdatedDate;
//	
//	@Column(name="last_updated_by")
//	private String lastUpdatedBy;
//	
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

	
//	public Date getCreatedDate() {
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

	@Override
	public String toString() {
		return "StudentRecord [stuId=" + stuId + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + " ]";
	}

	
}











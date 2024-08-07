//package com.cpa.ehr.backend.dao.students.entities;
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import org.hibernate.validator.constraints.NotBlank;
///**
// * Entity Class representing Staff Member Table. This table stores 
// * information about the  Staff Members.
// * 
// * @author CPA Development Team
// * @version 1.0.0
// */
//@Entity
//@Table(name="student")
//
//public class StudentMember implements Serializable
//{
//	private static final long serialVersionUID = 2L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
//	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "student_member_id_seq", allocationSize=1)
//	@Column(name="student_id")
//    private Long stuId; 
//	
//	@NotBlank
//	@Size(max = 10)
//	@Column(name="user_name", length = 10, nullable = false)
//    private String userName; 
//	
//	@NotBlank
//	@Size(max = 500)
//	@Column(name="password", length = 500, nullable = false)
//    private String password; 
//	
//	@NotBlank
//	@Size(max = 500)
//	@Column(name="first_name", length = 500, nullable = false)
//    private String firstName; 
//	
//	 
//	
//	@NotBlank
//	@Size(max = 500)
//	@Column(name="last_name", length = 500, nullable = false)
//    private String lastName; 
//	
//		@Column(name = "created_date", nullable = false)
//	private Date createdDate;
//	
//	@Size(max = 100)
//	@Column(name = "created_by", length = 100)
//	private String createdBy;
//	
//	@Column(name = "last_updated_date", nullable = false)
//	private Date lastUpdatedDate;
//	
//	@Size(max = 100)
//	@Column(name = "last_updated_by", length = 100)
//	private String lastUpdatedBy;
//	
//	
//	public Long getStudentId() {
//		return stuId;
//	}
//
//	public void setStudentId(Long stuId) {
//		this.stuId = stuId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	
//	public String Password() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	
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
//	
//	
//
//	
//	@Override
//	public String toString() {
//		return "StudentMember [stuId=" + stuId + ", userName=" + userName + ", password=" + password + ", firstName="
//				+ firstName + ", lastName=" + lastName + ", createdDate="
//				+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
//				+ lastUpdatedBy + "]";
//	}
//	
//
//}
//
//
//

//
//package com.cpa.ehr.backend.dao.students.entities;
//import java.util.Date;
//import java.util.Arrays;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Convert;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.persistence.ForeignKey;
//import com.cpa.ehr.converters.StringCryptoConverter;
//
//@Entity
//
//@Table(name="student_validation")
//
//public class StudentValidation 
//{
//	
////	@Id
////	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
//	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "student_details_id_seq", initialValue=1, allocationSize = 1)
//	@JoinColumn(name = "student_id")
////	@Column(name="student_id")
//	private Long stuId;
//
//	
//	@Column(name="user_name", nullable=false, length=100)
////	@Convert(converter = StringCryptoConverter.class)
//
//	private String userName;
//
//	@Column(name="password", nullable=false, length=100) 
////	@Convert(converter = StringCryptoConverter.class)
//
//	private String password;
//
//
//	public Long getStuId() {
//		return stuId;
//	}
//
//	public void setStuId(Long stuId) {
//		this.stuId = stuId;
//	}
//
//		public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//
//	public String getPassword() {
//		return password;
//	}
//
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//
//
//	
//	@Override
//	public String toString() 
//	{
//		return "StudentValidation [stuId=" + stuId + ", userName=" + userName + ", password=" + password + "]";	
//	}
//}
//
//
//

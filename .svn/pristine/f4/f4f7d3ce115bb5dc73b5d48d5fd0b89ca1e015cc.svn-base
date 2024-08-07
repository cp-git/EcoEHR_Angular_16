package com.cpa.ehr.backend.dao.admin.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity Class representing Staff Member Table. This table stores 
 * information about the  Staff Members.
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Entity
@Table(name="staff")
public class StaffMember implements Serializable  {
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "staff_member_id_seq", allocationSize=1)
	@Column(name="staff_id")
    private Long staffId; 
	
	@NotBlank
	@Size(max = 10)
	@Column(name="login_id", length = 10, nullable = false)
    private String loginId; 
	
	@NotBlank
	@Size(max = 500)
	@Column(name="login_key", length = 500, nullable = false)
    private String loginKey; 
	
	@NotBlank
	@Size(max = 500)
	@Column(name="first_name", length = 500, nullable = false)
    private String firstName; 
	
	@Size(max = 500)
	@Column(name="middle_name", length = 500)
    private String middleName; 
	
	@NotBlank
	@Size(max = 500)
	@Column(name="last_name", length = 500, nullable = false)
    private String lastName; 
	
	@Column(name="staff_image")
    private String staffImage; 
	

	@Size(max = 100)
	@Column(name="provider_type", length = 100)
	private String providerType;	
	
	@Size(max = 100)
	@Column(name="designation", length = 100)
    private String designation; 
	
	@NotBlank
	@Size(max = 1)
	@Column(name="provider_flag", length = 1, nullable = false)
    private String providerFlag;

	@Column(name="active_flag", length = 1, nullable = false)
	private String activeFlag;
	
	
	/* Clinic Location Id */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false)
    private ClinicLocation clinicLocation; 
	
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
    private Organization organization; 
	
	@NotBlank
	@Size(max = 500)
	@Column(name="mobile_no", length = 500)
	private String mobileNo;
	
	@Column(name="business_phone_no", length = 500)
	private String businessPhoneNo;
	
	@NotBlank
	@Size(max = 500)
	@Column(name="email", length = 500)
	private String email;	
	
	@Size(max = 100)
	@Column(name="npi_number", length = 100)
	private String npiNumber;
	
	@Size(max = 100)
	@Column(name="last_client", length = 100)
	private String lastClient;

	@Size(max = 500)
	@Column(name="last_action", length = 500)
	private String lastAction;
	
	@Column(name="last_login_dt")
	private Date lastLoginDate;

	@Column(name="last_action_dt")
	private String lastActionDate;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	
	@Size(max = 100)
	@Column(name = "created_by", length = 100)
	private String createdBy;
	
	@Column(name = "last_updated_date", nullable = false)
	private Date lastUpdatedDate;
	
	@Size(max = 100)
	@Column(name = "last_updated_by", length = 100)
	private String lastUpdatedBy;
	
	@Column(name = "license_state")
	private String licenseState;
	
	@Column(name = "license_number")
	private String licenseNumber;
	
	@Column(name = "license_exp_date")
	private String licenseExpDate;
	
	@Column(name = "dea_number")
	private String deaNumber;
	
	@Column(name = "dea_exp_date")
	private String deaExpDate;
	
	@Column(name = "mal_coverage")
	private String malpracticeCoverage;
	
	@Column(name = "mal_expiration")
	private Date malpracticeExpiration;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "ssn")
	private String ssn;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginKey() {
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getStaffImage() {
		return staffImage;
	}

	public void setStaffImage(String staffImage) {
		this.staffImage = staffImage;
	}

	public String getProviderType() {
		return providerType;
	}

	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getProviderFlag() {
		return providerFlag;
	}

	public void setProviderFlag(String providerFlag) {
		this.providerFlag = providerFlag;
	}


	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public ClinicLocation getClinicLocation() {
		return clinicLocation;
	}

	public void setClinicLocation(ClinicLocation clinicLocation) {
		this.clinicLocation = clinicLocation;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getBusinessPhoneNo() {
		return businessPhoneNo;
	}

	public void setBusinessPhoneNo(String businessPhoneNo) {
		this.businessPhoneNo = businessPhoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNpiNumber() {
		return npiNumber;
	}

	public void setNpiNumber(String npiNumber) {
		this.npiNumber = npiNumber;
	}

	public String getLastClient() {
		return lastClient;
	}

	public void setLastClient(String lastClient) {
		this.lastClient = lastClient;
	}

	public String getLastAction() {
		return lastAction;
	}

	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastActionDate() {
		return lastActionDate;
	}

	public void setLastActionDate(String lastActionDate) {
		this.lastActionDate = lastActionDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	public String getFullName() {
		if(this.designation!=null && this.designation.trim().length()>0)
			return firstName +" "+lastName+","+this.designation;
		return firstName +" "+lastName;
	}

	public String getLicenseState() {
		return licenseState;
	}

	public void setLicenseState(String licenseState) {
		this.licenseState = licenseState;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getLicenseExpDate() {
		return licenseExpDate;
	}

	public void setLicenseExpDate(String licenseExpDate) {
		this.licenseExpDate = licenseExpDate;
	}

	public String getDeaNumber() {
		return deaNumber;
	}

	public void setDeaNumber(String deaNumber) {
		this.deaNumber = deaNumber;
	}

	public String getDeaExpDate() {
		return deaExpDate;
	}

	public void setDeaExpDate(String deaExpDate) {
		this.deaExpDate = deaExpDate;
	}

	public String getMalpracticeCoverage() {
		return malpracticeCoverage;
	}

	public void setMalpracticeCoverage(String malpracticeCoverage) {
		this.malpracticeCoverage = malpracticeCoverage;
	}

	public Date getMalpracticeExpiration() {
		return malpracticeExpiration;
	}

	public void setMalpracticeExpiration(Date malpracticeExpiration) {
		this.malpracticeExpiration = malpracticeExpiration;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "StaffMember [staffId=" + staffId + ", loginId=" + loginId + ", loginKey=" + loginKey + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", staffImage=" + staffImage
				+ ", providerType=" + providerType + ", designation=" + designation + ", providerFlag=" + providerFlag
				+ ", activeFlag=" + activeFlag + ", clinicLocation=" + clinicLocation + ", organization=" + organization
				+ ", mobileNo=" + mobileNo + ", businessPhoneNo=" + businessPhoneNo + ", email=" + email
				+ ", npiNumber=" + npiNumber + ", lastClient=" + lastClient + ", lastAction=" + lastAction
				+ ", lastLoginDate=" + lastLoginDate + ", lastActionDate=" + lastActionDate + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", licenseState=" + licenseState + ", licenseNumber=" + licenseNumber
				+ ", licenseExpDate=" + licenseExpDate + ", deaNumber=" + deaNumber + ", deaExpDate=" + deaExpDate
				+ ", malpracticeCoverage=" + malpracticeCoverage + ", malpracticeExpiration=" + malpracticeExpiration
				+ ", dob=" + dob + ", gender=" + gender + ", ssn=" + ssn + "]";
	}
	
}


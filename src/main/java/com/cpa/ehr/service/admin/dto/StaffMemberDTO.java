package com.cpa.ehr.service.admin.dto;

import java.util.Date;
import javax.validation.constraints.Size;

/**
 * DTO representing Staff Member Entity. 
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
public class StaffMemberDTO {
	
    private Long staffId; 
	
    private String loginId; 
	
    private String loginKey; 
	
    private String firstName; 
	
    private String middleName; 
	
    private String lastName; 
    
    private String staffImage; 
	
	private String providerType;	
	
    private String designation; 
	
    private String providerFlag; 

    private Boolean activeFlag;
	
    private Long clinicLocationId; 
	
	private Long organizationId;
	
	private String mobileNo;
	
	private String businessPhoneNo;
	
	private String email;	
	
	private String npiNumber;
	
	private String lastClient;

	private String lastAction;
	
	private Date lastLoginDate;

	private String lastActionDate;

	private Date createdDate;
	
	@Size(max = 100)
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	@Size(max = 100)
	private String lastUpdatedBy;
	
	private String licenseState;
	
	private String licenseNumber;
	
	private String licenseExpDate;
	
	private String deaNumber;
	
	private String deaExpDate;
	
	private String malpracticeCoverage;
	
	private Date malpracticeExpiration;
	
	private Date dob;
	
	private String gender;
	
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

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Long getClinicLocationId() {
		return clinicLocationId;
	}

	public void setClinicLocationId(Long clinicLocationId) {
		this.clinicLocationId = clinicLocationId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
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

	public StaffMemberDTO() {
		super();
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
		return "StaffMemberDTO [staffId=" + staffId + ", loginId=" + loginId + ", loginKey=" + loginKey + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", staffImage=" + staffImage
				+ ", providerType=" + providerType + ", designation=" + designation + ", providerFlag=" + providerFlag
				+ ", activeFlag=" + activeFlag + ", clinicLocationId=" + clinicLocationId + ", organizationId="
				+ organizationId + ", mobileNo=" + mobileNo + ", businessPhoneNo=" + businessPhoneNo + ", email="
				+ email + ", npiNumber=" + npiNumber + ", lastClient=" + lastClient + ", lastAction=" + lastAction
				+ ", lastLoginDate=" + lastLoginDate + ", lastActionDate=" + lastActionDate + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + ", licenseState=" + licenseState + ", licenseNumber=" + licenseNumber
				+ ", licenseExpDate=" + licenseExpDate + ", deaNumber=" + deaNumber + ", deaExpDate=" + deaExpDate
				+ ", malpracticeCoverage=" + malpracticeCoverage + ", malpracticeExpiration=" + malpracticeExpiration
				+ ", dob=" + dob + ", gender=" + gender + ", ssn=" + ssn + "]";
	}
}
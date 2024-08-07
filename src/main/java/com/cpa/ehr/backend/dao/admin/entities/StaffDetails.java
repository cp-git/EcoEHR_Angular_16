package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

@Table(name="staff_vw")
public class StaffDetails {

	@Id
	@Column(name="staff_id")
	private Long staffId;

	@Column(name="organization_id")
	private Long organizationId;

	@Column(name="login_id")
	private String loginId;

	@Column(name="login_key") 
	private String loginKey;

	@Column(name="first_name")
	private String firstName;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="provider_flag")
	private String providerFlag;

	@Column(name="designation")
	private String designation;

	@Column(name="last_login_dt")
	private Date lastLoginDt;

	@Column(name="last_action_dt")
	private String lastActionDt;

	@Column(name="last_action")
	private String lastAction;

	@Column(name="last_client")
	private String lastClient;

	@Column(name="mobile_no")
	private String mobileNo;

	@Column(name="business_phone_no")
	private String businessPhoneNo;

	@Column(name="provider_type")
	private String providerType;

	@Column(name="email")
	private String email;

	@Column(name="staff_image")
	private String staffImage;

	@Column(name="staff_role_id")
	private Long staffRoleId; 

	@Column(name="staffrole")
	private String staffrole;

	@Column(name="staff_address_id")
	private Long staffAddressId;

	@Column(name="location_id")
	private Long  locationId;

	@Column(name="loc_name")
	private String locName;

	@Column(name="address_door_no")
	private String addressDoorNo;

	@Column(name="address_street")
	private String addressStreet;

	@Column(name="address_city")
	private String addressCity;

	@Column(name="address_state")
	private String addressState;

	@Column(name="address_zip")
	private String addressZip;

	@Column(name="active_flag")
	private String activeFlag;

	@Column(name="created_date")
	private Date createdDate;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="last_updated_date")
	private Date lastUpdatedDate;

	@Column(name="last_updated_by")
	private String lastUpdatedBy;

	@Column(name="npi_number")
	private String npiNumber;
	
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
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name = "ehr_license_start_date")
	private Date licenseStartDate;
	
	@Column(name = "ehr_license_end_date")
	private Date licenseEndDate;

	
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getLicenseStartDate() {
		return licenseStartDate;
	}

	public void setLicenseStartDate(Date licenseStartDate) {
		this.licenseStartDate = licenseStartDate;
	}

	public Date getLicenseEndDate() {
		return licenseEndDate;
	}

	public void setLicenseEndDate(Date licenseEndDate) {
		this.licenseEndDate = licenseEndDate;
	}

	public String getNpiNumber() {
		return npiNumber;
	}

	public void setNpiNumber(String npiNumber) {
		this.npiNumber = npiNumber;
	}

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
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


	public String getProviderFlag() {
		return providerFlag;
	}


	public void setProviderFlag(String providerFlag) {
		this.providerFlag = providerFlag;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Date getLastLoginDt() {
		return lastLoginDt;
	}


	public void setLastLoginDt(Date lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}


	public String getLastActionDt() {
		return lastActionDt;
	}


	public void setLastActionDt(String lastActionDt) {
		this.lastActionDt = lastActionDt;
	}


	public String getLastAction() {
		return lastAction;
	}


	public void setLastAction(String lastAction) {
		this.lastAction = lastAction;
	}


	public String getLastClient() {
		return lastClient;
	}


	public void setLastClient(String lastClient) {
		this.lastClient = lastClient;
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


	public String getProviderType() {
		return providerType;
	}


	public void setProviderType(String providerType) {
		this.providerType = providerType;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getStaffImage() {
		return staffImage;
	}


	public void setStaffImage(String staffImage) {
		this.staffImage = staffImage;
	}


	public Long getStaffRoleId() {
		return staffRoleId;
	}


	public void setStaffRoleId(Long staffRoleId) {
		this.staffRoleId = staffRoleId;
	}


	public String getStaffrole() {
		return staffrole;
	}


	public void setStaffrole(String staffrole) {
		this.staffrole = staffrole;
	}


	public Long getStaffAddressId() {
		return staffAddressId;
	}


	public void setStaffAddressId(Long staffAddressId) {
		this.staffAddressId = staffAddressId;
	}


	public Long getLocationId() {
		return locationId;
	}


	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}


	public String getLocName() {
		return locName;
	}


	public void setLocName(String locName) {
		this.locName = locName;
	}


	public String getAddressDoorNo() {
		return addressDoorNo;
	}


	public void setAddressDoorNo(String addressDoorNo) {
		this.addressDoorNo = addressDoorNo;
	}


	public String getAddressStreet() {
		return addressStreet;
	}


	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}


	public String getAddressCity() {
		return addressCity;
	}


	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}


	public String getAddressState() {
		return addressState;
	}


	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}


	public String getAddressZip() {
		return addressZip;
	}


	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}


	public String getActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}


	public Boolean getAdmin() {
		boolean res;

		if(staffrole.equalsIgnoreCase("Admin"))
		{
			res=true;
		}
		else
		{
			res=false;
		}

		return res;
	}

	@Override
	public String toString() {
		return "StaffDetails [staffId=" + staffId + ", organizationId=" + organizationId + ", loginId=" + loginId
				+ ", loginKey=" + loginKey + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", providerFlag=" + providerFlag + ", designation=" + designation + ", lastLoginDt="
				+ lastLoginDt + ", lastActionDt=" + lastActionDt + ", lastAction=" + lastAction + ", lastClient="
				+ lastClient + ", mobileNo=" + mobileNo + ", businessPhoneNo=" + businessPhoneNo + ", providerType="
				+ providerType + ", email=" + email + ", staffImage=" + staffImage + ", staffRoleId=" + staffRoleId
				+ ", staffrole=" + staffrole + ", staffAddressId=" + staffAddressId + ", locationId=" + locationId
				+ ", locName=" + locName + ", addressDoorNo=" + addressDoorNo + ", addressStreet=" + addressStreet
				+ ", addressCity=" + addressCity + ", addressState=" + addressState + ", addressZip=" + addressZip
				+ ", activeFlag=" + activeFlag + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", npiNumber="
				+ npiNumber + ", licenseState=" + licenseState + ", licenseNumber=" + licenseNumber
				+ ", licenseExpDate=" + licenseExpDate + ", deaNumber=" + deaNumber + ", deaExpDate=" + deaExpDate
				+ ", malpracticeCoverage=" + malpracticeCoverage + ", malpracticeExpiration=" + malpracticeExpiration
				+ ", dob=" + dob + ", gender=" + gender + ", ssn=" + ssn + "]";
	}
	
}

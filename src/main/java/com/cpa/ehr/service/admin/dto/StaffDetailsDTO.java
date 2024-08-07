package com.cpa.ehr.service.admin.dto;

import java.util.Date;

import javax.validation.constraints.Size;

public class StaffDetailsDTO {

		private Long staffId;
	
		private Long organizationId;
		
        @Size(max = 10)
		private String loginId;
		
    	@Size(max = 500)
		private String loginKey;
		
    	@Size(max = 500)
		private String firstName;
		
    	@Size(max = 500)
		private String middleName;
		
    	@Size(max = 500)
        private String lastName;
		
    	@Size(max = 1)
		private String providerFlag;
		
    	@Size(max = 100)
		private String designation;
	
    	@Size(max = 500)
		private Date lastLoginDt;
		
    	@Size(max = 500)
		private String lastActionDt;
		
    	@Size(max = 500)
		private String lastAction;
		
    	@Size(max = 500)
		private String lastClient;
		
    	@Size(max = 500)
		private String mobileNo;
		
    	@Size(max = 500)
      	private String businessPhoneNo;
		
        @Size(max = 100)
		private String providerType;
		
    	private String email;
    	
    	private String staffImage;
		
    	private Long staffRoleId; 
    	
		private String staffrole;
		
		private Long staffAddressId;
		
		private Long locationId;
		
		private String locName;
		
		private String addressDoorNo;
		
		private String addressStreet;
		
		
		private String addressCity;
		
		private String addressState;
		
		private String addressZip;
		
		private Boolean activeFlag;
		
		private Date createdDate;
		
        @Size(max = 100)
		private String createdBy;
		
		private Date lastUpdatedDate;
		
        @Size(max = 100)
		private String lastUpdatedBy;

        private String npiNumber;
        
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
    	
    	private String paymentStatus;
    	
    	
		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
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

		public Boolean getActiveFlag() {
			return activeFlag;
		}

		public void setActiveFlag(Boolean activeFlag) {
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

		public String getLastUpdatedBy() {
			return lastUpdatedBy;
		}

		public void setLastUpdatedBy(String lastUpdatedBy) {
			this.lastUpdatedBy = lastUpdatedBy;
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

		public String getStaffFullName() {
			if(designation == null) {
				return firstName + " " + lastName;
			}
			return firstName +" " +lastName+", "+designation;
		}

		@Override
		public String toString() {
			return "StaffDetailsDTO [staffId=" + staffId + ", organizationId=" + organizationId + ", loginId=" + loginId
					+ ", loginKey=" + loginKey + ", firstName=" + firstName + ", middleName=" + middleName
					+ ", lastName=" + lastName + ", providerFlag=" + providerFlag + ", designation=" + designation
					+ ", lastLoginDt=" + lastLoginDt + ", lastActionDt=" + lastActionDt + ", lastAction=" + lastAction
					+ ", lastClient=" + lastClient + ", mobileNo=" + mobileNo + ", businessPhoneNo=" + businessPhoneNo
					+ ", providerType=" + providerType + ", email=" + email + ", staffImage=" + staffImage
					+ ", staffRoleId=" + staffRoleId + ", staffrole=" + staffrole + ", staffAddressId=" + staffAddressId
					+ ", locationId=" + locationId + ", locName=" + locName + ", addressDoorNo=" + addressDoorNo
					+ ", addressStreet=" + addressStreet + ", addressCity=" + addressCity + ", addressState="
					+ addressState + ", addressZip=" + addressZip + ", activeFlag=" + activeFlag + ", createdDate="
					+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate
					+ ", lastUpdatedBy=" + lastUpdatedBy + ", npiNumber=" + npiNumber + ", licenseState=" + licenseState
					+ ", licenseNumber=" + licenseNumber + ", licenseExpDate=" + licenseExpDate + ", deaNumber="
					+ deaNumber + ", deaExpDate=" + deaExpDate + ", malpracticeCoverage=" + malpracticeCoverage
					+ ", malpracticeExpiration=" + malpracticeExpiration + ", dob=" + dob + ", gender=" + gender
					+ ", ssn=" + ssn + "]";
		}

}

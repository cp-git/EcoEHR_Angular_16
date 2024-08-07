
package com.cpa.ehr.backend.dao.patients.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cpa.ehr.converters.StringCryptoConverter;


@Entity
@Table(name = "patient_vw")
public class PatientRecord {
	@Id
	@Column(name = "patient_id")
	private Long patientId;
	
	@Column(name = "active_flag")
	private String activeFlag;
	
	@Column(name = "additional_info")
	@Convert(converter = StringCryptoConverter.class)
	private String additionalInfo;
	
	@Column(name = "dob")
	private Date dob;
	
	@Column(name = "emr_id")
	private String emrId;
	
	@Column(name = "patient_first_name")
	@Convert(converter = StringCryptoConverter.class)
	private String firstName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "patient_last_name")
	@Convert(converter = StringCryptoConverter.class)
	private String lastName;
	
	@Column(name = "patient_middle_name")
	private String middleName;
	
	
	@Column(name = "patient_apartment_no")
	@Convert(converter = StringCryptoConverter.class)
	private String patientApartmentNo;
	
	@Column(name = "patient_city")
	@Convert(converter = StringCryptoConverter.class)
	private String patientCity;
	
	@Column(name = "patient_image")
	private byte[] patientImage;
	
	@Column(name = "patient_state")
	@Convert(converter = StringCryptoConverter.class)
	private String patientState;
	
	@Column(name = "patient_street_address")
	@Convert(converter = StringCryptoConverter.class)
	private String patientStreetAddress;

	@Column(name = "patient_primary_email")
	private String primaryEmail;
	
	@Column(name = "patient_secondary_email")
	private String secondaryEmail;
	
	@Column(name = "patient_primary_no")
	private String primaryNo;
	
	@Column(name = "patient_secondary_no")
	private String secondaryNo;
	
	@Column(name = "patient_zip_code")
	@Convert(converter = StringCryptoConverter.class)
	private String zipCode;

	@Column(name = "patient_primary_location")
	private Long primaryLocation;
	
	@Column(name="organization_id")
	private Long organizationId;
	
	@Column(name = "patient_primary_provider")
	private Long primaryProvider;

	@Column(name = "provider_first_name")
	private String providerFirstName;
	
	@Column(name = "provider_middle_name")
	private String providerMiddleName;
	
	@Column(name = "provider_last_name")
	private String providerLastName;
	
	@Column(name = "provider_flag")
	private String providerFlag;
	
	@Column(name = "provider_type")
	private String providerType;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
    @Column(name="business_phone_no")
  	private String businessPhoneNo;

    @Column(name="email")
	private String email;
    
    @Column(name="npi_number")
    private String npiNumber;

    @Column(name="clinic_city")
    private String clinicCity;
    
    @Column(name="clinic_address_door_no")
    private String clinicAddressDoorNo;
    
    @Column(name="clinic_address_state")
    private String clinicAddressState;
    
    @Column(name="clinic_address_street")
    private String clinicAddressStreet;
    
    @Column(name="clinic_address_zip")
    private String clinicAddressZip;
    
    @Column(name="clinic_contact_email")
    private String clinicContactEmail;
    
    @Column(name="clinic_contact_name")
    private String clinicContactName;
    
    @Column(name="ein_number")
    private String einNumber;
    
    @Column(name="clinic_fax_no")
    private String clinicFaxNo;
    
    @Column(name="clinic_loc_name")
    private String clinicLocName;
    
    @Column(name="clinic_primary_no")
    private String clinicPrimaryNo;
    
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by")
	private String lastUpdatedBy;
	
	@Column(name="mrn")
	private String mrn;

	
	
	public String getMrn() {
		return mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmrId() {
		return emrId;
	}

	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPatientApartmentNo() {
		return patientApartmentNo;
	}

	public void setPatientApartmentNo(String patientApartmentNo) {
		this.patientApartmentNo = patientApartmentNo;
	}

	public String getPatientCity() {
		return patientCity;
	}

	public void setPatientCity(String patientCity) {
		this.patientCity = patientCity;
	}

	public byte[] getPatientImage() {
		return patientImage;
	}

	public void setPatientImage(byte[] patientImage) {
		this.patientImage = patientImage;
	}

	public String getPatientState() {
		return patientState;
	}

	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}

	public String getPatientStreetAddress() {
		return patientStreetAddress;
	}

	public void setPatientStreetAddress(String patientStreetAddress) {
		this.patientStreetAddress = patientStreetAddress;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getPrimaryNo() {
		return primaryNo;
	}

	public void setPrimaryNo(String primaryNo) {
		this.primaryNo = primaryNo;
	}

	public String getSecondaryNo() {
		return secondaryNo;
	}

	public void setSecondaryNo(String secondaryNo) {
		this.secondaryNo = secondaryNo;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getPrimaryLocation() {
		return primaryLocation;
	}

	public void setPrimaryLocation(Long primaryLocation) {
		this.primaryLocation = primaryLocation;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getPrimaryProvider() {
		return primaryProvider;
	}

	public void setPrimaryProvider(Long primaryProvider) {
		this.primaryProvider = primaryProvider;
	}

	public String getProviderFirstName() {
		return providerFirstName;
	}

	public void setProviderFirstName(String providerFirstName) {
		this.providerFirstName = providerFirstName;
	}

	public String getProviderMiddleName() {
		return providerMiddleName;
	}

	public void setProviderMiddleName(String providerMiddleName) {
		this.providerMiddleName = providerMiddleName;
	}

	public String getProviderLastName() {
		return providerLastName;
	}

	public void setProviderLastName(String providerLastName) {
		this.providerLastName = providerLastName;
	}

	public String getProviderFlag() {
		return providerFlag;
	}

	public void setProviderFlag(String providerFlag) {
		this.providerFlag = providerFlag;
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

	public String getClinicCity() {
		return clinicCity;
	}

	public void setClinicCity(String clinicCity) {
		this.clinicCity = clinicCity;
	}

	public String getClinicAddressDoorNo() {
		return clinicAddressDoorNo;
	}

	public void setClinicAddressDoorNo(String clinicAddressDoorNo) {
		this.clinicAddressDoorNo = clinicAddressDoorNo;
	}

	public String getClinicAddressState() {
		return clinicAddressState;
	}

	public void setClinicAddressState(String clinicAddressState) {
		this.clinicAddressState = clinicAddressState;
	}

	public String getClinicAddressStreet() {
		return clinicAddressStreet;
	}

	public void setClinicAddressStreet(String clinicAddressStreet) {
		this.clinicAddressStreet = clinicAddressStreet;
	}

	public String getClinicAddressZip() {
		return clinicAddressZip;
	}

	public void setClinicAddressZip(String clinicAddressZip) {
		this.clinicAddressZip = clinicAddressZip;
	}

	public String getClinicContactEmail() {
		return clinicContactEmail;
	}

	public void setClinicContactEmail(String clinicContactEmail) {
		this.clinicContactEmail = clinicContactEmail;
	}

	public String getClinicContactName() {
		return clinicContactName;
	}

	public void setClinicContactName(String clinicContactName) {
		this.clinicContactName = clinicContactName;
	}

	
	public String getEinNumber() {
		return einNumber;
	}

	public void setEinNumber(String einNumber) {
		this.einNumber = einNumber;
	}

	public String getClinicFaxNo() {
		return clinicFaxNo;
	}

	public void setClinicFaxNo(String clinicFaxNo) {
		this.clinicFaxNo = clinicFaxNo;
	}

	public String getClinicLocName() {
		return clinicLocName;
	}

	public void setClinicLocName(String clinicLocName) {
		this.clinicLocName = clinicLocName;
	}

	public String getClinicPrimaryNo() {
		return clinicPrimaryNo;
	}

	public void setClinicPrimaryNo(String clinicPrimaryNo) {
		this.clinicPrimaryNo = clinicPrimaryNo;
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

	@Override
	public String toString() {
		return "PatientRecord [patientId=" + patientId + ", activeFlag=" + activeFlag + ", additionalInfo="
				+ additionalInfo + ", dob=" + dob + ", emrId=" + emrId + ", firstName=" + firstName + ", gender="
				+ gender + ", lastName=" + lastName + ", middleName=" + middleName + ", patientApartmentNo="
				+ patientApartmentNo + ", patientCity=" + patientCity + ", patientImage="
				+ Arrays.toString(patientImage) + ", patientState=" + patientState + ", patientStreetAddress="
				+ patientStreetAddress + ", primaryEmail=" + primaryEmail + ", secondaryEmail=" + secondaryEmail
				+ ", primaryNo=" + primaryNo + ", secondaryNo=" + secondaryNo + ", zipCode=" + zipCode
				+ ", primaryLocation=" + primaryLocation + ", organizationId=" + organizationId + ", primaryProvider="
				+ primaryProvider + ", providerFirstName=" + providerFirstName + ", providerMiddleName="
				+ providerMiddleName + ", providerLastName=" + providerLastName + ", providerFlag=" + providerFlag
				+ ", providerType=" + providerType + ", designation=" + designation + ", mobileNo=" + mobileNo
				+ ", businessPhoneNo=" + businessPhoneNo + ", email=" + email + ", npiNumber=" + npiNumber
				+ ", clinicCity=" + clinicCity + ", clinicAddressDoorNo=" + clinicAddressDoorNo
				+ ", clinicAddressState=" + clinicAddressState + ", clinicAddressStreet=" + clinicAddressStreet
				+ ", clinicAddressZip=" + clinicAddressZip + ", clinicContactEmail=" + clinicContactEmail
				+ ", clinicContactName=" + clinicContactName + ", einNumber=" + einNumber + ", clinicFaxNo="
				+ clinicFaxNo + ", clinicLocName=" + clinicLocName + ", clinicPrimaryNo=" + clinicPrimaryNo
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + ", mrn=" + mrn + "]";
	}

	
	
	
	
}






package com.cpa.ehr.backend.dao.patients.entities;

import java.util.Arrays;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import com.cpa.ehr.backend.dao.admin.entities.ClinicLocation;
import com.cpa.ehr.backend.dao.admin.entities.Organization;
import com.cpa.ehr.backend.dao.admin.entities.StaffMember;

import com.cpa.ehr.converters.StringCryptoConverter;




/**
 * Entity Class representing Patient_details Table. This table stores details of
 * patients
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */

@Entity
@Table(name = "patient_details")
public class PatientDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "patient_details_id_seq", initialValue=1, allocationSize = 1)
	@Column(name = "patient_id")
	private Long patientId;
	
	@Lob
	@Column(name = "patient_image")
	private byte[] patientImage;
	
	@Column(name = "first_name", nullable=false, length=100)
	@Convert(converter = StringCryptoConverter.class)
	private String firstName;
	
	@Column(name = "middle_name", length=100)
	@Convert(converter = StringCryptoConverter.class)
	private String middleName;

	@Column(name = "last_name", nullable=false, length=100)
	@Convert(converter = StringCryptoConverter.class)
	private String lastName;
	
	@Column(name = "mrn", length=100)
	private String mrn;
	
	@Column(name = "gender", nullable=false)
	private String gender;
	
	@Column(name = "title", nullable=false,length=10)
	private String title;
	
	@Column(name = "dob", nullable=false)
	private Date dob;
	
	@Column(name = "active_flag", length=1)
	private String activeFlag;
	
	@Column(name = "primary_email",  length=500)
	@Convert(converter = StringCryptoConverter.class)
	private String primaryEmail;
	
	@Column(name = "secondary_email", length=500)
	@Convert(converter = StringCryptoConverter.class)
	private String secondaryEmail;
	
	@Column(name = "primary_no")
	@Convert(converter = StringCryptoConverter.class)
	private String primaryNo;
	
	@Column(name = "secondary_no")
	@Convert(converter = StringCryptoConverter.class)
	private String secondaryNo;
	
	@Column(name = "patient_street_address", length=500)
	@Convert(converter = StringCryptoConverter.class)
	private String patientStreetAddress;
	
	@Column(name = "patient_apartment_no")
	@Convert(converter = StringCryptoConverter.class)
	private String patientApartmentNo;
	
	@Column(name = "patient_city")
	@Convert(converter = StringCryptoConverter.class)
	private String patientCity;
	
	@Column(name = "patient_state")
	@Convert(converter = StringCryptoConverter.class)
	private String patientState;
	
	@Column(name = "zip_code")
	@Convert(converter = StringCryptoConverter.class)
	private String zipCode;

	@ManyToOne
	@JoinColumn(name = "staff_id", nullable = false, foreignKey = @ForeignKey(name = "pt_staff_id_fkey"))
	private StaffMember staffMember;
	
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false, foreignKey = @ForeignKey(name = "pt_organization_id_fkey"))
    private Organization organization; 
	
	@ManyToOne
	@JoinColumn(name = "location_id", nullable = false, foreignKey = @ForeignKey(name = "pt_location_id_fkey"))
	private ClinicLocation clinicLocation;
	
	@Column(name = "emr_id")
	private String emrId;
	
	@Column(name = "additional_info")
	@Convert(converter = StringCryptoConverter.class)
	private String additionalInfo;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;
	
	@Column(name="p_ins_name")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsName;
	
	@Column(name="p_ins_relationship")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsRelationship;
	
	@Column(name="s_ins_relationship")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsRelationship;
	
	@Column(name="s_ins_name")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsName;
	
	@Column(name="p_ins_company")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsCompany;
	
	@Column(name="s_ins_company")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsCompany;
	
	@Column(name="p_ins_plan_name")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsPlanName;
	
	@Column(name="s_ins_plan_name")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsPlanName;
	
	@Column(name="p_ins_id")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsId;
	
	@Column(name="s_ins_id")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsId;
	
	@Column(name="p_ins_group")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsGroup;
	
	@Column(name="s_ins_group")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsGroup;
	
	@Column(name="p_ins_dob")
	///@Convert(converter = LocalDateEncryptDecryptConverter.class)
	//@Convert(converter = StringCryptoConverter.class)
	private Date pInsDob;
	
	@Column(name="s_ins_dob")
	//@Convert(converter = LocalDateEncryptDecryptConverter.class)
//	@Convert(converter = StringCryptoConverter.class)
	private Date sInsDob;
	
	@Column(name="p_ins_ssn")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsSsn;
	
	@Column(name="s_ins_ssn")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsSsn;
	
	@Column(name="p_ins_employer")
	@Convert(converter = StringCryptoConverter.class)
	private String pInsEmployer;
	
	@Column(name="s_ins_employer")
	@Convert(converter = StringCryptoConverter.class)
	private String sInsEmployer;
	
	@Column(name="license_no")
	@Convert(converter = StringCryptoConverter.class)
	private String licenseNo;
	
	@Column(name="ssn")
	@Convert(converter = StringCryptoConverter.class)
	private String ssn;
	
	@Column(name="age")
	private String age;
	
	@Column(name="building_no")
	@Convert(converter = StringCryptoConverter.class)
	private String buildingNo;

	@Column(name = "race",length=200)
	private String race;
	
	@Column(name = "ethnicity",length=200)
	private String ethnicity;
	
	@Column(name = "patient_language", length=200)
	private String patientLanguage;
	

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	public String getPatientLanguage() {
		return patientLanguage;
	}

	public void setPatientLanguage(String patientLanguage) {
		this.patientLanguage = patientLanguage;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public byte[] getPatientImage() {
		return patientImage;
	}

	public void setPatientImage(byte[] patientImage) {
		this.patientImage = patientImage;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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

	public String getPatientStreetAddress() {
		return patientStreetAddress;
	}

	public void setPatientStreetAddress(String patientStreetAddress) {
		this.patientStreetAddress = patientStreetAddress;
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

	public String getPatientState() {
		return patientState;
	}

	public void setPatientState(String patientState) {
		this.patientState = patientState;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public StaffMember getStaffMember() {
		return staffMember;
	}

	public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public ClinicLocation getClinicLocation() {
		return clinicLocation;
	}

	public void setClinicLocation(ClinicLocation clinicLocation) {
		this.clinicLocation = clinicLocation;
	}

	public String getEmrId() {
		return emrId;
	}
	
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public void pInsIdpInsId(String emrId) {
		this.emrId = emrId;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
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

	public String getpInsName() {
		return pInsName;
	}

	public void setpInsName(String pInsName) {
		this.pInsName = pInsName;
	}

	public String getpInsRelationship() {
		return pInsRelationship;
	}

	public void setpInsRelationship(String pInsRelationship) {
		this.pInsRelationship = pInsRelationship;
	}

	public String getsInsRelationship() {
		return sInsRelationship;
	}

	public void setsInsRelationship(String sInsRelationship) {
		this.sInsRelationship = sInsRelationship;
	}

	public String getsInsName() {
		return sInsName;
	}

	public void setsInsName(String sInsName) {
		this.sInsName = sInsName;
	}

	public String getpInsCompany() {
		return pInsCompany;
	}

	public void setpInsCompany(String pInsCompany) {
		this.pInsCompany = pInsCompany;
	}

	public String getsInsCompany() {
		return sInsCompany;
	}

	public void setsInsCompany(String sInsCompany) {
		this.sInsCompany = sInsCompany;
	}

	public String getpInsPlanName() {
		return pInsPlanName;
	}

	public void setpInsPlanName(String pInsPlanName) {
		this.pInsPlanName = pInsPlanName;
	}

	public String getsInsPlanName() {
		return sInsPlanName;
	}

	public void setsInsPlanName(String sInsPlanName) {
		this.sInsPlanName = sInsPlanName;
	}

	public String getpInsId() {
		return pInsId;
	}

	public void setpInsId(String pInsId) {
		this.pInsId = pInsId;
	}

	public String getsInsId() {
		return sInsId;
	}

	public void setsInsId(String sInsId) {
		this.sInsId = sInsId;
	}

	public String getpInsGroup() {
		return pInsGroup;
	}

	public void setpInsGroup(String pInsGroup) {
		this.pInsGroup = pInsGroup;
	}

	public String getsInsGroup() {
		return sInsGroup;
	}

	public void setsInsGroup(String sInsGroup) {
		this.sInsGroup = sInsGroup;
	}

	public Date getpInsDob() {
		return pInsDob;
	}

	public void setpInsDob(Date pInsDob) {
		this.pInsDob = pInsDob;
	}

	public Date getsInsDob() {
		return sInsDob;
	}

	public void setsInsDob(Date sInsDob) {
		this.sInsDob = sInsDob;
	}

	public String getpInsSsn() {
		return pInsSsn;
	}

	public void setpInsSsn(String pInsSsn) {
		this.pInsSsn = pInsSsn;
	}

	public String getsInsSsn() {
		return sInsSsn;
	}

	public void setsInsSsn(String sInsSsn) {
		this.sInsSsn = sInsSsn;
	}

	public String getpInsEmployer() {
		return pInsEmployer;
	}

	public void setpInsEmployer(String pInsEmployer) {
		this.pInsEmployer = pInsEmployer;
	}

	public String getsInsEmployer() {
		return sInsEmployer;
	}

	public void setsInsEmployer(String sInsEmployer) {
		this.sInsEmployer = sInsEmployer;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getMrn() {
		return mrn;
	}

	public void setMrn(String mrn) {
		this.mrn = mrn;
	}

	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", patientImage=" + Arrays.toString(patientImage)
				+ ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", mrn=" + mrn
				+ ", gender=" + gender + ", title=" + title + ", dob=" + dob + ", activeFlag=" + activeFlag
				+ ", primaryEmail=" + primaryEmail + ", secondaryEmail=" + secondaryEmail + ", primaryNo=" + primaryNo
				+ ", secondaryNo=" + secondaryNo + ", patientStreetAddress=" + patientStreetAddress
				+ ", patientApartmentNo=" + patientApartmentNo + ", patientCity=" + patientCity + ", patientState="
				+ patientState + ", zipCode=" + zipCode + ", staffMember=" + staffMember + ", organization="
				+ organization + ", clinicLocation=" + clinicLocation + ", emrId=" + emrId + ", additionalInfo="
				+ additionalInfo + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + ", pInsName=" + pInsName
				+ ", pInsRelationship=" + pInsRelationship + ", sInsRelationship=" + sInsRelationship + ", sInsName="
				+ sInsName + ", pInsCompany=" + pInsCompany + ", sInsCompany=" + sInsCompany + ", pInsPlanName="
				+ pInsPlanName + ", sInsPlanName=" + sInsPlanName + ", pInsId=" + pInsId + ", sInsId=" + sInsId
				+ ", pInsGroup=" + pInsGroup + ", sInsGroup=" + sInsGroup + ", pInsDob=" + pInsDob + ", sInsDob="
				+ sInsDob + ", pInsSsn=" + pInsSsn + ", sInsSsn=" + sInsSsn + ", pInsEmployer=" + pInsEmployer
				+ ", sInsEmployer=" + sInsEmployer + ", licenseNo=" + licenseNo + ", ssn=" + ssn + ", age=" + age
				+ ", buildingNo=" + buildingNo + ", race=" + race + ", ethnicity=" + ethnicity + ", patientLanguage="
				+ patientLanguage + "]";
	}




	

	
}





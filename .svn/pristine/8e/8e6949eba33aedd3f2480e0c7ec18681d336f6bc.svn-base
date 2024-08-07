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
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Entity Class representing Clinic Location Table. This table stores 
 * location of the different clinics.
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Entity
@Table(name="clinic_loc")
public class ClinicLocation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "clinic_location_id_seq", allocationSize=1)
	@Column(name="location_id")
	private Long locationId;
	
	@NotBlank
	@Size(max = 500)
	@Column(name = "loc_name", length = 500, nullable = false)
	private String locationName;
	
	@NotBlank
	@Size(max = 500)
	@Column(name = "address_street", length = 500, nullable = false)
	private String addressStreet;
	
	@Size(max = 500)
	@Column(name = "address_door_no", length = 500)
	private String addressDoorNo;
	
	@Size(max = 500)
	@Column(name = "address_city", length = 500)
	private String addressCity;
	
	@Size(max = 500)
	@Column(name = "address_state", length = 500)
	private String addressState;
	
	@NotBlank
	@Size(max = 500)
	@Column(name = "address_zip", length = 500, nullable = false)
	private String addressZip;
	
	@Size(max = 500)
	@Column(name = "contact_name", length = 500)
	private String contactName;
	
	@Size(max = 500)
	@Column(name = "contact_email", length = 500)
	private String contactEmail;
	
	@NotBlank
	@Size(max = 500)
	@Column(name = "primary_no", length = 500, nullable = false)
	private String primaryNo;
	
	@NotBlank
	@Size(max = 500)
	@Column(name = "fax_no", length = 500, nullable = false)
	private String faxNo;
	

	@Size(max = 100)
	@Column(name = "ein_number", length = 100)
	private String einNumber;
	
	@Size(max = 1)
	@Column(name = "active_flag", length = 1, nullable = false)
	private String activeFlag;
	
	@ManyToOne
	@JoinColumn(name = "organization_id", nullable = false)
	private Organization organization;
	
	@Column(name = "building_no",length = 100)
	private String buildingNo;
	
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

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressDoorNo() {
		return addressDoorNo;
	}

	public void setAddressDoorNo(String addressDoorNo) {
		this.addressDoorNo = addressDoorNo;
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

	public String getContactName() {
		return contactName;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getPrimaryNo() {
		return primaryNo;
	}

	public void setPrimaryNo(String primaryNo) {
		this.primaryNo = primaryNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getEinNumber() {
		return einNumber;
	}

	public void setEinNumber(String einNumber) {
		this.einNumber = einNumber;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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
		return "ClinicLocation [locationId=" + locationId + ", locationName=" + locationName + ", addressStreet="
				+ addressStreet + ", addressDoorNo=" + addressDoorNo + ", addressCity=" + addressCity
				+ ", addressState=" + addressState + ", addressZip=" + addressZip + ", contactName=" + contactName
				+ ", contactEmail=" + contactEmail + ", primaryNo=" + primaryNo + ", faxNo=" + faxNo + ", einNumber="
				+ einNumber + ", activeFlag=" + activeFlag + ", organization=" + organization + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + "]";
	}

	

}

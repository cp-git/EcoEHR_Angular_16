package com.cpa.ehr.backend.dao.admin.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *   
 * Entity Class representing Organization Table. This table stores 
 * the organization information.
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Entity
@Table(name="organization")
public class Organization implements Serializable {

	private static final long serialVersionUID = 3L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName="organization_id_seq", allocationSize=1)
	@Column(name="organization_id")
	private Long organizationId;
	
	@Size(max = 100)
	@Column(name = "organization_name", length = 100, nullable = false)
	private String organizationName;
	
	@Size(max = 100)
	@Column(name = "organization_contact_name", length = 100)
	private String organizationContactName;
	
	@Size(max = 100)
	@Column(name = "organization_contact_email", length = 100)
	private String organizationContactEmail;

	@Size(max = 100)
	@Column(name = "organization_contact_phone", length = 100)
	private String organizationContactPhone;
	
	@Size(max = 100)
	@Column(name = "organization_contact_fax", length = 100)
	private String organizationContactFax;

	@Size(max = 100)
	@Column(name = "organization_contact_web", length = 100)
	private String organizationContactWeb;

	@Size(max = 100)
	@Column(name = "organization_logo", length = 100)
	private String organizationLogo;
	
	@Size(max = 200)
	@Column(name = "organization_tax_id", length = 200)
	private String organizationTaxId;
	
	@Size(max = 100)
	@Column(name = "address_door_no", length = 100)
	private String addressDoorNo;
	
	@Size(max = 100)
	@Column(name = "address_street_1", length = 100)
	private String addressStreet1;
	
	@Size(max = 100)
	@Column(name = "address_street_2", length = 100)
	private String addressStreet2;
	
	@Size(max = 100)
	@Column(name = "address_city", length = 100)
	private String addressCity;
	
	@Size(max = 100)
	@Column(name = "address_state", length = 100)
	private String addressState;
	
	@Size(max = 100)
	@Column(name = "address_zip", length = 100)
	private String addressZip;
	
	@Size(max = 1)
	@Column(name = "active_flag", length = 1)
	private String activeFlag;
	
	@Size(max = 100)
	@Column(name = "npi_number", length = 100)
	private String npiNumber;
	
	@Size(max = 100)
	@Column(name = "ein_number", length = 100)
	private String einNumber;
	
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

	/**
	 * @return organizationId the organizationId to return
	 */
	public Long getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId the organization_id to set
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the organizationContactName
	 */
	public String getOrganizationContactName() {
		return organizationContactName;
	}

	/**
	 * @param organizationContactName the organizationContactName to set
	 */
	public void setOrganizationContactName(String organizationContactName) {
		this.organizationContactName = organizationContactName;
	}

	/**
	 * @return the organizationContactEmail
	 */
	public String getOrganizationContactEmail() {
		return organizationContactEmail;
	}

	/**
	 * @param organizationContactEmail the organizationContactEmail to set
	 */
	public void setOrganizationContactEmail(String organizationContactEmail) {
		this.organizationContactEmail = organizationContactEmail;
	}

	/**
	 * @return the organizationContactPhone
	 */
	public String getOrganizationContactPhone() {
		return organizationContactPhone;
	}

	/**
	 * @param organizationContactPhone the organizationContactPhone to set
	 */
	public void setOrganizationContactPhone(String organizationContactPhone) {
		this.organizationContactPhone = organizationContactPhone;
	}

	/**
	 * @return the organizationContactFax
	 */
	public String getOrganizationContactFax() {
		return organizationContactFax;
	}

	/**
	 * @param organizationContactFax the organizationContactFax to set
	 */
	public void setOrganizationContactFax(String organizationContactFax) {
		this.organizationContactFax = organizationContactFax;
	}

	/**
	 * @return the organizationContactWeb
	 */
	public String getOrganizationContactWeb() {
		return organizationContactWeb;
	}

	/**
	 * @param organizationContactWeb the organizationContactWeb to set
	 */
	public void setOrganizationContactWeb(String organizationContactWeb) {
		this.organizationContactWeb = organizationContactWeb;
	}

	/**
	 * @return the organizationLogo
	 */
	public String getOrganizationLogo() {
		return organizationLogo;
	}

	/**
	 * @param organizationLogo the organizationLogo to set
	 */
	public void setOrganizationLogo(String organizationLogo) {
		this.organizationLogo = organizationLogo;
	}

	/**
	 * @return the organizationTaxId
	 */
	public String getOrganizationTaxId() {
		return organizationTaxId;
	}

	/**
	 * @param organizationTaxId the organizationTaxId to set
	 */
	public void setOrganizationTaxId(String organizationTaxId) {
		this.organizationTaxId = organizationTaxId;
	}

	/**
	 * @return the addressDoorNo
	 */
	public String getAddressDoorNo() {
		return addressDoorNo;
	}

	/**
	 * @param addressDoorNo the addressDoorNo to set
	 */
	public void setAddressDoorNo(String addressDoorNo) {
		this.addressDoorNo = addressDoorNo;
	}

	/**
	 * @return the addressStreet1
	 */
	public String getAddressStreet1() {
		return addressStreet1;
	}

	/**
	 * @param addressStreet1 the addressStreet1 to set
	 */
	public void setAddressStreet1(String addressStreet1) {
		this.addressStreet1 = addressStreet1;
	}

	/**
	 * @return the addressStreet2
	 */
	public String getAddressStreet2() {
		return addressStreet2;
	}

	/**
	 * @param addressStreet2 the addressStreet2 to set
	 */
	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}

	/**
	 * @return the addressCity
	 */
	public String getAddressCity() {
		return addressCity;
	}

	/**
	 * @param addressCity the addressCity to set
	 */
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	/**
	 * @return the addressState
	 */
	public String getAddressState() {
		return addressState;
	}

	/**
	 * @param addressState the addressState to set
	 */
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	/**
	 * @return the addressZip
	 */
	public String getAddressZip() {
		return addressZip;
	}

	/**
	 * @param addressZip the addressZip to set
	 */
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	/**
	 * @return the activeFlag
	 */
	public String getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
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

	public String getNpiNumber() {
		return npiNumber;
	}

	public void setNpiNumber(String npiNumber) {
		this.npiNumber = npiNumber;
	}

	public String getEinNumber() {
		return einNumber;
	}

	public void setEinNumber(String einNumber) {
		this.einNumber = einNumber;
	}

	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", organizationContactName=" + organizationContactName + ", organizationContactEmail="
				+ organizationContactEmail + ", organizationContactPhone=" + organizationContactPhone
				+ ", organizationContactFax=" + organizationContactFax + ", organizationContactWeb="
				+ organizationContactWeb + ", organizationLogo=" + organizationLogo + ", organizationTaxId="
				+ organizationTaxId + ", addressDoorNo=" + addressDoorNo + ", addressStreet1=" + addressStreet1
				+ ", addressStreet2=" + addressStreet2 + ", addressCity=" + addressCity + ", addressState="
				+ addressState + ", addressZip=" + addressZip + ", activeFlag=" + activeFlag + ", npiNumber="
				+ npiNumber + ", einNumber=" + einNumber + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

	


	
}

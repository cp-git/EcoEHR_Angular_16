package com.cpa.ehr.backend.dao.admin.entities;

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
 * Entity Class representing Role Table. This table stores 
 * standard roles that can be applied for CCM users.
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Entity
@Table(name="role")
public class Role 
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "role_id_seq", allocationSize=1)
	@Column(name="role_id")
	private Long roleId; 
	
	@Size(max = 255)
	@Column(name="authority", length = 255, nullable = false)
	private String authority;
	
	@Size(max = 255)
	@Column(name="description", length = 255, nullable = false)
	private String description;
	
	@Size(max = 255)
	@Column(name="display_name", length = 255, nullable = false)
	private String displayName;
	
	@Column(name="security_level", nullable = false)
	private Long securityLevel; 
	
	@Size(max = 1)
	@Column(name="active_flag", length = 1, nullable = false)
	private String activeFlag;

	@Column(name = "created_date", nullable = false)
	private Date createdDate;
	
	@Size(max = 100)
	@Column(name = "created_by", length = 100)
	private String createdBy;
	
	@Column(name = "modified_date", nullable = false)
	private Date modifiedDate;
	
	@Size(max = 100)
	@Column(name = "modified_by", length = 100)
	private String modifiedBy;

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority the authority to set
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the securityLevel
	 */
	public Long getSecurityLevel() {
		return securityLevel;
	}

	/**
	 * @param securityLevel the securityLevel to set
	 */
	public void setSecurityLevel(Long securityLevel) {
		this.securityLevel = securityLevel;
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

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", authority=" + authority
				+ ", description=" + description + ", displayName="
				+ displayName + ", securityLevel=" + securityLevel
				+ ", activeFlag=" + activeFlag + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", modifiedDate=" + modifiedDate
				+ ", modifiedBy=" + modifiedBy + "]";
	}

}

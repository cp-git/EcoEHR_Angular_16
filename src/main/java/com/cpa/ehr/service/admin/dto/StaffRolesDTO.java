package com.cpa.ehr.service.admin.dto;

import java.util.Date;
import javax.validation.constraints.Size;

/**
 * DTO representing Staff Role Entity.
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
public class StaffRolesDTO 
{

	private Long staffRoleId; 
	
	private Long staffId;
	
	@Size(max = 255)
	private String authority;
	
	private Boolean activeFlag;

	private Date createdDate;
	
	@Size(max = 100)
	private String createdBy;
	
	private Date lastUpdatedDate;
	
	@Size(max = 100)
	private String lastUpdatedBy;

	/**
	 * @return the staffRoleId
	 */
	public Long getStaffRoleId() {
		return staffRoleId;
	}

	/**
	 * @param staffRoleId the staffRoleId to set
	 */
	public void setStaffRoleId(Long staffRoleId) {
		this.staffRoleId = staffRoleId;
	}

	/**
	 * @return the staffId
	 */
	public Long getStaffId() {
		return staffId;
	}

	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
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
	 * @return the activeFlag
	 */
	public Boolean getActiveFlag() {
		return activeFlag;
	}

	/**
	 * @param activeFlag the activeFlag to set
	 */
	public void setActiveFlag(Boolean activeFlag) {
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
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StaffRolesDTO [staffRoleId=" + staffRoleId + ", staffId="
				+ staffId + ", authority=" + authority + ", activeFlag="
				+ activeFlag + ", createdDate=" + createdDate + ", createdBy="
				+ createdBy + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}

}


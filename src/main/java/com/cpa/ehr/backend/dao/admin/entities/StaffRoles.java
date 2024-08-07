package com.cpa.ehr.backend.dao.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Entity Class representing Staff Role Table. This table stores 
 * roles that can be applied for EHR Staff Members.
 * 
 * @author CPA Development Team
 * @version 1.0.0
 */
@Entity
@Table(name="staff_roles")
public class StaffRoles 
{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "staff_role_id_seq", allocationSize=1)
	@Column(name="staff_role_id")
	private Long staffRoleId; 
	
	@OneToOne
	@JoinColumn(name = "staff_id", nullable = false)
	private StaffMember staff;
	
	@Size(max = 255)
	@Column(name="authority", length = 255, nullable = false)
	private String authority;
	
	@Size(max = 1)
	@Column(name="active_flag", length = 1, nullable = false)
	private String activeFlag;

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
	 * @return the staff
	 */
	public StaffMember getStaff() {
		return staff;
	}

	/**
	 * @param staff the staff to set
	 */
	public void setStaff(StaffMember staff) {
		this.staff = staff;
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
		return "StaffRoles [staffRoleId=" + staffRoleId + ", staff=" + staff
				+ ", authority=" + authority + ", activeFlag=" + activeFlag
				+ ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", lastUpdatedDate=" + lastUpdatedDate + ", lastUpdatedBy="
				+ lastUpdatedBy + "]";
	}

}

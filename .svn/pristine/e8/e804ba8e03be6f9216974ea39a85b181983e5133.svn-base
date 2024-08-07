package com.cpa.ehr.backend.dao.system.entities;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name="icd10_group_tbl")
public class ICD10Group {
	
	@Id
	@Column(name="group_id", nullable = false)
	private Long groupId;
	
	@Column(name="group_range", length = 20)
	private String groupRange;
	
	@Column(name="group_description", length = 200)
	private String groupDescription;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_by", length = 100)
	private String createdBy;
	
	@Column(name="last_updated_date")
	private Date lastUpdatedDate;
	
	@Column(name="last_updated_by", length = 100)
	private String lastUpdatedBy;
	
	@Transient
	private Long count;

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getGroupRange() {
		return groupRange;
	}

	public void setGroupRange(String groupRange) {
		this.groupRange = groupRange;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
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
		return "ICD10Group [groupId=" + groupId + ", groupRange=" + groupRange + ", groupDescription="
				+ groupDescription + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", lastUpdatedDate="
				+ lastUpdatedDate + ", lastUpdatedBy=" + lastUpdatedBy + "]";
	}


	
	
	
}

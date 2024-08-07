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
@Table(name="staff_Payment_details")
public class StaffPaymentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "staff_role_id_seq", allocationSize=1)
	@Column(name="staff_payment_id")
	private Long staffPaymentId;
	
	@OneToOne
	@JoinColumn(name = "staff_id", nullable = false)
	private StaffMember staff;
	
	@Size(max=255)
	@Column(name="payment_status" ,length = 255, nullable = false)
	private String paymentStatus;
	
	@Column(name = "ehr_license_start_date")
	private Date licenseStartDate;
	
	@Column(name = "ehr_license_end_date")
	private Date licenseEndDate;
	

	public Long getStaffPaymentId() {
		return staffPaymentId;
	}

	public void setStaffPaymentId(Long staffPaymentId) {
		this.staffPaymentId = staffPaymentId;
	}

	public StaffMember getStaff() {
		return staff;
	}

	public void setStaff(StaffMember staff) {
		this.staff = staff;
	}

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

	@Override
	public String toString() {
		return "StaffPaymentDetails [staffPaymentId=" + staffPaymentId + ", staff=" + staff + ", paymentStatus="
				+ paymentStatus + ", licenseStartDate=" + licenseStartDate + ", licenseEndDate=" + licenseEndDate + "]";
	}
}

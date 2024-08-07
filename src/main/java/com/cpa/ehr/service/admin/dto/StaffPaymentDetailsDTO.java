package com.cpa.ehr.service.admin.dto;

import java.util.Date;

public class StaffPaymentDetailsDTO {
	
	private Long staffPaymentId;
	
	private String staffId;
	
	private String paymentStatus;
	
	private Date licenseStartDate;
	
	private Date licenseEndDate;

	public Long getStaffPaymentId() {
		return staffPaymentId;
	}

	public void setStaffPaymentId(Long staffPaymentId) {
		this.staffPaymentId = staffPaymentId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
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
		return "StaffPaymentDetailsDTO [staffPaymentId=" + staffPaymentId + ", staffId=" + staffId + ", paymentStatus="
				+ paymentStatus + ", licenseStartDate=" + licenseStartDate + ", licenseEndDate=" + licenseEndDate + "]";
	}
	
}

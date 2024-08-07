package com.cpa.ehr.service.system.dto;

public class RequestForDemoDTO {

	private String fname;
	private String lname;
	private String email;
	private String mobileNo;
	private String userFor;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getUserFor() {
		return userFor;
	}

	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}

	@Override
	public String toString() {
		return "RequestForDemoDTO [fname=" + fname + ", lname=" + lname + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", userFor=" + userFor + "]";
	}

}

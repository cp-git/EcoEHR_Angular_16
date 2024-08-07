package com.cpa.ehr.service.patients.dto;

import java.util.Arrays;
import java.util.Date;

import org.springframework.http.HttpHeaders;

public class FileDataDTO {
	
	private Long patientId;
	
	private Date selectedDate;
	
	private String modType;
	
	private String fileUrl;
	
	private byte[] file;
	
	private HttpHeaders headers;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}

	public String getModType() {
		return modType;
	}

	public void setModType(String modType) {
		this.modType = modType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}

	@Override
	public String toString() {
		return "FileDataDTO [patientId=" + patientId + ", selectedDate=" + selectedDate + ", modType=" + modType
				+ ", fileUrl=" + fileUrl + ", file=" + Arrays.toString(file) + ", headers=" + headers + "]";
	}
}

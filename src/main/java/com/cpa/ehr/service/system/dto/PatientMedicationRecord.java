package com.cpa.ehr.service.system.dto;

import com.cpa.ehr.service.patients.dto.PatientDetailsDTO;

public class PatientMedicationRecord {

	private PatientMedicationDTO patientMedication;
	
	private PatientDetailsDTO patientDetails;
	
	private MedicationDTO medication;

	public PatientMedicationDTO getPatientMedication() {
		return patientMedication;
	}

	public void setPatientMedication(PatientMedicationDTO patientMedication) {
		this.patientMedication = patientMedication;
	}

	public PatientDetailsDTO getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetailsDTO patientDetails) {
		this.patientDetails = patientDetails;
	}

	public MedicationDTO getMedication() {
		return medication;
	}

	public void setMedication(MedicationDTO medication) {
		this.medication = medication;
	}

	@Override
	public String toString() {
		return "PatientMedicationRecord [patientMedication=" + patientMedication + ", patientDetails=" + patientDetails
				+ ", medication=" + medication + "]";
	}

	
	
	
}

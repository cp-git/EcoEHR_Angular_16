package com.cpa.ehr.backend.dao.system.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medication_tbl")
public class Medication {
	@Id
	@Column(name="medication_id", nullable = false)
	private Long medicationId;
	
	@Column(name="drugname")
	private String drugname;
	
	@Column(name="activeingredient")
	private String activeingredient;
	
	@Column(name="form", nullable = false)
	private String form;
	
	@Column(name="dose", nullable = false)
	private String dose;
	
	@Column(name="route", nullable = false)
	private String route;
	
	@Column(name="schedule", nullable = false)
	private String schedule;
	
	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public String getActiveingredient() {
		return activeingredient;
	}

	public void setActiveingredient(String activeingredient) {
		this.activeingredient = activeingredient;
	}

	public Long getMedicationId() {
		return medicationId;
	}

	public void setMedicationId(Long medicationId) {
		this.medicationId = medicationId;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Medication [medicationId=" + medicationId + ", drugname=" + drugname + ", activeingredient="
				+ activeingredient + ", form=" + form + ", dose=" + dose + ", route=" + route + ", schedule=" + schedule
				+ "]";
	}

}

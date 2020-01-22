package com.ibm.ro.openshift.healthsystem.model.appointment;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "Appointment ID", access = JsonProperty.Access.READ_ONLY)
	private Long appntmntId;
	private Long doctorId;
	private Long patientId;
	@CreationTimestamp
	private Date appntmntTime;

	public Long getAppntmntId() {
		return appntmntId;
	}

	public void setAppntmntId(Long appntmntId) {
		this.appntmntId = appntmntId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Date getAppntmntTime() {
		return appntmntTime;
	}

	public void setAppntmntTime(Date appntmntTime) {
		this.appntmntTime = appntmntTime;
	}
}

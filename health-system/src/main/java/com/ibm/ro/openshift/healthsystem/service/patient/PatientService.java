package com.ibm.ro.openshift.healthsystem.service.patient;

import com.ibm.ro.openshift.healthsystem.model.patient.Patient;

public interface PatientService {

	public Patient getPatient(Long pId);

	public Patient createPatient(Patient patient);
}

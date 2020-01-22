package com.ibm.ro.openshift.healthsystem.service.patient;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ro.openshift.healthsystem.model.patient.Patient;
import com.ibm.ro.openshift.healthsystem.repository.patient.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient getPatient(Long pId) {
		Optional<Patient> optional = patientRepository.findById(pId);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	
	public Patient createPatient(Patient patient) {
		Patient patient2 = patientRepository.save(patient);
		return patient2;
	}

}

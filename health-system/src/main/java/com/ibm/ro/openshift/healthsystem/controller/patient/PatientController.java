package com.ibm.ro.openshift.healthsystem.controller.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.openshift.healthsystem.model.patient.Patient;
import com.ibm.ro.openshift.healthsystem.service.patient.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	PatientService patientService;

	@GetMapping(value = "/{pId}")
	public Patient getPatient(@PathVariable("pId") Long pId) {
		return patientService.getPatient(pId);
	}

	@PostMapping
	public Patient createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}
}

package com.ibm.ro.openshift.healthsystem.controller.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.openshift.healthsystem.model.doctor.Doctor;
import com.ibm.ro.openshift.healthsystem.service.doctor.DoctorService;



@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@GetMapping(value = "/{doctorId}")
	public Doctor getDoctor(@PathVariable("doctorId") Long doctorId) {
		return doctorService.getDoctor(doctorId);
	}

	@PostMapping
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.createDoctor(doctor);
	}
}

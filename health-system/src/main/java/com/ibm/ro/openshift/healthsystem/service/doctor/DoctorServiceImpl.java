package com.ibm.ro.openshift.healthsystem.service.doctor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ro.openshift.healthsystem.model.doctor.Doctor;
import com.ibm.ro.openshift.healthsystem.repository.doctor.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Doctor getDoctor(Long doctorId) {
		Optional<Doctor> optional = doctorRepository.findById(doctorId);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Doctor createDoctor(Doctor doctor) {
		Doctor savedDoctor = doctorRepository.save(doctor);
		return savedDoctor;
	}

}

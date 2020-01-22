package com.ibm.ro.openshift.healthsystem.service.doctor;

import com.ibm.ro.openshift.healthsystem.model.doctor.Doctor;

public interface DoctorService {

	public Doctor getDoctor(Long doctorId);

	public Doctor createDoctor(Doctor doctor);
}

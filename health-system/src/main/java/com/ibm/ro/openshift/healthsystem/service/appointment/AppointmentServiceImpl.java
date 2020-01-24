package com.ibm.ro.openshift.healthsystem.service.appointment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.ro.openshift.healthsystem.model.appointment.Appointment;
import com.ibm.ro.openshift.healthsystem.repository.appointment.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointment getAppointment(Long appntmntId) {
		Optional<Appointment> optional = appointmentRepository.findById(appntmntId);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

}

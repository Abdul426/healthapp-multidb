package com.ibm.ro.openshift.healthsystem.service.appointment;

import com.ibm.ro.openshift.healthsystem.model.appointment.Appointment;

public interface AppointmentService {

	public Appointment getAppointment(Long appntmntId);

	public Appointment createAppointment(Appointment appointment);
}

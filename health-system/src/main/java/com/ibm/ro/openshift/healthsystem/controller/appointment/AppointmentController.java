package com.ibm.ro.openshift.healthsystem.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.openshift.healthsystem.model.appointment.Appointment;
import com.ibm.ro.openshift.healthsystem.service.appointment.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@GetMapping(value = "/{appId}")
	public Appointment getApp(@PathVariable("appId") Long appId) {
		return appointmentService.getAppointment(appId);
	}

	@PostMapping
	public Appointment createApp(@RequestBody Appointment appointment) {
		return appointmentService.createAppointment(appointment);
	}
}

package com.ibm.ro.openshift.healthsystem.repository.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ro.openshift.healthsystem.model.appointment.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}

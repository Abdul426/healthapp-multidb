package com.ibm.ro.openshift.healthsystem.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ro.openshift.healthsystem.model.patient.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}

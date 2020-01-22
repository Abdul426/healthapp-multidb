package com.ibm.ro.openshift.healthsystem.repository.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.ro.openshift.healthsystem.model.doctor.Doctor;

//@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}

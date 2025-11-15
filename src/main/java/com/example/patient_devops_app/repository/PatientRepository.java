package com.example.patient_devops_app.repository;

import com.example.patient_devops_app.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

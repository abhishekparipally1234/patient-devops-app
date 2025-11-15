package com.example.patient_devops_app.service;

import com.example.patient_devops_app.entity.Patient;
import com.example.patient_devops_app.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository repo;

    public List<Patient> getAllPatients() {
        return repo.findAll();
    }

    public Patient getPatient(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Patient addPatient(Patient p) {
        return repo.save(p);
    }

    public Patient updatePatient(Long id, Patient updated) {
        Patient existing = repo.findById(id).orElse(null);

        if (existing == null) return null;

        existing.setName(updated.getName());
        existing.setAge(updated.getAge());
        existing.setDisease(updated.getDisease());

        return repo.save(existing);
    }

    public void deletePatient(Long id) {
        repo.deleteById(id);
    }
}

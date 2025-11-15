package com.example.patient_devops_app.controller;

import com.example.patient_devops_app.entity.Patient;
import com.example.patient_devops_app.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService service;

    @GetMapping
    public List<Patient> getAll() {
        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient get(@PathVariable Long id) {
        return service.getPatient(id);
    }

    @PostMapping
    public Patient add(@RequestBody Patient p) {
        return service.addPatient(p);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient p) {
        return service.updatePatient(id, p);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deletePatient(id);
        return "Patient deleted";
    }
}

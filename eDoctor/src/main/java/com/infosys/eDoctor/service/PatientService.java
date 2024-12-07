package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Patient;
import com.infosys.eDoctor.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Add a new patient
    public Patient addPatient(Patient patient) {
        // Encrypt the password before saving
        patient.setPassword(passwordEncoder.encode(patient.getPassword()));
        return patientRepo.save(patient);
    }

    // Get patient by ID
    public Optional<Patient> getPatientById(int patientId) {
        return patientRepo.findById(patientId);
    }

    // Get patient by email
    public Optional<Patient> getPatientByEmail(String email) {
        return patientRepo.findByEmail(email);
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    // Update patient details
    public Patient updatePatient(Patient patient) {
        // Check if patient exists
        Patient existingPatient = patientRepo.findById(patient.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Update fields
        existingPatient.setPatientName(patient.getPatientName());
        existingPatient.setMobileNo(patient.getMobileNo());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setBloodGroup(patient.getBloodGroup());
        existingPatient.setGender(patient.getGender());
        existingPatient.setAge(patient.getAge());
        existingPatient.setAddress(patient.getAddress());

        return patientRepo.save(existingPatient);
    }

    // Delete patient
    public void deletePatient(int patientId) {
        patientRepo.deleteById(patientId);
    }

    // Patient login
    public boolean authenticatePatient(String email, String password) {
        Optional<Patient> patient = patientRepo.findByEmail(email);
        return patient.map(value -> passwordEncoder.matches(password, value.getPassword()))
                .orElse(false);
    }

    // Update request status
    public Patient updateRequestStatus(int patientId, String status) {
        if (!status.equalsIgnoreCase("Accepted") && !status.equalsIgnoreCase("Rejected")) {
            throw new IllegalArgumentException("Invalid status. Use 'Accepted' or 'Rejected'.");
        }

        // Fetch the patient
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Update the request status
        patient.setRequestStatus(status);
        return patientRepo.save(patient);
    }

}
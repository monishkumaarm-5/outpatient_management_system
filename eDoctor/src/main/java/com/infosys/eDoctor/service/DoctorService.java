package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Add new doctor
    public Doctor addDoctor(Doctor doctor) {
        // Encrypt password
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepo.save(doctor);
    }

    // Get doctor by ID
    public Optional<Doctor> getDoctorById(String doctorId) {
        return doctorRepo.findById(doctorId);
    }

    // Get doctor by email
    public Optional<Doctor> getDoctorByEmail(String email) {
        return doctorRepo.findByEmail(email);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    // Update doctor details
    public Doctor updateDoctor(Doctor doctor) {
        Doctor existingDoctor = doctorRepo.findById(doctor.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        existingDoctor.setDoctorName(doctor.getDoctorName());
        existingDoctor.setSpeciality(doctor.getSpeciality());
        existingDoctor.setLocation(doctor.getLocation());
        existingDoctor.setExperience(doctor.getExperience());
        existingDoctor.setMobileNo(doctor.getMobileNo());
        existingDoctor.setEmail(doctor.getEmail());

        return doctorRepo.save(existingDoctor);
    }

    // Delete doctor
    public void deleteDoctor(String doctorId) {
        doctorRepo.deleteById(doctorId);
    }

    // Authenticate doctor
    public boolean authenticateDoctor(String email, String password) {
        Optional<Doctor> doctor = doctorRepo.findByEmail(email);
        return doctor.map(value -> passwordEncoder.matches(password, value.getPassword())).orElse(false);
    }
}

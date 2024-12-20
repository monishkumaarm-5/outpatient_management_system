package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
=======
import org.springframework.stereotype.Service;

>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

<<<<<<< HEAD
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Add new doctor
    public Doctor addDoctor(Doctor doctor) {
        // Encrypt password
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        return doctorRepo.save(doctor);
    }

    // Get doctor by ID
=======
    public Doctor addDoctor(Doctor doctor) {
        System.out.println("Adding Doctor:");
        System.out.println("Name: " + doctor.getDoctorName());
        System.out.println("Speciality: " + doctor.getSpeciality());
        System.out.println("Location: " + doctor.getLocation());
        return doctorRepo.save(doctor);
    }

>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
    public Optional<Doctor> getDoctorById(String doctorId) {
        return doctorRepo.findById(doctorId);
    }

<<<<<<< HEAD
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
=======
    public Optional<Doctor> getDoctorByEmail(String email) {
        return doctorRepo.findByEmail(email);
    }
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
}

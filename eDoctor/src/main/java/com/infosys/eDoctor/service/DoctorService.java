package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor addDoctor(Doctor doctor) {
        System.out.println("Adding Doctor:");
        System.out.println("Name: " + doctor.getDoctorName());
        System.out.println("Speciality: " + doctor.getSpeciality());
        System.out.println("Location: " + doctor.getLocation());
        return doctorRepo.save(doctor);
    }

    public Optional<Doctor> getDoctorById(String doctorId) {
        return doctorRepo.findById(doctorId);
    }

    public Optional<Doctor> getDoctorByEmail(String email) {
        return doctorRepo.findByEmail(email);
    }
}

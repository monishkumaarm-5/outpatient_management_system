package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.AvailabilityDates;
import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.reposatory.AvailabilityDatesRepository;
import com.infosys.eDoctor.reposatory.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AvailabilityDatesRepository availabilityDatesRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorProfile(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public AvailabilityDates addAvailability(AvailabilityDates availabilityDates) {
        return availabilityDatesRepository.save(availabilityDates);
    }

    public AvailabilityDates updateAvailability(AvailabilityDates availabilityDates) {
        return availabilityDatesRepository.save(availabilityDates);
    }

    public Doctor getDoctor(Doctor doctor) {
        return doctorRepository.findById(doctor.getDoctorId()).orElse(null);
    }

    public void removeDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    public List<Doctor> getDoctorList() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getDoctorListBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }
}

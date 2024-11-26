package com.infosys.eDoctor.controller;

import com.infosys.eDoctor.entity.AvailabilityDates;
import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController
{
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor")
    @CrossOrigin(origins = "http://localhost:3000")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @PutMapping
    public Doctor updateDoctorProfile(@RequestBody Doctor doctor) {
        return doctorService.updateDoctorProfile(doctor);
    }

    @PostMapping("/availability")
    public AvailabilityDates addAvailability(@RequestBody AvailabilityDates availabilityDates) {
        return doctorService.addAvailability(availabilityDates);
    }

    @PutMapping("/availability")
    public AvailabilityDates updateAvailability(@RequestBody AvailabilityDates availabilityDates) {
        return doctorService.updateAvailability(availabilityDates);
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable int id) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(id);
        return doctorService.getDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public void removeDoctor(@PathVariable int id) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(id);
        doctorService.removeDoctor(doctor);
    }


    @GetMapping("/getDoctorList")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Doctor> getDoctorList() {
        return doctorService.getDoctorList();
    }

    @GetMapping("/speciality")
    public List<Doctor> getDoctorListBySpeciality(@RequestParam String speciality) {
        return doctorService.getDoctorListBySpeciality(speciality);
    }

}

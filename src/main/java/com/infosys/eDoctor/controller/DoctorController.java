package com.infosys.eDoctor.controller;

import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.service.DoctorService;
import com.infosys.eDoctor.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/addDoctor")
    @CrossOrigin(origins = "http://localhost:3000")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/getDoctor/{doctorId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Doctor> getDoctorById(@PathVariable String doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @GetMapping("/getDoctorByEmail")
    @CrossOrigin(origins = "http://localhost:3000")
    public Optional<Doctor> getDoctorByEmail(@RequestParam String email) {
        return doctorService.getDoctorByEmail(email);
    }

    //Patient Request
    @PutMapping("/handleRequest/{patientId}")
    public ResponseEntity<String> handleRequest(@PathVariable int patientId, @RequestParam String status) {
        if (!status.equalsIgnoreCase("Accepted") && !status.equalsIgnoreCase("Rejected")) {
            return ResponseEntity.badRequest().body("Invalid status");
        }
        patientService.updateRequestStatus(patientId, status);
        return ResponseEntity.ok("Request " + status);
    }
}


package com.infosys.eDoctor.service;

import com.infosys.eDoctor.entity.Appointment;
import com.infosys.eDoctor.entity.Doctor;
import com.infosys.eDoctor.entity.Patient;
import com.infosys.eDoctor.repository.AppointmentRepo;
import com.infosys.eDoctor.repository.AvailabilityRepo;
import com.infosys.eDoctor.repository.DoctorRepo;
import com.infosys.eDoctor.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepository;

    @Autowired
    private  DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AvailabilityRepo availabilityRepository;

    private static final int MAX_APPOINTMENTS_PER_DAY = 5;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment(int id) {

        return appointmentRepository.findById(id).orElse(null);
    }

    public Appointment addAppointment(Appointment appointment) {

        int currentAppointments = appointmentRepository.countAppointmentsByDoctorAndDate(appointment.getDoctorId(), appointment.getAppointmentDate());
        if (currentAppointments >= MAX_APPOINTMENTS_PER_DAY) {
            throw new IllegalStateException("Maximum number of appointments reached for this date.");
        }
        Appointment savedAppointment = appointmentRepository.save(appointment);
        Patient patient = patientRepo.findById(appointment.getPatientId()).orElse(null);
        Doctor doctor = doctorRepo.findById(appointment.getDoctorId()).orElse(null);

        if (patient != null && doctor != null) {
            // Email to patient
            String patientSubject = "Appointment Confirmation";
            String patientBody = "Dear " + patient.getPatientName() + ",\n\n" +
                    "Your appointment with Dr. " + doctor.getDoctorName() +
                    " on " + appointment.getAppointmentDate() + " has been confirmed.\n\nThank you!";
            sendEmail(patient.getEmail(), patientSubject, patientBody);

            // Email to doctor
            String doctorSubject = "New Appointment Scheduled";
            String doctorBody = "Dear Dr. " + doctor.getDoctorName() + ",\n\n" +
                    "A new appointment with patient " + patient.getPatientName() +
                    " has been scheduled on " + appointment.getAppointmentDate() + ".\n\nThank you!";
            sendEmail(doctor.getEmail(), doctorSubject, doctorBody);
        }

        return savedAppointment;
    }

    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(int id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getAppointmentsByDoctorId(String doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findByAppointmentDate(date);
    }

    public int getAvailabilityCountForDoctor(String doctorId, LocalDate date) {
        return MAX_APPOINTMENTS_PER_DAY - appointmentRepository.countAppointmentsByDoctorAndDate(doctorId, date);
    }

    //Main Email Sender Function
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}

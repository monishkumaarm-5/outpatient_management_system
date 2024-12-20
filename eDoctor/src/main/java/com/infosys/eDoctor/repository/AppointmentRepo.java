package com.infosys.eDoctor.repository;

import com.infosys.eDoctor.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

    List<Appointment> findByDoctorId(String doctorId);

    List<Appointment> findByAppointmentDate(LocalDate date);

    // Query to count appointments by doctor and date
    @Query("SELECT COUNT(a) FROM Appointment a WHERE a.doctorId = :doctorId AND a.appointmentDate = :date")
    int countAppointmentsByDoctorAndDate(String doctorId, LocalDate date);
}

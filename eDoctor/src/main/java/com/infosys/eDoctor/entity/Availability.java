package com.infosys.eDoctor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int availabilityId;

    @Column(nullable = false)
    private String doctorId;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

<<<<<<< HEAD
//    @Column(nullable = false)
//    private LocalTime fromTime;
//
//    @Column(nullable = false)
//    private LocalTime toTime;
=======
    @Column(nullable = false)
    private LocalTime fromTime;

    @Column(nullable = false)
    private LocalTime toTime;
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484

    public Availability() {
    }

    public Availability(String doctorId, LocalDate startDate, LocalDate endDate, LocalTime fromTime, LocalTime toTime) {
        this.doctorId = doctorId;
        this.startDate = startDate;
        this.endDate = endDate;
<<<<<<< HEAD
//        this.fromTime = fromTime;
//        this.toTime = toTime;
=======
        this.fromTime = fromTime;
        this.toTime = toTime;
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
    }

    // Getters and Setters
    public int getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(int availabilityId) {
        this.availabilityId = availabilityId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

<<<<<<< HEAD
//    public LocalTime getFromTime() {
//        return fromTime;
//    }
//
//    public void setFromTime(LocalTime fromTime) {
//        this.fromTime = fromTime;
//    }
//
//    public LocalTime getToTime() {
//        return toTime;
//    }
//
//    public void setToTime(LocalTime toTime) {
//        this.toTime = toTime;
//    }
=======
    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
}

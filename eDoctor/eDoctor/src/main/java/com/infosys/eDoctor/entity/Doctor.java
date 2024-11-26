package com.infosys.eDoctor.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int doctorId;
    private String doctorName;
    private String speciality;
    private String location;
    private String hospitalName;
    private String mobileNo;
    private String email;
    private String password;

    @OneToMany(mappedBy = "doctor")
    private List<AvailabilityDates> availabilityDates;

    // Getters and Setters

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AvailabilityDates> getAvailabilityDates() {
        return availabilityDates;
    }

    public void setAvailabilityDates(List<AvailabilityDates> availabilityDates) {
        this.availabilityDates = availabilityDates;
    }
}

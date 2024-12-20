package com.infosys.eDoctor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Doctor {

    @Id
    private String doctorId;
    private String doctorName;
    private String speciality;
    private String location;
    private String experience;
    private int mobileNo;
    private String email;

    @Lob
    private byte[] profilePhoto;

    public Doctor() {
    }

    public Doctor(String doctorId, String doctorName, String speciality, String location, String experience, int mobileNo, String email, byte[] profilePhoto) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.location = location;
        this.experience = experience;
        this.mobileNo = mobileNo;
        this.email = email;
        this.profilePhoto = profilePhoto;
    }

    // Getters and setters
    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}

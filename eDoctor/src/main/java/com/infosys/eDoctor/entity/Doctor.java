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
<<<<<<< HEAD
    private String mobileNo;
    private String email;
    private String password;
=======
    private int mobileNo;
    private String email;
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484

    @Lob
    private byte[] profilePhoto;

    public Doctor() {
<<<<<<< HEAD

    }

    public Doctor(String doctorId, String doctorName, String speciality, String location, String experience,
                  String mobileNo, String email, String password, byte[] profilePhoto) {
=======
    }

    public Doctor(String doctorId, String doctorName, String speciality, String location, String experience, int mobileNo, String email, byte[] profilePhoto) {
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.speciality = speciality;
        this.location = location;
        this.experience = experience;
        this.mobileNo = mobileNo;
        this.email = email;
<<<<<<< HEAD
        this.password = password;
        this.profilePhoto = profilePhoto;
    }

=======
        this.profilePhoto = profilePhoto;
    }

    // Getters and setters
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
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

<<<<<<< HEAD
    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
=======
    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

<<<<<<< HEAD
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

=======
>>>>>>> cf5a0064cbc3cb72d1577d23d9215595507e9484
    public byte[] getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }
}

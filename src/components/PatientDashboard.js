import React, { useState, useEffect } from "react";
import axios from "axios";
import "./PatientDashboard.css";
import "./ShowDoctorList.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faUser, faCalendarAlt, faHistory, faStethoscope } from "@fortawesome/free-solid-svg-icons";

const PatientDashboard = () => {
  const [activeTab, setActiveTab] = useState("createProfile");
  const [profileFormData, setProfileFormData] = useState({
    patientId: "",
    patientName: "",
    mobileNo: "",
    email: "",
    password: "",
    bloodGroup: "",
    gender: "",
    age: "",
    address: "",
  });

  const [profileData, setProfileData] = useState(null);
  const [appointmentFormData, setAppointmentFormData] = useState({
    AppointmentID: "",
    patientId: "",
    DoctorID: "",
    Date: "",
    Remark: "",
  });
  const [appointmentHistory, setAppointmentHistory] = useState([]);

  const [doctors, setDoctors] = useState([]);
  const [doctorLoading, setDoctorLoading] = useState(true);
  const [doctorError, setDoctorError] = useState(null);
  const [doctorAvailability, setDoctorAvailability] = useState({});

  useEffect(() => {
    const fetchDoctors = async () => {
      try {
        const response = await axios.get("http://localhost:8000/doctor/getAllDoctors");
        setDoctors(response.data);
      } catch (error) {
        setDoctorError(error.message);
      } finally {
        setDoctorLoading(false);
      }
    };

    fetchDoctors();
  }, []);

  const fetchDoctorAvailability = async (doctorId) => {
    try {
      const response = await axios.get(`http://localhost:8000/getByDoctor/${doctorId}`);
      setDoctorAvailability((prevAvailability) => ({
        ...prevAvailability,
        [doctorId]: response.data,
      }));
    } catch (error) {
      console.error("Error fetching doctor availability:", error);
    }
  };

  const handleFormChange = (e, formSetter) => {
    const { name, value } = e.target;
    formSetter((prevFormData) => ({ ...prevFormData, [name]: value }));
  };

  const handleProfileSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8000/patient/addPatient",
        profileFormData
      );
      setProfileFormData({
        patientId: "",
        patientName: "",
        mobileNo: "",
        email: "",
        password: "",
        bloodGroup: "",
        gender: "",
        age: "",
        address: "",
      });

      setProfileData(response.data);
      setActiveTab("patientProfile");
    } catch (error) {
      console.error("Error submitting profile data:", error);
    }
  };

  const handleAppointmentSubmit = (e) => {
    e.preventDefault();

    setAppointmentHistory([...appointmentHistory, appointmentFormData]);
    setAppointmentFormData({
      AppointmentID: "",
      patientId: "",
      DoctorID: "",
      Date: "",
      Remark: "",
    });
    setActiveTab("appointmentHistory");
  };

  return (
    <div className="patient-dashboard-container">
      <div className="patient-sidebar">
        <div className="sidebar-header">
          <h2>Dashboard</h2>
        </div>
        <div className="sidebar-links">
          <button
            onClick={() => setActiveTab(profileData ? "patientProfile" : "createProfile")}
            className="sidebar-button"
          >
            <FontAwesomeIcon icon={faUser} /> {profileData ? "View Profile" : "Create Profile"}
          </button>
          <button onClick={() => setActiveTab("bookAppointment")} className="sidebar-button">
            <FontAwesomeIcon icon={faCalendarAlt} /> Book Appointment
          </button>
          <button onClick={() => setActiveTab("appointmentHistory")} className="sidebar-button">
            <FontAwesomeIcon icon={faHistory} /> Appointment History
          </button>
          <button onClick={() => setActiveTab("doctorList")} className="sidebar-button">
            <FontAwesomeIcon icon={faStethoscope} /> Show Doctor List
          </button>
        </div>
      </div>

      <div className="patient-main-content">
        <header className="patient-dashboard-header">
          <h1>Patient Dashboard</h1>
        </header>
        <div className="patient-content-container">
          {activeTab === "createProfile" && (
            <div className="card profile-form">
              <h2>Create Profile</h2>
              <form onSubmit={handleProfileSubmit}>
                {Object.keys(profileFormData).map((key) => (
                  <input
                    key={key}
                    type={key === "email" ? "email" : "text"}
                    name={key}
                    placeholder={key.replace(/([A-Z])/g, " $1")}
                    value={profileFormData[key]}
                    onChange={(e) => handleFormChange(e, setProfileFormData)}
                    required
                  />
                ))}
                <button type="submit">Submit</button>
              </form>
            </div>
          )}

          {activeTab === "patientProfile" && profileData && (
            <div className="card profile-info">
              <h2>Patient Profile</h2>
              {Object.entries(profileData).map(([key, value]) => (
                <p key={key}>
                  <strong>{key.replace(/([A-Z])/g, " $1")}:</strong> {value}
                </p>
              ))}
            </div>
          )}

          {activeTab === "bookAppointment" && (
            <div className="card appointment-form">
              <h2>Book Appointment</h2>
              <form onSubmit={handleAppointmentSubmit}>
                {Object.keys(appointmentFormData).map((key) => (
                  <input
                    key={key}
                    type="text"
                    name={key}
                    placeholder={key.replace(/([A-Z])/g, " $1")}
                    value={appointmentFormData[key]}
                    onChange={(e) => handleFormChange(e, setAppointmentFormData)}
                    required
                  />
                ))}
                <button type="submit">Book Appointment</button>
              </form>
            </div>
          )}

          {activeTab === "appointmentHistory" && (
            <div className="card appointment-history">
              <h2>Appointment History</h2>
              {appointmentHistory.length > 0 ? (
                <ul>
                  {appointmentHistory.map((appointment, index) => (
                    <li key={index}>
                      {Object.entries(appointment).map(([key, value]) => (
                        <p key={key}>
                          <strong>{key.replace(/([A-Z])/g, " $1")}:</strong> {value}
                        </p>
                      ))}
                    </li>
                  ))}
                </ul>
              ) : (
                <p>No appointments booked yet.</p>
              )}
            </div>
          )}

          {activeTab === "doctorList" && (
            <div className="doctor-list-container">
              <h1>Doctor List</h1>
              {doctorLoading && <p>Loading doctors...</p>}
              {doctorError && <p>Error: {doctorError}</p>}

              {!doctorLoading && !doctorError && doctors.length > 0 ? (
                doctors.map((doctor) => (
                  <div
                    key={doctor.doctorId}
                    className="doctor-card"
                    onMouseEnter={() => fetchDoctorAvailability(doctor.doctorId)}
                  >
                    <h2>{doctor.doctorName}</h2>
                    <p>
                      <strong>Speciality:</strong> {doctor.speciality}
                    </p>
                    <p>
                      <strong>Location:</strong> {doctor.location}
                    </p>
                    <p>
                      <strong>Mobile No:</strong> {doctor.mobileNo}
                    </p>
                    <p>
                      <strong>Email:</strong> {doctor.email}
                    </p>
                    <p>
                      <strong>DoctorID:</strong> {doctor.doctorId}
                    </p>
                    <p>
                      <strong>Experience:</strong> {doctor.experience} years
                    </p>
                    {doctorAvailability[doctor.doctorId] && (
                      <>
                        <p>
                          <strong>Start Date:</strong> {doctorAvailability[doctor.doctorId].startDate}
                        </p>
                        <p>
                          <strong>End Date:</strong> {doctorAvailability[doctor.doctorId].endDate}
                        </p>
                      </>
                    )}
                    <button onClick={() => setActiveTab("bookAppointment")}>Schedule Appointment</button>
                  </div>
                ))
              ) : (
                <p>No doctors available.</p>
              )}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default PatientDashboard;

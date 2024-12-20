import React, { useState } from "react";
import "./DoctorDashboard.css";
import DoctorProfile from "./DoctorProfile";
import AvailabilityForm from "./AvailabilityForm";
import ViewAppointments from "./ViewAppointments";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendarAlt, faTimesCircle, faCheckCircle, faUser, faClock, faSignOutAlt } from "@fortawesome/free-solid-svg-icons";

const DoctorDashboard = () => {
  const [activeTab, setActiveTab] = useState("Dashboard");

  const handleLogout = () => {
    alert("Logged out successfully!");
    window.location.href = "/login"; // Redirect to login page
  };

  return (
    <div className="dashboard-container">
      {/* Sidebar */}
      <div className="sidebar">
        <button onClick={() => setActiveTab("Dashboard")}>
          <FontAwesomeIcon icon={faUser} /> Dashboard
        </button>
        <button onClick={() => setActiveTab("DoctorProfile")}>
          <FontAwesomeIcon icon={faUser} /> Doctor Profile
        </button>
        <button onClick={() => setActiveTab("AvailabilityForm")}>
          <FontAwesomeIcon icon={faClock} /> Manage Availability
        </button>
        <button onClick={() => setActiveTab("ViewAppointments")}>
          <FontAwesomeIcon icon={faCalendarAlt} /> View Appointments
        </button>
        <button className="logout-button" onClick={handleLogout}>
          <FontAwesomeIcon icon={faSignOutAlt} /> Logout
        </button>
      </div>

      {/* Main Content */}
      <div className="main-content">
        <h1 className="dashboard-heading">Welcome to Doctor Dashboard</h1>

        {/* Dashboard Information */}
        {activeTab === "Dashboard" && (
          <div className="dashboard-content">
            <div className="dashboard-box" style={{ backgroundColor: "#4CAF50" }}>
              <FontAwesomeIcon icon={faCalendarAlt} size="2x" />
              <h3 style={{ color: "black" }}>Total Appointments</h3>
              <p>0</p>
            </div>

            <div className="dashboard-box" style={{ backgroundColor: "#f44336" }}>
              <FontAwesomeIcon icon={faTimesCircle} size="2x" />
              <h3 style={{ color: "black" }}>Canceled Appointments</h3>
              <p>0</p>
            </div>

            <div className="dashboard-box" style={{ backgroundColor: "#2196F3" }}>
              <FontAwesomeIcon icon={faCheckCircle} size="2x" />
              <h3 style={{ color: "black" }}>Completed Appointments</h3>
              <p>0</p>
            </div>
          </div>
        )}

        {activeTab === "DoctorProfile" && <DoctorProfile />}
        {activeTab === "AvailabilityForm" && <AvailabilityForm />}
        {activeTab === "ViewAppointments" && <ViewAppointments />}
      </div>
    </div>
  );
};

export default DoctorDashboard;

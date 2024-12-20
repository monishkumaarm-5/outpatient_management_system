import React, { useEffect, useState } from "react";
import axios from "axios";
import "./ViewAppointments.css";

const ViewAppointments = () => {
  const [appointments, setAppointments] = useState([]);

  useEffect(() => {
    const fetchAppointments = async () => {
      try {
        const response = await axios.get('http://localhost:8000/appointments');
        setAppointments(response.data);
      } catch (error) {
        console.error("Error fetching appointments:", error);
      }
    };

    fetchAppointments();
  }, []);

  return (
    <div>
      <h2>Appointments</h2>
      {appointments.length === 0 ? (
        <p>No appointments available.</p>
      ) : (
        <ul>
          {appointments.map((appt, index) => (
            <li key={index}>
              <strong>{appt.patientName}</strong> - {appt.date} at {appt.time}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ViewAppointments;

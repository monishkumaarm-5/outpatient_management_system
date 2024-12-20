import React, { useEffect, useState } from "react";
import axios from "axios";
import "./ShowDoctorList.css"; // Import the CSS file

const ShowDoctorList = () => {
  const [doctors, setDoctors] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchDoctors = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/doctors");
        setDoctors(response.data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchDoctors();
  }, []);

  useEffect(() => {
    const fetchDoctors = async () => {
      try {
        const response = await axios.get("http://localhost:8080/availability/getAll");
        setDoctors(response.data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchDoctors();
  }, []);

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error: {error}</div>;

  return (
    <div className="doctor-list-container">
      {doctors.map((doctor,availability) => (
        <div key={doctor.doctorId} className="doctor-card">
          <h2>{doctor.doctorName}</h2>
          <p><strong>Speciality:</strong> {doctor.speciality}</p>
          <p><strong>Location:</strong> {doctor.location}</p>
          <p><strong>Experience:</strong> {doctor.experience} years</p>
          <p><strong>Mobile No:</strong> {doctor.mobileNo}</p>
          <p><strong>Email:</strong> {doctor.email}</p>
          <p><strong>Availability:</strong> {availability.startDate}</p>
          <p><strong>Availability:</strong> {availability.endDate}</p>
        </div>
      ))}
    </div>
  );
};

export default ShowDoctorList;

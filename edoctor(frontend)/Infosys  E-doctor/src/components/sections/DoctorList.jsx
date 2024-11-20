// src/components/DoctorList.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
import './DoctorList.css';

function DoctorList() {
  const [doctors, setDoctors] = useState([]); // State to store the list of doctors
  const [loading, setLoading] = useState(true); // State to manage loading status
  const [error, setError] = useState(null); // State to handle errors

  // Fetch doctors from the API
  useEffect(() => {
    axios
      .get('http://localhost:8082/getDoctorList') // Replace with your API endpoint
      .then((response) => {
        setDoctors(response.data); // Update state with fetched data
        setLoading(false); // Stop loading
      })
      .catch((error) => {
        console.error('Error fetching doctors:', error);
        setError('Failed to fetch doctor list.');
        setLoading(false); // Stop loading
      });
  }, []);

  if (loading) {
    return <div>Loading...</div>; // Display loading indicator
  }

  if (error) {
    return <div className="error">{error}</div>; // Display error message
  }

  return (
    <div className="doctor-list">
      <h2>Doctor List</h2>
      <Link to="/createdoctor">
        <button className="add-doctor-btn">Add Doctor</button>
      </Link>
      <table className="doctor-table">
        <thead>
          <tr>
            <th>Doctor ID</th>
            <th>Name</th>
            <th>Speciality</th>
            <th>Location</th>
            <th>Hospital</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Password</th>
          </tr>
        </thead>
        <tbody>
          {doctors.map((doctor, index) => (
            <tr key={index}>
              <td>{doctor.doctorId}</td>
              <td>{doctor.doctorName}</td>
              <td>{doctor.speciality}</td>
              <td>{doctor.location}</td>
              <td>{doctor.hospitalName}</td>
              <td>{doctor.email}</td>
              <td>{doctor.mobileNo}</td>
              <td>{doctor.password}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default DoctorList;

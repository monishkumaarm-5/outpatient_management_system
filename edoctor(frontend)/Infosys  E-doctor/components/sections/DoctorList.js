import React, { useState } from 'react';

function DoctorList() {
  const [doctors, setDoctors] = useState([]);  // State to hold doctor data
  const [newDoctor, setNewDoctor] = useState({
    doctorId: '',
    doctorName: '',
    specialty: '',
    location: '',
    hospitalName: '',
    email: '',
    phoneNumber: '',
    password: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewDoctor((prevDoctor) => ({
      ...prevDoctor,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setDoctors((prevDoctors) => [...prevDoctors, newDoctor]);
    setNewDoctor({
      doctorId: '',
      doctorName: '',
      specialty: '',
      location: '',
      hospitalName: '',
      email: '',
      phoneNumber: '',
      password: '',
    });
  };

  return (
    <div className="doctor-list">
      <h2>Doctor List</h2>

      {/* Add Doctor Form */}
      <div className="add-doctor">
        <h3>Add New Doctor</h3>
        <form onSubmit={handleSubmit}>
          <label>
            Doctor ID:
            <input type="text" name="doctorId" value={newDoctor.doctorId} onChange={handleChange} required />
          </label>
          <label>
            Doctor Name:
            <input type="text" name="doctorName" value={newDoctor.doctorName} onChange={handleChange} required />
          </label>
          <label>
            Specialty:
            <input type="text" name="specialty" value={newDoctor.specialty} onChange={handleChange} required />
          </label>
          <label>
            Location:
            <input type="text" name="location" value={newDoctor.location} onChange={handleChange} required />
          </label>
          <label>
            Hospital Name:
            <input type="text" name="hospitalName" value={newDoctor.hospitalName} onChange={handleChange} required />
          </label>
          <label>
            Email:
            <input type="email" name="email" value={newDoctor.email} onChange={handleChange} required />
          </label>
          <label>
            Phone Number:
            <input type="text" name="phoneNumber" value={newDoctor.phoneNumber} onChange={handleChange} required />
          </label>
          <label>
            Password:
            <input type="password" name="password" value={newDoctor.password} onChange={handleChange} required />
          </label>
          <button type="submit">Add Doctor</button>
        </form>
      </div>

      {/* Doctor List Table */}
      <div className="doctor-table">
        <h3>List of Doctors</h3>
        <table>
          <thead>
            <tr>
              <th>Doctor ID</th>
              <th>Doctor Name</th>
              <th>Specialty</th>
              <th>Location</th>
              <th>Hospital Name</th>
              <th>Email</th>
              <th>Phone Number</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {doctors.map((doctor, index) => (
              <tr key={index}>
                <td>{doctor.doctorId}</td>
                <td>{doctor.doctorName}</td>
                <td>{doctor.specialty}</td>
                <td>{doctor.location}</td>
                <td>{doctor.hospitalName}</td>
                <td>{doctor.email}</td>
                <td>{doctor.phoneNumber}</td>
                <td>
                  <button>Edit</button>
                  <button>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default DoctorList;


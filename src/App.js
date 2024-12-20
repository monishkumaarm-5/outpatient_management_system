// src/App.js
import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import Dashboard from './components/Dashboard';
import DoctorList from './components/sections/DoctorList';
import DoctorDashboard from './components/DoctorDashboard';
import PatientDashboard from './components/PatientDashboard';
import ShowDoctorList from './components/ShowDoctorList';
function App() {
  // State to hold doctor data
  const [doctors, setDoctors] = useState([]);

  // Function to add a new doctor to the list
  const addDoctor = (doctor) => {
    setDoctors((prevDoctors) => [...prevDoctors, doctor]);
  };

  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/doctorlist" element={<DoctorList doctors={doctors} />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/DoctorDashboard" element={<DoctorDashboard />} /> 
        <Route path="/PatientDashboard" element={<PatientDashboard/>} />
        <Route path='/ShowDoctorList' element={<ShowDoctorList />}/>
        <Route path="/PatientDashboard" element={<doctorList />} />
        <Route path="/PatientDashboard" element={<bookAppointment />} />
      </Routes>
    </Router>
  );
}


export default App;

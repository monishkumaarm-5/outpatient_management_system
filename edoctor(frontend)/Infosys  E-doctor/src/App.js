// src/App.js
import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import Dashboard from './components/Dashboard';
import DoctorList from './components/sections/DoctorList';
import CreateDoctor from './components/sections/CreateDoctor';

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
        <Route path="/dashboard" element={<Dashboard />} />
        <Route 
          path="/doctorlist" 
          element={<DoctorList doctors={doctors} />} 
        />
        <Route 
          path="/createdoctor" 
          element={<CreateDoctor addDoctor={addDoctor} />} 
        />
      </Routes>
    </Router>
  );
}

export default App;

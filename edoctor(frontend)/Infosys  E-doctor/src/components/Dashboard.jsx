// src/components/Dashboard.js
import React from 'react';
import { Link } from 'react-router-dom';
import './Dashboard.css';  // Importing the styles

function Dashboard() {
  return (
    <div className="dashboard">
      <h1>Welcome to the Dashboard</h1>
      <ul>
        <li><Link to="/doctorlist">Doctor List</Link></li>
        <li><Link to="#">User List</Link></li>
        <li><Link to="#">Patient List</Link></li>
        <li><Link to="#">Admin List</Link></li>
        <li><Link to="#">Appointment List</Link></li>
        <li><Link to="#">Availability Dates</Link></li>
        <li><Link to="#">Feedback List</Link></li>
        <li><Link to="#">Logout</Link></li>
      </ul>
    </div>
  );
}

export default Dashboard;

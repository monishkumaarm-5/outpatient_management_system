import React, { useState } from "react";
import axios from "axios";
import "./AvailabilityForm.css";

const AvailabilityForm = () => {
  const [availabilityData, setAvailabilityData] = useState({
    doctorId: "",
    startDate: "",
    endDate: "",
    //fromTime: "",
    //toTime: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setAvailabilityData({ ...availabilityData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8000/availability/addAvailability', availabilityData);
      alert("Availability added successfully!");
      setAvailabilityData({
        doctorId: "",
        startDate: "",
        endDate: "",
       // fromTime: "",
       // toTime: "",
      });
    } catch (error) {
      console.error("Error adding availability:", error);
    }
  };

  return (
    <div className="availability-form-container">
      <h2>Add/Edit Availability</h2>
      <form onSubmit={handleSubmit}>
        <input name="doctorId" placeholder="Doctor ID" value={availabilityData.doctorId} onChange={handleChange} required />
        <input type="date" name="startDate" value={availabilityData.startDate} onChange={handleChange} required />
        <input type="date" name="endDate" value={availabilityData.endDate} onChange={handleChange} required />
       {/*  <input type="time" name="fromTime" value={availabilityData.fromTime} onChange={handleChange} required />
        <input type="time" name="toTime" value={availabilityData.toTime} onChange={handleChange} required /> */}
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AvailabilityForm;

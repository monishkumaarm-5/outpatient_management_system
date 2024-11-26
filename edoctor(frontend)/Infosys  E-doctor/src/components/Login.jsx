import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Login.css';

function Login() {
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const [userType, setUserType] = useState('');
  const navigate = useNavigate();

  const handleForgotPassword = () => {
    alert('Forgot password functionality not implemented yet.');
    // You can replace this with actual logic for sending a reset link or emailing the user
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    const loginData = { userId, password, userType };
    console.log('Login data:', loginData);

    try {
      const response = await axios.post('http://localhost:8082/loginUser', loginData);

      // Assuming the server response contains a "success" key
      if (response.data === true) {
        console.log('Server response:', response.data);
        navigate('/dashboard'); // Redirect to the dashboard upon successful login
        //alert('Login successful!');
      } else {
        alert('Login unsuccessful. Please check your credentials.');
      }
    } catch (error) {
      // Handling server errors or network issues
      if (error.response && error.response.data) {
        alert(`Login failed: ${error.response.data.message}`);
      } else {
        alert('An error occurred during login. Please try again later.');
      }
      console.error('Login error:', error);
    }
  };

  return (
    <div className="login-container">
      <form className="login-form" onSubmit={handleLogin}>
        <h2>Login</h2>
        <label htmlFor="userId">Email</label>
        <input
          type="email"
          id="userId"
          name="userId"
          value={userId}
          onChange={(e) => setUserId(e.target.value)}
          required
        />
        <label htmlFor="password">Password</label>
        <input
          type="password"
          id="password"
          name="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <label htmlFor="userType">Role</label>
        <select
          id="userType"
          value={userType}
          onChange={(e) => setUserType(e.target.value)}
          required
        >
          <option value="">Select Role</option>
          <option value="Patient">Patient</option>
          <option value="Doctor">Doctor</option>
        </select>
        <button type="submit">Login</button>
        <p>New user? <a href="/register">Register here</a></p>
        <button type="button" onClick={handleForgotPassword} className="forgot-password-button">
          Forgot Password?
        </button>
      </form>
    </div>
  );
}

export default Login;

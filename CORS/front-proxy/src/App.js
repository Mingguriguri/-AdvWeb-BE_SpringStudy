import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from 'react-bootstrap';

function App() {
  const [message, setMessage] = useState('');
  
  const responseHandler = (response) => {
    setMessage(response.data);
  };

  const errorHandler = (error) => {
    setMessage(error.message);
  };

  const onNonCorsHeaderHandler = () => {
    axios.get('http://localhost:8080/not-cors')
      .then(responseHandler)
      .catch(errorHandler);
  };

  const onCorsHeaderHandler = () => {
    axios.get('http://localhost:8080/cors')
      .then(responseHandler)
      .catch(errorHandler);
  }

  return (
    <div className="App" align="center">
      <br />
      <h2>GCU PROXY</h2>
      <p>(FrontEnd-BackEnd Integration)</p>
      <br />
      <p>{message}</p>
      <div>
        <Button variant="secondary" size="lg"
          onClick={onNonCorsHeaderHandler}>
            non cors header
        </Button>
        <Button variant="primary" size="lg"
          onClick={onCorsHeaderHandler}>
          cors header
        </Button>
      </div>
    </div>
  );
}

export default App;

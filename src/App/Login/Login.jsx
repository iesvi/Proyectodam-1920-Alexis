import React from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import './Style.css';


const Login = ({ logInUser }) => {
  const handleSubmit = (event) => {
    const data = new FormData(event.target);

    const object = {};
    data.forEach((value, key) => { object[key] = value; });

    event.preventDefault();
    console.log('usuario: ', object);

    axios.post('http://54.163.97.108:8085/login/login', object)
      .then((response) => {
        if (response.status === 200) {
          logInUser(object.name, 'Logged');
        }
      });
  };


  return (
    <div className="wrapper fadeInDown">
      <div id="formContent">


        <form onSubmit={handleSubmit}>
          <br />
          <input type="text" id="name" className="fadeIn second" name="name" placeholder="login" />
          <input type="password" id="password" className="fadeIn third" name="password" placeholder="password" />
          <input type="submit" className="fadeIn fourth" value="Log In" />
        </form>

        <div id="formFooter">
          <Link className="underlineHover" to=".">Forgot Password?</Link>
        </div>

      </div>
    </div>

  );
};
export default Login;

import React, { useState } from 'react';
import './TopBar.css';
import { Link } from 'react-router-dom';


const TopBar = ({ browser }) => {
  const handleSubmit = (event) => {
    browser(event.target[0].value);
  };

  return (

    <nav className="navbar navbar-expand-md navbar-dark bg-dark fondo">
      <ul className="navbar-nav  ml-auto">
        <li>
          <Link className="brand" to="/">
            Organize-It
            {' '}
            <h5>{localStorage.getItem('userName')}</h5>
          </Link>
        </li>
        <li className="nav-item" />
        <li className="nav-item ml-sm-4">
          <Link className="nav-link" to="/myActivities">
            <h6>My Activities</h6>
          </Link>
        </li>
      </ul>

      <div className="container">
        <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav  ml-auto">

            <li className="nav-item">
              <Link className="nav-link" to="/newActivity">
                Crear Actividad
              </Link>
            </li>
            <li className="nav-item">
              <Link className="nav-link" to="/login">Identificarse</Link>
            </li>
            <li className="nav-item mr-sm-5">
              <Link className="nav-link" to="/regist">
                <span className="glyphicon glyphicon-user" />
                Registrase
              </Link>
            </li>
            <li>
              <form className="form-inline" onSubmit={handleSubmit}>
                <input className="form-control mr-sm-2" type="text" placeholder="Evento" />
                <button className="btn btn-danger" type="submit">Buscar</button>
              </form>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default TopBar;

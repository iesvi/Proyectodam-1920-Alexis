import React from 'react';
import axios from 'axios';
import { ToastsContainer, ToastsStore, ToastsContainerPosition } from 'react-toasts';

const Regist = ({ logInUser }) => {
  const handleSubmitRegist = (event) => {
    event.preventDefault();

    // Crear objeto a enviar
    const data = new FormData(event.target);
    const object = {};
    data.forEach((value, key) => { object[key] = value; });

    // Enviar objeto
    axios.post('http://54.163.97.108:8085/login/regist', object)
      .catch((error) => {
        if (error.response.data === 'name') {
          ToastsStore.error('El nombre de usuario está en uso');
        } else if (error.response.data === 'email') {
          ToastsStore.error('El email ya está en uso');
        } else {
          ToastsStore.error('Error');
        }
      })
      .then((response) => {
        if (response.status === 200) {
          logInUser(object.name, 'Registro completado con exito!');
        }
      });
  };

  const handleSubmitLogin = (event) => {
    // Crear objeto a enviar
    const data = new FormData(event.target);
    const object = {};
    data.forEach((value, key) => { object[key] = value; });

    // Enviar objeto
    event.preventDefault();
    axios.post('http://54.163.97.108:8085/login/login', object)
      .catch((error) => {
        ToastsStore.error('Error');
      })
      .then((response) => {
        if (response.status === 200) {
          logInUser(object.name, 'Logged');
        }
      });
  };


  return (
    <div className="container-fluid">
      <div className="container pt-4">
        <ToastsContainer position={ToastsContainerPosition.TOP_CENTER} store={ToastsStore} />
        <hr />
        <h2 className="text-center" id="title">Formulario de registro</h2>
        <hr />
        <div className="row">
          <div className="col-md-5">
            <form onSubmit={handleSubmitRegist}>
              <fieldset>
                <p className="text-uppercase pull-center"> Registrate.</p>

                <div className="form-group">
                  <input type="user" id="name" name="name" className="form-control input-lg" placeholder="Nombre de usuario" />
                </div>

                <div className="form-group">
                  <input type="email" id="email" name="email" className="form-control input-lg" placeholder="Email" />
                </div>
                <div className="form-group">
                  <input type="password" id="password" name="password" className="form-control input-lg" placeholder="Contraseña" />
                </div>
                <div>
                  <input type="submit" className="btn btn-lg btn-primary" value="Register" />
                </div>
              </fieldset>
            </form>
          </div>

          <div className="col-md-2" />

          <div className="col-md-5">
            <form onSubmit={handleSubmitLogin}>
              <fieldset>
                <p className="text-uppercase"> ¿Ya tienes cuenta de usuario?: </p>

                <div className="form-group">
                  <input type="user" name="name" id="name" className="form-control input-lg" placeholder="Nombre de usuario" />
                </div>
                <div className="form-group">
                  <input type="password" name="password" id="password" className="form-control input-lg" placeholder="Contraseña" />
                </div>
                <div>
                  <input type="submit" className="btn btn-md" value="Sign In" />
                </div>

              </fieldset>
            </form>
          </div>
        </div>
      </div>


    </div>

  );
};

export default Regist;

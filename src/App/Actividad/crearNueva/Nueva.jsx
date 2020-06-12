import React, { useState, useReducer, useEffect } from 'react';
import ImageUploader from 'react-images-upload';
import {
  Modal, Form, FormGroup, Button,
} from 'react-bootstrap';

import axios from 'axios';
import UserItem from '../../User/UserItem';

import Fecha, { FechaAdd, FechaSimple } from './Fecha';
import Lugar, { LugarAdd } from './Lugar';
import Barra from './Barra';

const Nueva = ({ mail, goToActivities }) => {
  const [titulo, setTitulo] = useState('');
  const [descripcion, setDescripcion] = useState('');
  const [participativa, setParticipativa] = useState(false);
  const [publica, setPublica] = useState(true);
  const [fecha, setFecha] = useState([]);
  const [lugar, setLugar] = useState([]);
  const [fechaLimite, setFechaLimite] = useState();
  const [img, setImg] = useState();
  const [userMail] = useState(mail);
  const [usuarios] = useState([]);


  // Controladores para las ventanas modales
  const [showUsers, setShowUsers] = useState(false);
  const openUsers = () => setShowUsers(true);
  const handleCloseUsers = () => setShowUsers(false);
  const [tmpUser, setTmpUser] = useState();
  const [usuariosInvitados, editUsuariosInvitados] = useReducer((fechs, { type, value }) => {
    switch (type) {
      case 'add':
        return [...fechs, value];
      case 'remove':
        return fechs.filter((item) => item.props.name !== value);
      default:
        return fechs;
    }
  }, []);

  const [showAlert, setShowAlert] = useState(false);
  const handleCloseAlert = () => { setShowAlert(false); };
  const handleShowAlert = () => { setShowAlert(true); };

  const removeUser = (e) => {
    editUsuariosInvitados({ type: 'remove', value: e });
  };


  const acceptUser = () => {
    axios.get(`http://54.163.97.108:8085/login/exists/${tmpUser}`).then(
      (response) => {
        if (response.status === 200) {
          usuariosInvitados.push(<UserItem key={new Date().getMilliseconds()} name={tmpUser} removeMe={removeUser} />);
          setTmpUser('');
        }
      },
    );
  };


  const onDrop = (e) => {
    setImg(e);
  };

  // Controlador boton crear
  const buttonHandler = () => {
    if (fecha.length < 1 || lugar.length < 1 || fechaLimite === undefined
       || titulo === '' || descripcion === '') {
      handleShowAlert();
    } else {
      usuarios.push(userMail);

      const formData = new FormData();
      formData.set('id', '');
      formData.set('titulo', titulo);
      formData.set('descripcion', descripcion);
      formData.set('creador', userMail);
      formData.set('participativa', participativa);
      formData.set('publica', publica);
      formData.set('fechaLimite', fechaLimite);
      formData.set('lugar', lugar);
      formData.set('usuarios', usuarios);
      formData.append('fechas', fecha);

      const invitados = [];

      usuariosInvitados.forEach((element) => {
        invitados.push(element.props.name);
      });
      formData.append('usuariosInvitados', invitados);

      /*
    const imageData = new FormData();
    imageData.set('file', img);

    axios.post('http://54.163.97.108:8081/api/v1/new', imageData, {
      headers: {
        Accept: 'multipart/form-data',
        'Content-Type': 'multipart/form-data',
        boundary: '----WebKitFormBoundaryBnfZHwXBnCFnxSz3',
        charset: 'UTF-8',
      },
    });
*/
      const object = {};
      formData.forEach((value, key) => { object[key] = value; });


      axios.post('http://54.163.97.108:8085/activity/new', object).then(() => {
        goToActivities();
      });
    }
  };


  const [lugares, editLugares] = useReducer((lugares, { type, value }) => {
    switch (type) {
      case 'add':
        return [...lugares, value];
      case 'remove':
        return lugares.filter((_, index) => index !== value);
      case 'reduce':
        return lugares.filter((_, index) => index < value);
      default:
        return lugares;
    }
  }, []);

  const [fechs, editFechs] = useReducer((fechs, { type, value }) => {
    switch (type) {
      case 'add':
        return [...fechs, value];
      case 'remove':
        return fechs.filter((_, index) => index !== value);
      case 'reduce':
        return fechs.filter((_, index) => index < value);
      default:
        return fechs;
    }
  }, []);


  const removeLugar = () => {
    editLugares({ type: 'remove', value: lugares.length - 1 });

    lugar.pop();
    console.log(lugar);
  };

  const addLugar = (e) => {
    if (((!participativa && lugares.length < 5) || (participativa && lugares.length < 2)) && e != null) {
      const id = Math.random() * (9999);
      editLugares({ type: 'add', value: <LugarAdd key={id} lugar={e} /> });

      lugar.push(`${e} -`);
      console.log(lugar);
    }
  };

  const removeFecha = () => {
    editFechs({ type: 'remove', value: fechs.length - 1 });
    fecha.pop();
    console.log(fecha);
  };

  const addFecha = (e) => {
    if (((!participativa && fechs.length < 5) || (participativa && fechs.length < 3)) && e != null) {
      const id = Math.random() * (9999);
      editFechs({ type: 'add', value: <FechaAdd key={id} fecha={e} /> });
    }
    fecha.push(e.toString());
  };

  const changePartipativaValue = () => {
    editFechs({ type: 'reduce', value: 2 });
    editLugares({ type: 'reduce', value: 2 });

    setFecha(fecha.filter((_, index) => index < 3));
    setLugar(lugar.filter((_, index) => index < 3));


    setParticipativa(!participativa);


    const showUser = () => {
      setShowUsers(true);
    };
  };


  return (
    <div className="fondogris">
      <br />

      <div className="container pl-5 ml-5">


        <div className="row mt-4 pb-5">

          <div className="d-flex flex-column col-md-5 ml-3 mr-4 px-0">
            <Form>
              <FormGroup>
                <h4>Titulo</h4>
                <input onChange={(e) => setTitulo(e.target.value)} value={titulo} className="col-md border border-secondary rounded shadow-sm" lugarholder="Añade un título a la actividad" />
              </FormGroup>
            </Form>
            <br />


            {/* Subir foto */}
            <h4>Añade una foto</h4>
            <ImageUploader
              className="col-md"
              name="file"
              withIcon
              withPreview
              onChange={onDrop}
              imgExtension={['.jpg', '.gif', '.png', '.gif']}
              maxFileSize={5242880}
            />


            <div className="col-md">
              <FechaSimple title="Fecha Límite" setFechaPropuesta={setFechaLimite} horas={false} />
            </div>


          </div>

          <table className="col-md ml-4" height="20vh">
            <tbody>

              <tr className="d-flex flex-column ml-2">
                <Barra addUser={openUsers} publica={publica} setPublica={setPublica} participativa={participativa} setParticipativa={changePartipativaValue} />
              </tr>
              <tr className="d-flex flex-row">

                <td className="col-md-8 mt-4">
                  <div className="d-flex flex-column">
                    <Fecha addFecha={addFecha} removeFecha={removeFecha} fecha={fecha} />
                    {fechs}
                  </div>
                </td>

                <td className="col-md-6 pl-0 mt-4">
                  <div className="d-flex flex-column px-0">
                    <Lugar addLugar={addLugar} removeLugar={removeLugar} lugar={lugar} setLugar={setLugar} />
                    {lugares}
                  </div>
                </td>

              </tr>
            </tbody>
          </table>

        </div>


        <div className="flex-row d-flex pb-5">

          <div className="d-flex flex-column p-0 col-md-6">
            <h4>Descripción</h4>
            <textarea onChange={(e) => { setDescripcion(e.target.value); }} value={descripcion} className="border border-secondary textArea rounded" lugarholder="Añade una descripción a la actividad" />
          </div>
          <br />


        </div>

        <div className="d-flex flex-column pb-2 ml-5 pl-4">
          <Button onClick={buttonHandler} className="p2 shadow border-radious rounded-pill" variant="primary" type="submit">
            PUBLICAR
          </Button>
        </div>

      </div>


      <Modal show={showUsers} onHide={handleCloseUsers}>
        <Modal.Header closeButton>
          <Modal.Title>Añade usuarios</Modal.Title>
        </Modal.Header>
        <Modal.Body>

          <div className="fondoblanco d-flex flex-row rounded border border-dark">
            <input className="input-lg pb-0" onChange={(e) => setTmpUser(e.target.value)} type="text" value={tmpUser} />
            <button className="btn btn-info my-3 ml-2" onClick={acceptUser} type="button">
              <i className="fa fa-plus" />
            </button>
          </div>

          <div className="mt-4">
            {usuariosInvitados}
          </div>

        </Modal.Body>
        <Modal.Footer>
          <Button variant="primary" onClick={() => { handleCloseUsers(); }}>
            OK
          </Button>
        </Modal.Footer>
      </Modal>


      <Modal show={showAlert} onHide={handleCloseAlert}>
        <Modal.Header closeButton>
          <Modal.Title>Rellena los datos</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          Debes rellenar todos los datos antes de crear la actividad.
          (Fechas, Lugares, Título y Descripción)
        </Modal.Body>
        <Modal.Footer>
          <Button variant="primary" onClick={() => { handleCloseAlert(); }}>
            OK
          </Button>
        </Modal.Footer>
      </Modal>


    </div>


  );
};
export default Nueva;

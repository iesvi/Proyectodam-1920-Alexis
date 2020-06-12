import React, { useState, useEffect } from 'react';
import { Modal, Button } from 'react-bootstrap';
import './Style.css';
import axios from 'axios';
import { format } from 'date-fns';
import { VoteFecha, FechaSimple, ShowFecha } from './crearNueva/Fecha';
import { VoteLugar, LugarSimple, ShowLugar } from './crearNueva/Lugar';
import User from '../User';


const Actividad = ({ goToActivities }) => {
  // Estados relacionados con la clase Activity
  const [id] = useState(window.location.pathname.substr(11));
  const [image] = useState('https://us.123rf.com/450wm/pavelstasevich/pavelstasevich1811/pavelstasevich181101065/112815953-stock-vector-no-image-available-icon-flat-vector.jpg?ver=6');
  const [titulo, setTitulo] = useState('');
  const [descripcion, setDescripcion] = useState('');
  const [usuarios] = useState([]);
  const [fechas] = useState([]);
  const [fechaLimite, setFechaLimite] = useState();
  const [lugares] = useState([]);
  const [participativa, setParticipativa] = useState();
  const [publica, setPublica] = useState();
  const [finalizada, setFinalizada] = useState();

  // Estados relacionados la relación entre el usuario logeado y la actividad
  const [usuarioParticipaFecha, setUsuarioParticipaFecha] = useState(false);
  const [usuarioParticipaLugar, setUsuarioParticipaLugar] = useState(false);
  const [usuarioAsiste, setUsuarioAsiste] = useState(false); // Indica si el usuario logeado asiste a la actividad.
  const [creador, setCreador] = useState(); // Indica si el usuario logeado es el creador.
  const [logged] = useState(localStorage.getItem('logged') === 'true');

  // Estados para el control del componente
  const [lugarAbierto, setLugarAbierto] = useState();
  const [fechaAbierto, setFechaAbierta] = useState();
  const [charged, setCharged] = useState(false); // Mientras sea falso no se renderiza el componente.
  const [userSession] = useState(localStorage.getItem('userName')); // Nombre del usuario logeado
  const [userMail] = useState(localStorage.getItem('userMail')); // Email del usuario


  // Estados para controlar los hijos del componente
  const [indicesFechas] = useState([]);
  const [indicesLugares] = useState([]);
  const [ViewFechas] = useState([]);
  const [ViewLugares] = useState([]);
  const [ViewFechasSimple] = useState([]);
  const [ViewLugaresSimple] = useState([]);
  const [lugarPropuesto, setLugarPropuesto] = useState();
  const [fechaPropuesta, setFechaPropuesta] = useState();
  const [asistentes] = useState([]);

  // Funciones
  const cleanFechas = () => indicesFechas.splice(0, indicesFechas.length);
  const cleanLugares = () => indicesLugares.splice(0, indicesLugares.length);

  const addFechaVote = (e) => indicesFechas.push(e);
  const removeFechaVote = (e) => indicesFechas.splice(indicesFechas.indexOf(e), 1);
  const addLugarVote = (e) => indicesLugares.push(e);
  const removeLugarVote = (e) => indicesLugares.splice(indicesLugares.indexOf(e), 1);

  const handleClickOnRechazar = () => {
    axios.get(`http://54.163.97.108:8085/activity/denie/${id}/${userSession}`);
    goToActivities();
  };

  const handleClickOnCancelar = () => {
    axios.get(`http://54.163.97.108:8085/activity/delete/${id}`);
    goToActivities();
  };


  const acceptDateChanges = () => { // Controla cuando el usuario acepta las propuestas hechas en la fechas.
    if (!usuarioParticipaFecha) {
      const fechaDTOList = [];

      indicesFechas.forEach((element) => {
        const d = new Date(fechas[element].date);
        d.setHours(d.getHours() - 2);

        fechaDTOList.push({ date: d.toString(), userEmail: userMail, activityId: id });
      });


      if (fechaPropuesta !== undefined) {
        const d = new Date(fechaPropuesta);
        d.setHours(d.getHours() - 2);
        fechaDTOList.push({ date: d.toString(), userEmail: userMail, activityId: id });
      }
      axios.post('http://54.163.97.108:8085/activity/addDate', fechaDTOList).then(
        () => { window.location.reload(); },
      );
    }// else sout el usuario ya ha participado
  };

  const acceptPlaceChanges = () => { // Controla cuando el usuario acepta las propuestas hechas en la fechas.
    if (!usuarioParticipaLugar) {
      const lugaresDTOList = [];

      indicesLugares.forEach((element) => {
        lugaresDTOList.push({ place: lugares[element].place, userEmail: userMail, activityId: id });
      });

      if (lugarPropuesto !== undefined) lugaresDTOList.push({ place: lugarPropuesto, userEmail: userMail, activityId: id });

      if (lugaresDTOList.length === 0) lugaresDTOList.push({ place: '', userEmail: userMail, activityId: id });

      axios.post('http://54.163.97.108:8085/activity/addPlace', lugaresDTOList).then(
        () => { window.location.reload(); },
      );
    }// else sout el usuario ya ha participado
  };

  const handleClickOnAsistir = () => {
    const data = `${userMail},${id}`;

    if (!usuarioAsiste) {
      axios.post('http://54.163.97.108:8085/activity/addUser', data);
    } else if (usuarioAsiste) {
      axios.post('http://54.163.97.108:8085/activity/removeUser', data);
    }
  };


  const [showLugar, setShowLugar] = useState(false);
  const handleCloseLugar = () => { setShowLugar(false); setLugarAbierto(false); };
  const handleShowLugar = () => {
    if (lugarAbierto) cleanLugares();
    setLugarAbierto(true);
    setShowLugar(true);
  };

  const [showFecha, setShowFecha] = useState(false);
  const handleCloseFecha = () => setShowFecha(false);
  const handleShowFecha = () => setShowFecha(true);

  const [showAlertaPlace, setShowAlertaPlace] = useState(false);
  const handleCloseAlertaPlace = () => setShowAlertaPlace(false);
  const handleShowAlertaPlace = () => setShowAlertaPlace(true);


  // Acciones necesarias de realizar antes de rendereizar el componente.
  // (Recuperar informacion de los microservicios).

  useEffect(() => {
    axios.get(`http://54.163.97.108:8085/activity/id/${id}`)
      .then((response) => {
        setTitulo(response.data.titulo);
        setDescripcion(response.data.descripcion);


        // Ha Finaliazdo
        setFinalizada(response.data.finalizada);

        // Es creador
        setCreador(response.data.creador);

        // Es publica
        setPublica(response.data.publica);

        // Es participativa.
        setParticipativa(response.data.participativa);

        // Fecha límite.
        const limitDate = new Date(response.data.fechaLimite);
        setFechaLimite(format((limitDate), 'dd-MM-yyyy'));

        // Fechas propuestas

        if (finalizada) {
          response.data.fechaFinal.forEach((element) => {
            const date = new Date(element.date);
            date.setHours(date.getHours() - 2);

            ViewFechasSimple.push(<ShowFecha startDate={date} votos={element.votes} />);
          });
        } else {
          response.data.fechas.forEach((element) => {
            const date = new Date(element.date);
            date.setHours(date.getHours() - 2);

            ViewFechas.push(<VoteFecha indice={response.data.fechas.indexOf(element)} addVote={addFechaVote} removeVote={removeFechaVote} votos={element.votes} startDate={date} />);
            ViewFechasSimple.push(<ShowFecha startDate={date} votos={element.votes} />);
            fechas.push(element);
          });
        }

        // Lugares propuestos
        if (finalizada) {
          response.data.lugarFinal.forEach((element) => {
            ViewLugaresSimple.push(<ShowLugar lugar={response.element.place} votos={element.votos} />);
          });
        } else {
          response.data.lugar.forEach((element) => {
            ViewLugares.push(<VoteLugar indice={response.data.lugar.indexOf(element)} addVote={addLugarVote} removeVote={removeLugarVote} votos={element.votos} lugar={element.place} />);
            ViewLugaresSimple.push(<ShowLugar lugar={element.place} votos={element.votos} />);
            lugares.push(element);
          });
        }
        // Carga los usuarios que asisten al evento.
        response.data.usuarios.forEach((element) => {
          usuarios.push(element);

          asistentes.push(
            <td className="col-md-1 mb-5">
              <User name={element.name} />
            </td>,
          );

          // Comprueba si el usuario logeado asiste al evento.
          if (element.email === userMail) {
            setUsuarioAsiste(true);

            // Si el usuario asiste al evento, se comprueba si ya ha participado haciento propuestas de lugar.
            if (response.data.usuariosParticipanLugar.some((v) => (v === userMail))) {
              setUsuarioParticipaLugar(true);
            }
            // Si el usuario asiste al evento, se comprueba si ya ha participado haciento propuestas de fecha.
            if (response.data.usuariosParticipanFecha.some((v) => (v === userMail))) {
              setUsuarioParticipaFecha(true);
            }
          }
        });


        setCharged(true); // Indíca que el componente ya se puede cargar.
      });
  }, []);

  return (
    <div className="fondogris">
      {charged && (
      <>

        <div className="fondoblanco mt-4 pb-2 px-0">
          <h1 align="center" className="container text-uppercase p-2 shadow-sm rounded">{titulo}</h1>
          <div className="align-middle container justify-content-between shadow-sm pt-4 px-2 pb-0 d-flex flex-row">
            <h5 className="fuentegris align-middle mt-3">
              Fecha límite
              {' '}
              {fechaLimite}
            </h5>

            <div>
              {!publica && !usuarioAsiste && creador !== userMail && <button type="button" onClick={() => { handleClickOnRechazar(); }} className="shadow-sm mt-3 mb-2 mr-4 px-2 btn btn-outline-danger"> Rechazar Invitación</button>}
              {creador !== userMail && logged && <button type="button" onClick={() => { setUsuarioAsiste(!usuarioAsiste); handleClickOnAsistir(); }} className="shadow-sm mt-3 mb-2  px-2 btn btn-outline-primary">{usuarioAsiste ? 'No asistiré' : 'Asistiré'}</button>}
              {creador === userMail && <button type="button" onClick={() => { handleClickOnCancelar(); }} className="shadow-sm mt-3 mb-2 mr-4 px-2 btn btn-outline-danger">Cancelar Actividad</button>}

            </div>
          </div>
          <hr />
        </div>
        <div className="container">
          <div className="row mt-5 pb-5">
            <div className="col-md-5 ml-3 mr-5 px-0 rounded border border-dark">
              <img src={image} className="img-fluid" alt="Actividad" />
            </div>
            <ul className="navbar-nav ml-4">
              <li>
                <div className="fondoblanco btn-lg mb-3">
                  <button type="button" onClick={handleShowLugar} className="btn btn-outline-danger btn-lg px-5 py-3 col-md mt-1 mb-1">Lugar</button>
                </div>
              </li>
              <li>
                <div className="fondoblanco btn-lg mb-3">
                  <button type="button" onClick={handleShowFecha} className="btn btn-outline-danger btn-lg px-5 py-3 col-md mt-1 mb-1">Fecha</button>
                </div>
              </li>
            </ul>
          </div>
          <br />
          <br />
          <h4>Descripción</h4>
          <br />
          <div className="truncado3 col-md-8">
            <p>{descripcion}</p>
          </div>
          <div>

            <h4 className="mt-5 pt-5">Asistirán</h4>
            <div className="container pb-5 mt-3">
              <table className="container">
                <tr className="row row-eq-height">
                  {asistentes}
                </tr>
              </table>
            </div>
          </div>
        </div>

        <Modal show={showLugar} onHide={handleCloseLugar}>
          <Modal.Header closeButton>
            <Modal.Title>Lugares propuestos</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            {usuarioAsiste && !usuarioParticipaLugar && !finalizada && participativa && <LugarSimple setLugarPropuesto={setLugarPropuesto} />}
            {usuarioAsiste && !usuarioParticipaLugar && !finalizada && ViewLugares}
            {usuarioAsiste && usuarioParticipaLugar && !finalizada && ViewLugaresSimple}
            {!usuarioAsiste && !finalizada && ViewLugaresSimple}
            {finalizada && ViewLugaresSimple}

          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={() => { cleanLugares(); handleCloseLugar(); }}>
              Cerrar
            </Button>
            <Button
              variant="primary"
              onClick={() => {
                if (usuarioParticipaLugar || !usuarioAsiste || finalizada) handleCloseLugar();
                else handleShowAlertaPlace();
              }}
            >
              Aceptar
            </Button>
          </Modal.Footer>
        </Modal>

        <Modal show={showFecha} onHide={handleCloseFecha}>
          <Modal.Header closeButton>
            <Modal.Title>Fechas propuestas</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            {usuarioAsiste && !usuarioParticipaFecha && !finalizada && participativa && <FechaSimple setFechaPropuesta={setFechaPropuesta} title="¿Quieres añadir una fecha?" />}
            {usuarioAsiste && !usuarioParticipaFecha && !finalizada && ViewFechas}
            {usuarioAsiste && usuarioParticipaFecha && !finalizada && ViewFechasSimple}
            {!usuarioAsiste && !finalizada && ViewFechasSimple}
            {finalizada && ViewFechasSimple}

          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={() => { cleanFechas(); handleCloseFecha(); }}>
              Cerar
            </Button>
            <Button
              variant="primary"
              onClick={() => {
                if (usuarioParticipaFecha || !usuarioAsiste || finalizada) handleCloseFecha();
                else acceptDateChanges();
              }}
            >

              Aceptar
            </Button>
          </Modal.Footer>
        </Modal>

        <Modal show={showAlertaPlace} onHide={handleCloseAlertaPlace}>
          <Modal.Header closeButton>
            <Modal.Title>Fechas propuestas</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            Si aceptas se guardarán las propuestas y no podrás realizar ningún cambio

          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={() => { handleCloseAlertaPlace(); }}>
              Cerar
            </Button>
            <Button variant="primary" onClick={() => { handleCloseAlertaPlace(); handleCloseLugar(); acceptPlaceChanges(); }}>
              Acepto las propuestas
            </Button>
          </Modal.Footer>
        </Modal>

        <Modal show={showAlertaPlace} onHide={handleCloseAlertaPlace}>
          <Modal.Header closeButton>
            <Modal.Title>Fechas propuestas</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            Si aceptas se guardarán las propuestas y no podrás realizar ningún cambio

          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={() => { handleCloseAlertaPlace(); }}>
              Cerar
            </Button>
            <Button variant="primary" onClick={() => { handleCloseAlertaPlace(); handleCloseLugar(); acceptPlaceChanges(); }}>
              Acepto las propuestas
            </Button>
          </Modal.Footer>
        </Modal>


      </>
      )}
    </div>

  );
};
export default Actividad;

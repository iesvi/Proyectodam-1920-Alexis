import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Preview from '../Actividad/Preview';

const MyActivities = () => {
  const [charged, setCharged] = useState(false);
  const [creador] = useState([]);
  const [asiste] = useState([]);
  const [invitaciones] = useState([]);
  const [apiUrl] = useState('http://54.163.97.108:8085/activity');
  const [userEmail] = useState(localStorage.getItem('userMail'));
  const [userName] = useState(localStorage.getItem('userName'));
  let id = 0;

  useEffect(() => {
    // Actividades creadas por el usuario
    axios.get(`${apiUrl}/creator/${userEmail}`).then(
      (response) => {
        response.data.forEach((element) => {
          creador.push(
            <td className="col mb-5" key={id++}>
              <Preview
                key={id++}
                id={element.id}
                image={element.imagen}
                descripcion={element.descripcion}
                titulo={element.titulo}
              />
            </td>,
          );
        });
      },
    ).then(

      // Actividades a las que asiste el usuario
      axios.get(`${apiUrl}/assists/${userEmail}`).then(
        (response) => {
          response.data.forEach((element) => {
            asiste.push(
              <td className="col mb-5" key={id++}>

                <Preview
                  key={id++}
                  id={element.id}
                  image={element.imagen}
                  descripcion={element.descripcion}
                  titulo={element.titulo}
                />
              </td>,
            );
          });
        },
      ).then(

        // Actividades con invitación para el usuario


        axios.get(`${apiUrl}/invited/${userName}`).then(
          (response) => {
            response.data.forEach((element) => {
              invitaciones.push(
                <td className="col mb-5" key={id++}>
                  <Preview
                    key={id++}
                    id={element.id}
                    image={element.imagen}
                    descripcion={element.descripcion}
                    titulo={element.titulo}
                  />
                </td>,
              );
            });
          },
        ).then(() => {
          setCharged(true);
        }),
      ),
    );
  },
  []);

  return (
    <div className="container px-5 pb-5 mt-5">
      <h1>Creadas por mí...</h1>
      <br />
      <div className="container px-4 pb-5 mt-4">

        <table className="container">
          <tbody>
            {charged
         && (
         <tr className="row row-eq-height">
           {creador}
         </tr>
         )}
          </tbody>
        </table>
      </div>

      <h1>Asistiré...</h1>
      <br />
      <div className="container px-4 pb-5 mt-4">

        <table className="container">
          <tbody>
            {charged
         && (
         <tr className="row row-eq-height">
           {asiste}
         </tr>
         )}
          </tbody>
        </table>
      </div>


      <h1>Invitaciones...</h1>
      <br />
      <div className="container px-4 pb-5 mt-4">

        <table className="container">
          <tbody>
            {charged
         && (
         <tr className="row row-eq-height">
           {invitaciones}
         </tr>
         )}
          </tbody>
        </table>
      </div>


    </div>

  );
};
export default MyActivities;

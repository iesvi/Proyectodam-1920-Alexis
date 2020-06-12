import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Preview from './Preview';


const Lista = () => {
  const [charged, setCharged] = useState(false);
  const [lista1] = useState([]);
  const [apiUrl] = useState('http://54.163.97.108:8085/activity/');

  useEffect(() => {
    axios.get(`${apiUrl}${window.location.pathname.substring(8, window.location.pathname.length)}`).then(
      (response) => {
        for (let i = 0; i < response.data.length; i += 1) {
          lista1.push(
            <td className="col mb-5">
              <Preview
                id={response.data[i].id}
                image={response.data[i].imagen}
                descripcion={response.data[i].descripcion}
                titulo={response.data[i].titulo}
              />

            </td>,
          );
        }
        setCharged(true);
      },
    );
  }, []);

  return (
    <div className="container px-5 pb-5 mt-5">
      <h1>Hecha un vistazo a estas actividades...</h1>
      <br />
      <br />
      <br />

      <div className="container px-4 pb-5 mt-5">

        <table className="container">
          {charged
          && (
            <tr className="row row-eq-height">
              {lista1}
            </tr>
          )}
        </table>
      </div>
    </div>

  );
};


export default Lista;

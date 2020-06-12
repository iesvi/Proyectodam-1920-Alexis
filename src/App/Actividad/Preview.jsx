import React, { useState } from 'react';
import './Style.css';
import { Link } from 'react-router-dom';


// eslint-disable-next-line react/prop-types
const Preview = ({
  titulo, image, descripcion, id,
}) => {
  const [imgNotFound] = useState('https://us.123rf.com/450wm/pavelstasevich/pavelstasevich1811/pavelstasevich181101065/112815953-stock-vector-no-image-available-icon-flat-vector.jpg?ver=6');
  return (
    <Link to={{ pathname: `/actividad/${id}` }} className="btn btn-link-dark text-uppercase stretched-link">
      <div className="preview shadow-sm border rounded" style={{ width: '30vh' }}>

        <div>
          <img className="border border-bottom shadow" width="100%" height="140vh" src={image !== undefined ? image : imgNotFound} alt="Actividad" />
        </div>

        <div className="px-2 py-2" style={{ height: '20vh', overflow: 'hidden' }}>
          <h4 className="truncado1">
            {titulo}
          </h4>
          <p className="truncado2 px-2">{descripcion}</p>
        </div>


      </div>
    </Link>

  );
};
export default Preview;

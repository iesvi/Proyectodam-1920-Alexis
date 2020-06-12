import React from 'react';

const ShowLugar = ({
  votos, lugar,
}) => (
  <div className="pr-3 col-md-11 pt-3 px-0 m-0">
    <div className="fondoblanco btn-lg pl ml-0 pr-0 mb-3  d-flex flex-column shadow-sm" style={{ height: '22vh' }}>
      <span className="mr-3" align="center">LUGAR</span>


      {/* BUSCADOR DE LUGARES */}
      <div className="mt-2 rounded ml-1">
        <input className="input-lg pb-0" readOnly type="text" value={lugar} />
      </div>

      <span className="ml-2">
        {`Votos:  ${votos}`}
      </span>


    </div>

  </div>
);
export default ShowLugar;

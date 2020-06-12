import React, { useState } from 'react';
import { GoogleComponent } from 'react-google-location';
import ReactTooltip from 'react-tooltip';

const Lugar = ({ setLugarPropuesto }) => {
  const [lugar, setLugar] = useState();

  return (
    <div className="pr-3 col-md-11 pt-3 px-0 m-0">
      <div className="fondoblanco btn-lg pl ml-0 pr-0 mb-3  d-flex flex-column shadow-sm" style={{ height: '20vh' }}>
        <span className="mr-3" align="center">LUGAR</span>


        {/* BUSCADOR DE LUGARES */}
        <ReactTooltip />
        <GoogleComponent
          apiKey="AIzaSyBUsT9SDVauKU5uQGXoXSIh2-YMY7jEbXE"
          language="es"
          country="country:es"
          coordinates
          value={lugar}
          onChange={(e) => { setLugar(e.place); setLugarPropuesto(e.place); }}
        />

        <br />
        <ReactTooltip />
      </div>

    </div>
  );
};
export default Lugar;

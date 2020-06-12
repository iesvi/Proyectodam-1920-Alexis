import React, { useState } from 'react';
import { GoogleComponent } from 'react-google-location';
import ReactTooltip from 'react-tooltip';

const Lugar = ({
  addLugar, removeLugar,
}) => {
  const [lugar, setLugar] = useState();

  return (
    <div className="pr-3 col-md-11 pt-3 px-0 m-0">
      <div className="fondoblanco btn-lg pl ml-0 pr-0 mb-3  d-flex flex-column shadow-sm" style={{ height: '20vh' }}>
        <span className="mr-3" align="center">LUGAR</span>

        <button
          type="button"
          onClick={() => { removeLugar(); }}
          className="botonRedondoUp btn rounded-pill btn-danger btn-lg"
          data-toggle="tooltip"
          data-placement="right"
          title="Eliminar ultimo lugar"
        >

          <i className="fa fa-minus" />
        </button>

        {/* BUSCADOR DE LUGARES */}
        <span className="pt-1" data-tip="Pulsa agregar para guardar el lugar">
          <ReactTooltip />
          <GoogleComponent
            apiKey="AIzaSyBUsT9SDVauKU5uQGXoXSIh2-YMY7jEbXE"
            language="es"
            country="country:es"
            coordinates
            value={lugar}
            onChange={(e) => { setLugar(e.place); }}
          />

        </span>

        <button
          type="button"
          onClick={() => { addLugar(lugar); }}
          className="botonRedondo btn rounded-pill btn-info btn-lg"
          data-toggle="tooltip"
          data-placement="right"
          title="Agregar lugar"
        >

          <i className="fa fa-plus" />
        </button>
        <br />

        <ReactTooltip />
      </div>

    </div>
  );
};
export default Lugar;

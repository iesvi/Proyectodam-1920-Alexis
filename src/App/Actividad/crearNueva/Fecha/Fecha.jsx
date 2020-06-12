import React, { useState, useEffect } from 'react';
import 'react-datepicker/dist/react-datepicker.css';
import DatePicker, { registerLocale } from 'react-datepicker';
import es from 'date-fns/locale/es';
import '../../Style.css';

registerLocale('es', es);


const Fecha = ({
  fecha, addFecha, removeFecha, title,
}) => {
  const [startDate, setStartDate] = useState();


  return (

    <div className="d-flex col-md-11  pt-3 p-0 m-0">
      <div className="fondoblanco btn-lg  mb-3 pr-0 d-flex flex-column shadow-sm" style={{ width: '95%', height: '20vh', zIndex: 2 }}>


        <button
          type="button"
          onClick={() => { removeFecha(); }}
          className="botonRedondoUp btn rounded-pill btn-danger btn-lg"
          data-toggle="tooltip"
          data-placement="right"
          title="Eliminar ultima fecha"
        >

          <i className="fa fa-minus" />
        </button>

        <span className="mr-3" align="center">{title !== undefined ? title : 'FECHA'}</span>
        <DatePicker
          locale="es"
          minDate={new Date()}
          selected={startDate}
          onChange={(date) => { setStartDate(date); }}
          showTimeSelect
          timeFormat="HH:mm aa"
          timeIntervals={15}
          timeCaption="Hora"
          dateFormat="dd-MMMM-yyyy HH:mm aa"
        />

        <button
          type="button"
          onClick={() => { addFecha(startDate); setStartDate(); }}
          className="botonRedondo btn rounded-pill btn-info btn-lg"
          data-toggle="tooltip"
          data-placement="right"
          title="Agregar nueva fecha"
        >

          <i className="fa fa-plus" />
        </button>
        <br />
      </div>
    </div>

  );
};

export default Fecha;

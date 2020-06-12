import React, { useState } from 'react';
import 'react-datepicker/dist/react-datepicker.css';
import DatePicker, { registerLocale } from 'react-datepicker';
import es from 'date-fns/locale/es';

registerLocale('es', es);


const FechaAdd = ({
  fecha,
}) => {
  // COMPONENTE PARA MOSTRAR UNA FECHA AL AGREGARLA
  const [startDate] = useState(fecha);

  return (

    <div className="d-flex col-md-11  pt-3 p-0 m-0">
      <div className="fondoblanco btn-lg  mb-3 pr-0 d-flex flex-column shadow-sm" style={{ width: '95%', height: '20vh' }}>


        <span className="mr-3" align="center">FECHA</span>
        <DatePicker
          className="e"
          locale="es"
          selected={startDate}
          showTimeSelect
          timeFormat="HH:mm"
          timeIntervals={15}
          timeCaption="Hora"
          dateFormat="MMMM d, yyyy h:mm aa"
        />

        <br />
      </div>
    </div>

  );
};

export default FechaAdd;

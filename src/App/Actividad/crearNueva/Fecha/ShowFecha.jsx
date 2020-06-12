import React from 'react';
import 'react-datepicker/dist/react-datepicker.css';
import DatePicker, { registerLocale } from 'react-datepicker';
import es from 'date-fns/locale/es';
import '../../Style.css';


registerLocale('es', es);


const ShowFecha = ({
  startDate, votos,
}) => (

  // COMPONENTE PARA MOSTRAR UNA FECHA Y SUS VOTOS

  <div className="d-flex col-md-11 mb-3 pt-3 p-0 m-0">
    <div
      className="fondoblanco btn-lg  mb-3 pr-0 d-flex flex-column shadow-sm"
      style={{
        position: 'relative', width: '95%', height: '20vh',
      }}
    >


      <div className="d-flex flex-column">
        <DatePicker
          locale="es"
          minDate={new Date()}
          selected={startDate}
          showTimeSelect
          timeFormat="HH:mm aa"
          timeIntervals={15}
          timeCaption="Hora"
          dateFormat="dd-MMMM-yyyy HH:mm aa"
        />

        <span className="ml-2">
          {`Votos:  ${votos}`}
        </span>
      </div>


      <br />
    </div>
  </div>

);
export default ShowFecha;

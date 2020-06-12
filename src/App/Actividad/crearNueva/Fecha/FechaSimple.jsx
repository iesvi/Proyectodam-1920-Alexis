import React, { useState, useEffect } from 'react';
import 'react-datepicker/dist/react-datepicker.css';
import DatePicker, { registerLocale } from 'react-datepicker';
import es from 'date-fns/locale/es';
import '../../Style.css';
import ReactTooltip from 'react-tooltip';

registerLocale('es', es);


const FechaSimple = ({
  title, setFechaPropuesta, horas,
}) => {
  // COMPONENTE PARA QUE UN USUARIO PUEDA ELEGIRA UNA ÚNICA FECHA
  const [startDate, setStartDate] = useState();
  const [timer, setTimer] = useState(horas !== undefined ? horas : true);

  return (

    <div className="d-flex col-md-11 pt-3 p-0 m-0">
      <div className="fondoblanco btn-lg  mb-3 pr-0 d-flex flex-column shadow-sm" style={{ width: '95%', height: '20vh', zIndex: 2 }}>


        <span className="mr-3" data-tip="Establece una fecha límite para que los asistentes realizen las propuestas o votaciones." align="center">{title !== undefined ? title : 'FECHA'}</span>
        <DatePicker
          locale="es"
          minDate={new Date()}
          selected={startDate}
          onChange={(date) => { setStartDate(date); setFechaPropuesta(date); }}
          showTimeSelect={timer}
          timeFormat="HH:mm aa"
          timeIntervals={15}
          timeCaption="Hora"
          dateFormat={timer ? 'dd-MMMM-yyyy HH:mm aa' : 'dd-MMMM-yyyy'}
        />
        <ReactTooltip />
        <br />
      </div>
    </div>

  );
};

export default FechaSimple;

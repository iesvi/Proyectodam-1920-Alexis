import React, { useState, useEffect } from 'react';
import 'react-datepicker/dist/react-datepicker.css';
import DatePicker, { registerLocale } from 'react-datepicker';
import es from 'date-fns/locale/es';
import '../../Style.css';


registerLocale('es', es);


const VoteFecha = ({
  startDate, votos, addVote, indice, removeVote,
}) => {
  // ESTE COMPONENTE SE USA PARA QUE LOS USUARIOS VOTEN UNA FECHA Y SIN PODER MODIFICARLA
  const [vote, setVote] = useState(false);
  const [date, setDate] = useState(startDate);
  const [thisVotos, setThisVotos] = useState(votos);


  return (

    <div className="d-flex col-md-11 mb-3 pt-3 p-0 m-0">
      <div
        className="fondoblanco btn-lg  mb-3 pr-0 d-flex flex-column shadow-sm"
        style={{
          position: 'relative', width: '95%', height: '20vh',
        }}
      >


        <button
          hidden={!vote}
          type="button"
          onClick={() => { setVote(false); removeVote(indice); setThisVotos(thisVotos - 1); }}
          className="botonRedondoUp btn rounded-pill btn-danger btn-lg"
          data-toggle="tooltip"
          data-placement="right"
          title="Quitar voto"
        >

          <i className="fa fa-times" />
        </button>

        <div className="d-flex flex-column">
          <DatePicker
            locale="es"
            minDate={new Date()}
            selected={date}
            showTimeSelect
            timeFormat="HH:mm aa"
            timeIntervals={15}
            timeCaption="Hora"
            dateFormat="dd-MMMM-yyyy HH:mm aa"
          />

          <span className="ml-2">
            {`Votos:  ${thisVotos}`}
          </span>
        </div>

        <button
          type="button"
          hidden={vote}
          onClick={() => { setVote(true); addVote(indice); setThisVotos(thisVotos + 1); }}
          className="botonRedondo btn rounded-pill btn-success btn-lg"
          data-toggle="tooltip"
          data-placement="right"
          title="Votar esta fecha"
        >

          <i className="fa fa-check" />
        </button>
        <br />
      </div>
    </div>

  );
};

export default VoteFecha;

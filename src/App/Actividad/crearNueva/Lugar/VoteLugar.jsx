import React, { useState } from 'react';

const VoteLugar = ({
  addVote, removeVote, indice, votos, lugar,
}) => {
  const [vote, setVote] = useState(false);
  const [thisVotos, setThisVotos] = useState(votos);

  return (
    <div className="pr-3 col-md-11 pt-3 px-0 m-0">
      <div className="fondoblanco btn-lg pl ml-0 pr-0 mb-3  d-flex flex-column shadow-sm" style={{ height: '22vh' }}>
        <span className="mr-3" align="center">LUGAR</span>

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

        {/* BUSCADOR DE LUGARES */}
        <div className="mt-2 rounded ml-1">
          <input className="input-lg pb-0" readOnly type="text" value={lugar} />
        </div>

        <span className="ml-2">
          {`Votos:  ${thisVotos}`}
        </span>

        <button
          type="button"
          hidden={vote}
          onClick={() => { setVote(true); addVote(indice); setThisVotos(thisVotos + 1); }}
          className="botonRedondo btn rounded-pill btn-success btn-lg"
          data-toggle="tooltip"
          data-placement="right"
          title="Votar este lugar"
        >

          <i className="fa fa-plus" />
        </button>
      </div>

    </div>
  );
};
export default VoteLugar;

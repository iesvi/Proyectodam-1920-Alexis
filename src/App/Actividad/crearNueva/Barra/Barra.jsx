import React from 'react';
import ToggleButton from 'react-toggle-button';
import ReactTooltip from 'react-tooltip';

const Barra = ({
  publica, setPublica, participativa, setParticipativa, addUser,
}) => (

  <td className="col-md-11 ml-5 mt-4 fondoblanco mb-3 rounded shadow-sm">
    <div className="d-flex flex-row  rounded my-2 py-2 mx-1 shadow">
      <div className="mr-auto d-flex mx-4">
        <span className="mx-2">Pública</span>
        <ToggleButton
          inactiveLabel="No"
          activeLabel="Si"
          value={publica || false}
          onToggle={(value) => {
            setPublica(!value);
          }}

          colors={{
            activeThumb: {
              base: 'rgb(250,250,250)',
            },
            inactiveThumb: {
              base: 'rgb(62,130,247)',
            },
            active: {
              base: 'rgb(213,58,58)',
              hover: 'rgb(235,18,18)',
            },
            inactive: {
              base: 'rgb(65,66,68)',
              hover: 'rgb(95,96,98)',
            },
          }}
        />
      </div>
      {!publica

      && (
        <button
          className="btn btn-link py-0 my-0"
          type="button"
          data-tip="Invita usuarios a tu actividad privada para que puedan apuntarse"
          onClick={addUser}
        >
          <ReactTooltip />
          <i
            className="fa fa-user-plus"
            style={{ fontSize: '20px' }}
          />
        </button>
      )}

      <div className="d-flex mx-5">
        <span className="mx-2">Participativa</span>
        <span className="pt-1" data-tip="Las actividades participativas están limitadas a 4 fechas o lugares por usuario.">
          <ReactTooltip />
          <ToggleButton
            locale="es"
            inactiveLabel="No"
            activeLabel="Si"
            value={participativa || false}
            onToggle={() => {
              setParticipativa();
            }}

            colors={{
              activeThumb: {
                base: 'rgb(250,250,250)',
              },
              inactiveThumb: {
                base: 'rgb(62,130,247)',
              },
              active: {
                base: 'rgb(213,58,58)',
                hover: 'rgb(235,18,18)',
              },
              inactive: {
                base: 'rgb(65,66,68)',
                hover: 'rgb(95,96,98)',
              },
            }}
          />
        </span>
      </div>
    </div>
  </td>


);
export default Barra;

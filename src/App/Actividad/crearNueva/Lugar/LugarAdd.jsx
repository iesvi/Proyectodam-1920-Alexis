import React, { useState } from 'react';

const LugarAdd = ({
  lugar,
}) => {
  const [thisLugar] = useState(lugar);
  return (
    <div className="pr-3 col-md-11 pt-3 px-0 m-0">
      <div className="fondoblanco btn-lg ml-0 mb-3 mr-0 pr-0 d-flex flex-column shadow-sm" style={{ height: '20vh' }}>
        <span className="mr-3" align="center">LUGAR</span>
        <div className="mt-2 rounded ml-1">
          <input className="input-lg pb-0" readOnly type="text" value={thisLugar} />
        </div>
      </div>

    </div>
  );
};
export default LugarAdd;

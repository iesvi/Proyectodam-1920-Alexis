import React, { useState } from 'react';


const UserItem = ({ name, removeMe }) => {
  const [user] = useState(name);

  return (
    <div className="d-flex flex-column ml-auto">
      <div className="d-flex flex-row">

        <i className="fa fa-user-circle" style={{ fontSize: '50px' }} />
        <button type="button" onClick={() => { removeMe(user); }} className="btn btn-danger ml-3 mt-1" style={{ width: '6vh', height: '6vh' }}>
          <i className="fa fa-times" />
        </button>
      </div>
      <div className="ml-2">
        {user}
      </div>
    </div>

  );
};
export default UserItem;

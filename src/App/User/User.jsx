import React from 'react';


const User = ({ name }) => (
  <div className="d-flex flex-column">
    <i className="fa fa-user-circle" style={{ fontSize: '30px' }} />
    {name}
  </div>

);
export default User;

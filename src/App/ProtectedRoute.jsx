import React from 'react';
import { Route, Redirect } from 'react-router-dom';

const ProtectedRoute = ({
  component: Component, logged, mail, user, goToActivities, ...rest
}) => (
  <Route
    {...rest}
    render={({ ...props }) => (
      logged === 'true'
        ? <Component mail={mail} user={user} goToActivities={goToActivities} />
        : <Redirect to="/login" />
    )}
  />
);
export default ProtectedRoute;

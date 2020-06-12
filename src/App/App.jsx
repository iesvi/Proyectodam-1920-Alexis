import React, { useState } from 'react';
import { Router, Route } from 'react-router-dom';
import axios from 'axios';
import { ToastsContainer, ToastsStore, ToastsContainerPosition } from 'react-toasts';
import TopBar from './TopBar';
import Actividad, { Lista, Nueva } from './Actividad';
import Login from './Login';
import Regist from './Signup';
import ProtectedRoute from './ProtectedRoute';
import history from '../history';
import MyActivities from './MyActivities';


const App = () => {
  const [logged, setLogged] = useState(localStorage.getItem('logged'));
  const [user, setUser] = useState();
  const [userMail, setUserMail] = useState(localStorage.getItem('userMail'));
  const [search, setSearch] = useState('');


  const logInUser = (userName, mensaje) => {
    localStorage.setItem('logged', 'true');
    setLogged('true');
    setUser(userName);

    ToastsStore.success(mensaje);

    axios.get(`http://54.163.97.108	:8085/login/${userName}`).then(
      (response) => {
        localStorage.setItem('userMail', response.data.email);
        localStorage.setItem('userName', userName);
        setUserMail(response.data.email);
        history.push('/myActivities');
      },
    );
  };

  const browser = (e) => {
    history.push(`/search=${e}`);
    setSearch(e);
  };

  const goToMyActivity = () => {
    history.push('/myActivities');
  };


  return (
    <Router history={history}>

      <TopBar browser={browser} userName={user} />
      <ProtectedRoute path="/newActivity" component={Nueva} logged={logged} mail={userMail} goToActivities={goToMyActivity} />
      <ProtectedRoute path="/myActivities" component={MyActivities} logged={logged} mail={userMail} user={user} />
      <Route path="/login" render={() => <Login logInUser={logInUser} />} />
      <Route path="/regist" render={() => <Regist logInUser={logInUser} />} />
      <Route exact path="/" render={() => <Lista />} />
      <Route exact path="/search=:search" render={() => <Lista search={search} />} />
      <Route exact path="/actividad/:id/" render={() => <Actividad goToActivities={goToMyActivity} />} />

      <ToastsContainer position={ToastsContainerPosition.TOP_CENTER} store={ToastsStore} />

    </Router>
  );
};
export default App;

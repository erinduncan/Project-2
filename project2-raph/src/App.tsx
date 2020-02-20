import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Provider } from 'react-redux';
import { Switch, Route, Router } from 'react-router';
// import './App.css';
import './css/Main.css'
import { store } from './Store';
import LoginComponent from './components/login-component/LoginContainer';
import PostComponent from './components/post-component/PostContainer';
// import { BrowserRouter as Router } from 'react-router-dom';
import CreateUserComponent from './components/create-user-component/CreateUserContainer';
import { MainPageComponent } from "./components/main-page-component/MainPageComponent";
import { history } from './utility/history'; 

const App: React.FC = () => {
  return (
    <div className="App">
      <Provider store={store}>
        <Router history = { history }>
          <Switch>
            <Route path='/post' component={PostComponent}/>
            <Route path='/login' component={LoginComponent} />
            <Route path='/register' component={CreateUserComponent}/>
            <Route path='/' component={MainPageComponent} />
          </Switch>
        </Router>
      </Provider>

    </div>
  );
}

export default App;
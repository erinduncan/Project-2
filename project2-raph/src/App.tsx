import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Provider } from 'react-redux';
import { Switch, Route } from 'react-router';
import './App.css';
import { store } from './Store';
import LoginComponent from './components/login-component/LoginContainer';
import PostComponent from './components/post-component/PostContainer';
import { BrowserRouter as Router } from 'react-router-dom';

//this is the root of all the components that we will make
//two rules to being a component
//1 start with a capital letter
//2 return some jsx/tsx that has one root tag
const App: React.FC = () => {
  return (
    <div className="App">
      {/* This is a component that makes it so all 
      of its children can get access to the store */}
      <Provider store={store}>

        {/* to use react router, there is one base tag all routes must be contained in
      that tag is a component called Router */}
        <Router>
          {/* <NavbarComponent /> */}
          {/* With router we will always pass in three objects as props
        history, match, location */}
          {/* inside of a router we are going to have routes
        routes by default will match inclusively
        /clicker that would match '/' '/c' '/cl' '/cli' ... */}
          <Switch>
            {/* What the switch does is allow only a single 
            route inside to be rendered at one time */}
            <Route path='/post' component={PostComponent}/>
            <Route path='/login' component={LoginComponent} />
            {/* the syntax for a component with props, 
            is to use the render property with an 
            arrow function and the component with its props */}
            {/* <Route path='/props' render={() => <PropComponent name={'Alec'} color={'grey'} />} /> */}
            <Route path='/' component={LoginComponent} />
          </Switch>
        </Router>
      </Provider>

    </div>
  );
}

export default App;

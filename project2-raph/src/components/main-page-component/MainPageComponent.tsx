import React from "react";
import "../../css/Main.css";
import "bootstrap/dist/css/bootstrap.css";
import { NavLink } from "react-router-dom";

export const MainPageComponent: React.FC<any> = (props: any) => {
  return (
    <div className="mainButtons">
      <header>
        <div className="headerImage">
          <nav>
            <ul className="linkElements">
              <li>
                <NavLink
                  className="btn btn-dark"
                  to={{
                    pathname: "/login"
                  }}
                >
                  Login
                </NavLink>
              </li>

              <li>
                <NavLink
                  className="btn btn-dark"
                  to={{
                    pathname: "/register"
                  }}
                >
                  Register
                </NavLink>
              </li>
            </ul>
          </nav>
          </div>
      </header>
      
      <footer>
      <section id="about">
        <div className="content">
            
          <h4>About us</h4>
          <p>
            We are a community of pet-lovers providing an environment for the
            sport and lifestyle that is spotting animals. Create an
            account today to join in on the fun of spotting, rating, and loving
            pets!
          </p>
        </div>
      </section>
      </footer>
    </div>
    
  );
};

export default MainPageComponent;

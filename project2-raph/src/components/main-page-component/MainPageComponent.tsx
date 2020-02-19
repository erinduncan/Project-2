import React from "react";
import "../../css/Main.css";
import "bootstrap/dist/css/bootstrap.css";
import { NavLink } from "react-router-dom";
import CoolCat from "../../assets/tedward.jpeg";
import CoolDog from "../../assets/CoolDog.png";

export const MainPageComponent: React.FC<any> = (props: any) => {
  return (
    <div className="mainContainer">
      <header>
        <div className="headerBg">
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
        </div>
      </header>

      <div className="postContainer">
        <br />
        <h1>This is a sample post!</h1>
        <br />
        <img src={CoolCat} />
        <br/>
        <br/>
        <p>
          This is my best friend Ted whom I love, and this div exists for the
          sole purpose of being a placeholder!
        </p>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>

        <p>Here are some great break tags to show that the CSS actually works and this bitch can scroll.</p>
      </div>

      <div className="leftContainer">
          <img src={CoolDog}/>
          <h4>About us</h4>
            <p>
              We are a community of pet-lovers providing an environment for the
              sport and lifestyle that is spotting animals. Create an account
              today to join in on the fun of spotting, rating, and loving pets!
            </p>
      </div>

      <footer>
        <section id="about">
          <div className="content">
            
          </div>
        </section>
      </footer>
    </div>
  );
};

export default MainPageComponent;

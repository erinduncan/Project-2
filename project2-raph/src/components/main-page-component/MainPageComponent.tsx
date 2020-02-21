import React from "react";
import "../../css/Main.css";
import "bootstrap/dist/css/bootstrap.css";
import { NavLink, Link } from "react-router-dom";
import CoolCat from "../../assets/tedward.jpeg";
import CoolDog from "../../assets/CoolDog.png";
import { UserDisplayComponent } from "../user-component/UserDisplayComponent";
import { PostDisplayComponent } from "../post-component/post-display-component/PostDisplayComponent";

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
                    className="btn btn-outline-secondary"
                    to={{
                      pathname: "/login"
                    }}
                  >
                    Login
                  </NavLink>
                </li>

                <li>
                  <NavLink
                    className="btn btn-outline-secondary"
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
        {/* <br />
        <h1>This is a sample post!</h1>
        <hr />
        <img src={CoolCat} alt="Best Ted" />
        <hr className="new" />
        <p>
          This is my best friend Ted whom I love, and this div exists for the
          sole purpose of being a placeholder!
        </p>
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />
        <br />

        <p>
          Here are some great break tags to show that the CSS actually works and
          this bitch can scroll.
        </p> */}
        {PostDisplayComponent}
      </div>

      <div className="leftContainer">
        <img src={CoolDog} alt="A Cool Dog" />
        <h4>About us</h4>
        <hr />
        <p>
          We are a community of pet-lovers providing an environment for the
          sport and lifestyle that is spotting animals. Create an account today
          to join in on the fun of spotting, rating, and loving pets!
        </p>
        {/* <div className="content">Spot! © 2020</div> */}
      </div>

      <div className="searchContainer">
        <input className="searchBar" type="text" placeholder="Search..." />
      </div>

      <div className="displayComponent">{UserDisplayComponent}</div>

      <footer>
        <section id="about">
          <div className="content"></div>
        </section>
      </footer>
    </div>
  );
};

export default MainPageComponent;

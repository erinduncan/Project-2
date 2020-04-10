import React, { SyntheticEvent } from "react";
import IUser from "../../model/IUser";
import "../../css/Main.css";
import { Link } from "react-router-dom";
import { sendEmail } from "../../remote/api-clients/api";
import { Form, Input, Button } from "reactstrap";

export interface IEmailState {
  email: string;
}

export class EmailComponent extends React.Component<any, IEmailState> {
  constructor(props: any) {
    super(props);
    this.state = {
      email: ""
    };
  }

  updateEmail = (event: any) => {
    this.setState({
      ...this.state,
      email: event.target.value
    });
  };

  recover = async (event: SyntheticEvent) => {
    event.preventDefault();
    let user: IUser = {
      userId: 0,
      email: this.state.email,
      password: "",
      firstName: "",
      lastName: "",
      handle: ""
    };
    sendEmail(user);
  };

  render() {
    return (
      <>
        <div className="mainContainer">
          <div className="headerBg">
            <div className="headerImage">
              <nav>
                <ul className="linkElements">
                  <li>
                    <Link className="btn btn-outline-secondary" to="/">
                      Home
                    </Link>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
        
        <div className="emailComponent">
          <Form onSubmit={this.recover}>
            <Input
              type="text"
              onChange={this.updateEmail}
              placeholder="Enter email to recover password."
            />
            <br/>
            <Button color="btn btn-outline-secondary" type="submit">
              Submit
            </Button>
          </Form>
        </div>
      </>
    );
  }
}

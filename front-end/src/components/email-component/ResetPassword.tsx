import React, { SyntheticEvent } from "react";
import { Form, Input } from "reactstrap";
import { resetPassword } from "../../remote/api-clients/api";
import IUser from "../../model/IUser";
import { Link } from "react-router-dom";

interface IPasswordState {
  email: string;
  password: string;
}

export class ResetPasswordComponent extends React.Component<
  any,
  IPasswordState
> {
  constructor(props: any) {
    super(props);
    this.state = {
      email: "",
      password: ""
    };
  }

  updateEmail = (event: any) => {
    this.setState({
      ...this.state,
      email: event.target.value
    });
  };

  updatePassword = (event: any) => {
    this.setState({
      ...this.state,
      password: event.target.value
    });
  };

  resetPassword = async (event: SyntheticEvent) => {
    event.preventDefault();
    let user: IUser = {
      userId: 0,
      email: this.state.email,
      password: this.state.password,
      firstName: "",
      lastName: "",
      handle: ""
    };
    resetPassword(user);
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
                    <Link className="btn btn-outline-secondary" to="/login">
                      Login
                    </Link>
                  </li>
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
        <Form className="emailComponent" onSubmit={this.resetPassword}>
          <Input type="text" onChange={this.updateEmail} placeholder="email">
            Email
          </Input>
          <Input
            type="password"
            onChange={this.updatePassword}
            placeholder="password"
          >
            New Password
          </Input>
          <Input type="submit">Submit new password</Input>
        </Form>
      </>
    );
  }
}

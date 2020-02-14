import React from "react";
import { Form, FormGroup, Button, Label, Col, Input } from "reactstrap";

interface ILoginComponentProps {
  login?: (email: string, password: string) => any;
  signupPage?: () => any;
  classes?: any;
  translate?: (state: any, param?: {}) => any;
}

interface ILoginComponentState {
  [key: string]: any;
  email: string;
  emailError: string;
  password: string;
  passwordError: string;
  confirmError: string;
}

const styles = (theme: any) => ({
  textField: {
    minWidth: 280,
    marginTop: 20
  },
  contain: {
    margin: "0 auto"
  },
  paper: {
    minHeight: 370,
    maxWidth: 450,
    minWidth: 337,
    textAlign: "center",
    display: "block",
    margin: "auto"
  },
  bottomPaper: {
    display: "inherit",
    fontSize: "small",
    marginTop: "50px"
  },
  link: {
    color: "#0095ff",
    display: "inline-block"
  }
});

export class LoginComponent extends React.Component<
  ILoginComponentProps,
  ILoginComponentState
> {
  styles = {
    singinOptions: {
      paddingBottom: 10,
      justifyContent: "space-around",
      display: "flex"
    },
    divider: {
      marginBottom: 10,
      marginTop: 15
    }
  };

  constructor(props: ILoginComponentProps) {
    super(props);
    this.state = {
      email: "",
      emailError: "",
      password: "",
      passwordError: "",
      confirmError: ""
    };
  }

  /**
   * Handles data on input change
   */
  handleInputChange = (event: any) => {
    const target = event.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    this.setState({
      [name]: value
    });

    switch (name) {
      case "emailInput":
        this.setState({
          emailInputError: ""
        });
        break;
      case "passwordInput":
        this.setState({
          confirmInputError: "",
          passwordInputError: ""
        });
        break;
      default:
    }
  };

  render() {
    return (
      <div>
        <Form onSubmit={this.handleInputChange}>
          <FormGroup row>
            <Label for="exampleUsername" sm={2}>
              Email
            </Label>
            <Col sm={10}>
              <Input
                required
                type="email"
                name="email"
                id="exampleUsername"
                placeholder="Enter email here"
                value={this.state.email}
                onChange={this.handleInputChange}
              />
            </Col>
          </FormGroup>
          <FormGroup row>
            <Label for="examplePassword" sm={2}>
              Password
            </Label>
            <Col sm={10}>
              <Input
                required
                type="password"
                name="password"
                id="examplePassword"
                placeholder="Put password here"
                value={this.state.password}
                onChange={this.handleInputChange}
              />
            </Col>
          </FormGroup>
          <Button color="danger">Login</Button>
        </Form>
        <p>{this.state.confirmError}</p>
      </div>
    );
  }
}

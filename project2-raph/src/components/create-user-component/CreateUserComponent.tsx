import React, { useState, SyntheticEvent } from "react";
import {
  Form,
  FormGroup,
  Label,
  Col,
  Input,
  Button,
  Container
} from "reactstrap";
// import IUser from '../../model/IUser';
import { addUser } from "../../remote/api-clients/api";


export const CreateUserComponent: React.FC<any> = (props:any) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [handle, setHandle] = useState("");

  const submitUser = async (event: SyntheticEvent) => {
    event.preventDefault();
  };

  return (
    <React.Fragment>
      <div className="registerDiv">
        <Container className="registerForm">
          <h2>Create an Account</h2>
          <Form onSubmit={()=>addUser({
            userId:0,
            email: email,
            password: password,
            firstName: firstName,
            lastName: lastName,
            handle: handle
          }).then(r=>console.log(r.data))}>
            <FormGroup row>
              <Label for="email" sm={2}>
                Email
              </Label>
              <Col sm={10}>
                <Input
                  required
                  type="email"
                  name="email"
                  id="email"
                  placeholder="Put email here"
                  onChange={val => setEmail(val.target.value)}
                />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Label for="password" sm={2}>
                Password
              </Label>
              <Col sm={10}>
                <Input
                  required
                  type="password"
                  name="password"
                  id="password"
                  placeholder="Put password here"
                  onChange={val => setPassword(val.target.value)}
                />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Label for="firstName" sm={2}>
                First Name
              </Label>
              <Col sm={10}>
                <Input
                  required
                  type="text"
                  name="firstName"
                  id="firstName"
                  placeholder="First Name"
                  onChange={val => setFirstName(val.target.value)}
                />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Label for="lastName" sm={2}>
                Last Name
              </Label>
              <Col sm={10}>
                <Input
                  required
                  type="text"
                  name="lastName"
                  id="lastName"
                  placeholder="Last Name"
                  onChange={val => setLastName(val.target.value)}
                />
              </Col>
            </FormGroup>
            <FormGroup row>
              <Label for="handle" sm={2}>
                Handle
              </Label>
              <Col sm={10}>
                <Input
                  required
                  type="text"
                  name="handle"
                  id="handle"
                  placeholder="This will be your display name on the site."
                  onChange={val => setHandle(val.target.value)}
                />
              </Col>
            </FormGroup>
            <Button color="btn btn-outline-secondary" type="submit">
              Submit
            </Button>
          </Form>
        </Container>
      </div>
    </React.Fragment>
  );
};

import React, { useState, SyntheticEvent } from 'react';
import { Form, FormGroup, Label, Col, Input, Button } from 'reactstrap';

export const CreateUser:React.FC<any> = (props:any) =>{
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');

    let submitLogin = async (event: SyntheticEvent) => {
        event.preventDefault()
    }

    return(
        <div>
                <Form onSubmit={submitLogin}>
                    <FormGroup row>
                        <Label for="email" sm={2}>Email</Label>
                        <Col sm={10}>
                            <Input required
                                type="email"
                                name="email"
                                id="email"
                                placeholder="put email here"
                                onChange={val=>setEmail(val.target.value)} />
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Label for="password" sm={2}>Password</Label>
                        <Col sm={10}>
                            <Input required
                                type="password"
                                name="password"
                                id="password"
                                placeholder="put password here"
                                onChange={val=>setPassword(val.target.value)} />
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Label for="firstName" sm={2}>First Name</Label>
                        <Col sm={10}>
                            <Input required
                                type="text"
                                name="firstName"
                                id="firstName"
                                placeholder="put firstName here"
                                onChange={val=>setFirstName(val.target.value)} />
                        </Col>
                    </FormGroup>
                    <FormGroup row>
                        <Label for="lastName" sm={2}>Last Name</Label>
                        <Col sm={10}>
                            <Input required
                                type="text"
                                name="lastName"
                                id="lastName"
                                placeholder="put lastName here"
                                onChange={val=>setLastName(val.target.value)} />
                        </Col>
                    </FormGroup>
                    <Input type='submit'>Submit</Input>
                </Form>
            </div>
    )
}
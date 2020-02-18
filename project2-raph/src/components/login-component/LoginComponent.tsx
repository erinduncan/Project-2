import React, { SyntheticEvent, useState } from 'react';
import '../../css/Main.css';
import { Form, Label, Col, Input, FormGroup, Button, Container } from 'reactstrap';
import { Link } from 'react-router-dom';
// import { updateCurrentUser } from '../../action-mappers/login-actions';

interface ILoginProps {
    updateCurrentUser: (e:string, p:string) => void
    loginMessage: string
}

export const Login:React.FC<any> = (props:ILoginProps) => {
    const [username, setusername] = useState('');
    const [password, setpassword] = useState('');

    const submitLogin  = async (event: SyntheticEvent) => {
        event.preventDefault()
        props.updateCurrentUser(username, password)           
    }
    

    return (
        <>
        <Container className="loginForm">
        <h2>Login</h2>
                <Form className="loginForm">
                    <FormGroup row>
                        <Label for="username" sm={2}>Username</Label>
                        <Col sm={10}>
                            <Input required
                                type="text"
                                name="username"
                                id="username"
                                placeholder="put username here"
                                value={username}
                                onChange={val=>setusername(val.target.value)} />
                            {/* this is an example of data binding, 
                            we take data from the state and put it 
                            in our tsx */}
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
                                value={password}
                                onChange={val=>setpassword(val.target.value)}/>
                        </Col>
                    </FormGroup>
                    <Button id="submitButton" color='primary' onClick={submitLogin}>Login</Button>
                </Form>
                <p>{props.loginMessage}</p><br></br>
                <Link to='/register'>No Account?</Link>
                </Container>
            </>
    )
    
}
import React, { SyntheticEvent, useState } from 'react';
import '../../css/Main.css';
import { Form, Label, Col, Input, FormGroup, Button } from 'reactstrap';
import { Link } from 'react-router-dom';

interface ILoginProps {
    updateCurrentUser: (e:string, p:string) => void
    loginMessage: string
}

export const Login:React.FC<any> = (props:ILoginProps) => {
    const [username, setusername] = useState('');
    const [password, setpassword] = useState('');

    const submitLogin  = async (event: any) => {
        event.preventDefault()
        props.updateCurrentUser(username, password)           
    }
    

    return (
        <>
        <div className="loginDiv">
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
                    <Button outline id="submitButton" color='secondary' onClick={submitLogin}>Login</Button>
                </Form>
                <p>{props.loginMessage}</p><br></br>
                <ul className="loginLinks">
              <li><Link to='/register'>No Account?</Link></li><li><Link to='/email'>Forgot Password</Link></li></ul>
                </div>
            </>
    )
    
}
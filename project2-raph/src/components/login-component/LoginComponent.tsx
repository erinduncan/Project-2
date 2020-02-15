import React, { SyntheticEvent } from 'react';
import { Form, Label, Col, Input, FormGroup, Button } from 'reactstrap';
import { Link } from 'react-router-dom';
import { updateCurrentUser } from '../../action-mappers/login-actions';

interface ILoginState {
    email: string
    password: string
    
}

interface ILoginProps {
    updateCurrentUser: (e:string, p:string) => void
    loginMessage: string
}


export class LoginComponent extends React.Component<ILoginProps, ILoginState>{
    constructor(props: any) {
        super(props)
        this.state = {
            email: '',
            password: '',
        }
        //by putting event binding and data binding together, we achieve something called two way data binding
        //this is where the user can update state and if state is updated the user sees the change
    }
    
    //this is an example of event binding
    //we take an event created by a user, and use it to update data in our state
    updateemail = (event: any) => {
        this.setState({
            ...this.state,
            email: event.target.value
        })

    }

    //this is an example of event binding
    //we take an event created by a user, and use it to update data in our state
    updatePassword = (event: any) => {
        this.setState({
            ...this.state,
            password: event.target.value
        })
    }


    submitLogin = async (event: SyntheticEvent) => {
        event.preventDefault()
        updateCurrentUser(this.state.email, this.state.password)           
    }

    render() {
        return (
            <div className='loginDiv'>
                <Form onSubmit={this.submitLogin}>
                    <FormGroup row>
                        <Label for="email" sm={2}>Email</Label>
                        <Col sm={10}>
                            <Input required
                                type="email"
                                name="email"
                                id="email"
                                placeholder="put email here"
                                value={this.state.email}
                                onChange={this.updateemail} />
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
                                value={this.state.password}
                                onChange={this.updatePassword} />
                        </Col>
                    </FormGroup>
                    <Button color="primary">Login</Button>
                </Form>
                <p>{this.props.loginMessage}</p><br/><br/>
                <Link to='/register'>New to Spot</Link>
            </div>
        )
    }
}
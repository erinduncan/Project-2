import React, { SyntheticEvent, useState, useEffect } from 'react';
import { Form, Label, Col, Input, FormGroup, Button } from 'reactstrap';
import { Link } from 'react-router-dom';
import { updateCurrentUser } from '../../action-mappers/login-actions';

// interface ILoginState {
//     username: string
//     password: string
    
// }

interface ILoginProps {
    updateCurrentUser: (e:string, p:string) => void
    loginMessage: string
}


// export class LoginComponent extends React.Component<ILoginProps, ILoginState>{
//     constructor(props: any) {
//         super(props)
//         this.state = {
//             username: '',
//             password: '',
//         }
//         //by putting event binding and data binding together, we achieve something called two way data binding
//         //this is where the user can update state and if state is updated the user sees the change
//     }
    
//     //this is an example of event binding
//     //we take an event created by a user, and use it to update data in our state
//     updateusername = (event: any) => {
//         this.setState({
//             ...this.state,
//             username: event.target.value
//         })

//     }

//     //this is an example of event binding
//     //we take an event created by a user, and use it to update data in our state
//     updatePassword = (event: any) => {
//         this.setState({
//             ...this.state,
//             password: event.target.value
//         })
//     }


//     submitLogin = async (event: SyntheticEvent) => {
//         event.preventDefault()
//         updateCurrentUser(this.state.username, this.state.password)           
//     }

//     render() {
//         return (
//             <div className='loginDiv'>
//                 <Form onSubmit={this.submitLogin}>
//                     <FormGroup row>
//                         <Label for="username" sm={2}>username</Label>
//                         <Col sm={10}>
//                             <Input required
//                                 type="username"
//                                 name="username"
//                                 id="username"
//                                 placeholder="put username here"
//                                 value={this.state.username}
//                                 onChange={this.updateusername} />
//                             {/* this is an example of data binding, 
//                             we take data from the state and put it 
//                             in our tsx */}
//                         </Col>
//                     </FormGroup>
//                     <FormGroup row>
//                         <Label for="password" sm={2}>Password</Label>
//                         <Col sm={10}>
//                             <Input required
//                                 type="password"
//                                 name="password"
//                                 id="password"
//                                 placeholder="put password here"
//                                 value={this.state.password}
//                                 onChange={this.updatePassword} />
//                         </Col>
//                     </FormGroup>
//                     <Input color="primary">Login</Input>
//                 </Form>
//                 <p>{this.props.loginMessage}</p><br></br>
//                 <Link to='/register'>No Account?</Link>
//             </div>
//         )
//     }
// }

export const Login:React.FC<any> = (props:ILoginProps) => {
    const [username, setusername] = useState('');
    const [password, setpassword] = useState('');

    const submitLogin  = async (event: SyntheticEvent) => {
        event.preventDefault()
        props.updateCurrentUser(username, password)           
    }
    

    return (
        <>
                <Form>
                    <FormGroup row>
                        <Label for="username" sm={2}>username</Label>
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
                    <Button color='primary' onClick={submitLogin}>Login</Button>
                </Form>
                <p>{props.loginMessage}</p><br></br>
                <Link to='/register'>No Account?</Link>
            </>
    )
    
}
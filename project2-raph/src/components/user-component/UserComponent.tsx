import React from 'react';
import {UserDisplayComponent} from './UserDisplayComponent'
// import IUser from '../../model/IUser';


export const UserComponent:React.FC<any> = (props:any) =>{
    return(
        <React.Fragment>
            <UserDisplayComponent id={props.id}
                email={props.email}
                password={props.password}
                firstName={props.firstName}
                lastName={props.lastName}
                handle={props.handle}/>
        </React.Fragment>
    )
}
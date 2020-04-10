import IUser from "../model/IUser"
import { addUser } from "../remote/api-clients/api"


export const createTypes = {
    SUCCESSFUL_CREATE: 'CREATE_SUCCESSFUL_CREATE',
    UNSUCCESSFUL_CREATE: 'CREATE_UNSUCCESSFUL_CREATE'
}


export const createUser = (newUser:IUser) => async (dispatch:any) => {
    let response:any = await addUser(newUser);
    if(response.data){
        dispatch({//this object is called an action
            type:createTypes.SUCCESSFUL_CREATE,
            payload:{
                currentUser:response.data
            }
        })
    }else {
        dispatch({
            type:createTypes.UNSUCCESSFUL_CREATE,
            payload: {
                createMessage:response.createMessage
            }
        })
    }
}

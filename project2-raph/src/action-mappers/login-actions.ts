import { apiLogin } from "../remote/api-clients/api"


export const loginTypes = {
    SUCCESSFUL_LOGIN: 'LOGIN_SUCCESSFUL_LOGIN',
    UNSUCCESSFUL_LOGIN: 'LOGIN_UNSUCCESSFUL_LOGIN'
}


export const updateCurrentUser = (email:string, password:string) => async (dispatch:any) => {
    let response:any = await apiLogin(email,password)
    if(response.body){
        dispatch({//this object is called an action
            type:loginTypes.SUCCESSFUL_LOGIN,
            payload:{
                currentUser:response.body
            }
        })
    }else {
        dispatch({
            type:loginTypes.UNSUCCESSFUL_LOGIN,
            payload: {
                loginMessage:response.loginMessage
            }
        })

    }


}
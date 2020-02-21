import { authenticateUser } from "../remote/api-clients/api"
// import { history } from "../utility/history"


export const loginTypes = {
    SUCCESSFUL_LOGIN: 'LOGIN_SUCCESSFUL_LOGIN',
    UNSUCCESSFUL_LOGIN: 'LOGIN_UNSUCCESSFUL_LOGIN',
    FAILED_LOGIN: 'LOGIN_FAILED_LOGIN',
    LOGOUT: 'LOGIN_LOGOUT'
}


export const updateCurrentUser = (email:string, password:string) => async (dispatch:any) => {
    let response:any = await authenticateUser(email,password)
    if(response.data){
        dispatch({//this object is called an action
            type:loginTypes.SUCCESSFUL_LOGIN,
            payload:{
                currentUser:response.data
            }
        })
        // history.push('/postlist');
    }else {
        dispatch({
            type:loginTypes.UNSUCCESSFUL_LOGIN,
            payload: {
                loginMessage:response.loginMessage
            }
        })
    }

}

    export const logout = (dispatch:any) => {
        dispatch({
            type:loginTypes.LOGOUT,
            payload:{
                loginMessage:"LOGGED OUT"
            }
        })
    } 
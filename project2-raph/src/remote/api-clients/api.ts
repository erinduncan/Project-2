import { axiosConfig } from "./axiosConfig";
import IUser from "../../model/IUser";

export const apiLogin = async (username: string, password: string): Promise<object> => {
    let credentials = {
        username,
        password
    }
    try {
        const response = await axiosConfig.post('auth.app', {
            credentials: 'include',
            body: JSON.stringify(credentials),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        if (response.status === 200) {
            const body = await response.data
            console.log(body)
            return {
                body,
                loginMessage: 'successful login'
            }
        } else if (response.status === 401) {
            return {
                loginMessage: "Incorrect Username or Password",
                body: null
            }
        } else {
            return {
                loginMessage: "Something Went Wrong",
                body: null
            }
        }
    } catch (e) {
        console.log(e);
        return {
            loginMessage: "Something Went Wrong",

        }
    }
}

// export const authenticateUser = (body: IUser) => {
//     return axiosConfig.post('auth.app', body);
// }

export const getList = () =>{
   return axiosConfig.get("list.app");
}

export const addUser = (body: IUser) => {
    return axiosConfig.post('add.app', body);
}



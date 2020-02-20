import axiosConfig from "./axiosConfig";
import axios from 'axios';
import IUser from "../../model/IUser";
import { history } from '../../utility/history';
import IPost from "../../model/IPost";
import ICreatePost from "../../model/ICreatePost";

export const apiLogin = async (username: string, password: string): Promise<object> => {
    let credentials = {
        username,
        password
    }
    try {
        const response = await axiosConfig.post('', {
            ...credentials
        })
        if (response.status === 200) {
            const body = await response.data
            console.log(body)
            history.push('/login')
            return {
                body,
                loginMessage: 'Successful login',
            }
        } else if (response.status === 401) {
            return {
                loginMessage: "Incorrect username or Password",
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
    return axiosConfig.post('/newuser.app', body);
}

export const publishPost = (body: ICreatePost) => {
    return axiosConfig.post('add.app', body);
} 
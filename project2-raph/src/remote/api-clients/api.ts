import axiosConfig from "./axiosConfig";
import IUser from "../../model/IUser";
import ICreatePost from "../../model/ICreatePost";
import { ILike } from "../../model/ILike";

export const authenticateUser = async (email:string, password:string) => {
  let credentials:IUser = {
      email: email,
      password: password
  };
  let response = await axiosConfig.post('login.app', credentials)
  console.log(response);
  return response;
}

export const getList = (offset: number, limit: number) => {
  return axiosConfig.get("list.app?o=" + offset + "&l=" + limit);
}

export const addUser = (body: IUser) => {
  return axiosConfig.post("/newuser.app", body);
};

export const publishPost = (body: ICreatePost) => {
  return axiosConfig.post("/newpost.app", body);
};

export const hitLike = (body: ILike) => {
  return axiosConfig.post('newlike.app', body);
}

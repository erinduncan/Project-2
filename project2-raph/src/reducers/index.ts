import { combineReducers } from "redux";
import { loginReducer } from "./login-reducer";
import { postReducer } from "./post-reducer";


// describe the data we want from the login component
export interface IUserState {
    currentUser:any
    loginMessage:string
}

//this is the data we want from the post state
export interface IPostState {
    allpost:any[]
}

export interface ICreateUserState{
    
}

// it will containe subinterfaces that represent different parts of state
export interface IState {
    userState : IUserState
    postState: IPostState
}




// we will take the individual reduces for each part of state
// and turn them into one super reducer that represents all of state
export const state = combineReducers<IState>({
    userState:loginReducer,
    postState:postReducer,
})
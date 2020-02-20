import { ICreateUserState } from "."
import { createTypes } from "../action-mappers/create-actions";

// first, we define the initial state of this piece of the store
const initialState:ICreateUserState = {
    newUser:null,
    createMessage:''
}


//we have a function that recieves actions, and returns the new state after that action
export const createReducer = (state = initialState, action:any) => {
    //all of the different ways for the reducer to update state
    //based on the type of the action it recieves
    switch (action.type) {
        case createTypes.SUCCESSFUL_CREATE:{
            return {//we always return the new state, which means, spread the old state
                ...state,
                newUser:action.payload.newUser,
                createMessage: 'You have Created New User'
            }
        }
        case createTypes.UNSUCCESSFUL_CREATE: {
            return {
                ...state,
                createMessage:action.payload.createMessage
            }
        }
    
        default:
            return state;
    }
}
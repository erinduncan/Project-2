import { IPostState } from ".";
import { postTypes } from "../action-mappers/post-actions";


const initialState: IPostState = {
    allpost:[]
}

export const postReducer = (state = initialState, action:any) => {
    switch (action.type) {
        case postTypes.SUCCESSFUL_GET_PAGE_POST: {
           return {
               ...state,
               allpost:action.payload.allpost
           }
        }
        case postTypes.UNSUCCESSFUL_GET_PAGE_POST: {
            return state
        } 
        default:
            return state
    }
}
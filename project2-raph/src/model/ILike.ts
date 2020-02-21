import { IPost } from "./IPost";
import IUser from "./IUser"

export interface ILike {
    likeId: number,
    likePost: IPost,
    likeUser: IUser
}
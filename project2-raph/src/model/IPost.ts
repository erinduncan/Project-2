import IUser from "./IUser";
import { IComment } from "./IComment";

export interface IPost {
  postId: number;
  title: string;
  body: string;
  image?: any
  postUser: IUser;
  submitted: Date,
  postComment?: IComment[]
  // getPostComments: (ownerUserId: number, postId: number) => any
}

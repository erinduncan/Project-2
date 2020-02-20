import IUser from "./IUser";

export default interface IPost {
    id:number;
    title: string
    body: string
    like: () => boolean //Alec's clicker component
    user: IUser
    // getPostComments: (ownerUserId: number, postId: number) => any
}

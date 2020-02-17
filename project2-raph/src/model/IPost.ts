export default interface IPost {
    id:number;
    post: []
    fullName: string
    likeCount: number
    currentUserlike: boolean
    isPostOwner: boolean
    like: () => any
    unlike: () => any
    delete: (id: string) => any
    setTitle: (title: string) => any
    getPostComments: (ownerUserId: string, postId: string) => any
    commentList: any
}
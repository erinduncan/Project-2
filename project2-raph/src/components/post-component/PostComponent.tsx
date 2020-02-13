// import React from 'react';
// import { Card, CardHeader } from 'reactstrap';

// interface IPostState{
//     text: string
//     openCopyLink: boolean
//     openPostWrite: boolean 
//     openCommentGroup?: () => void
// }

// interface IPostProps{    
//   post: any
//   fullName: string
//   likeCount: number
//   currentUserlike: boolean
//   isPostOwner: boolean
//   like: () => any
//   unlike: () => any
//   delete: (id: string) => any
//   setTitle: (title: string) => any
//   getPostComments: (ownerUserId: string, postId: string) => any
//   commentList: any
// }

// export class PostComponent extends React.Component<IPostState,IPostProps>{
//     // constructor(props:any){
//     //     super(props)

//     //     }
//     // }

//     render(){
//         const displayList: PostDisplayComponent[] = this.props.
//     }
// }
import React from 'react';
import { PostDisplayComponent } from './post-display-component/PostDisplayComponent';
import { CardColumns, Pagination, PaginationItem, PaginationLink } from 'reactstrap';
import { Redirect } from 'react-router';

interface IPostState {
    limit: number
    offset: number
}

interface IPostProps {
    user: any
    allPost: any[],
    getAllPost: (l: number, o: number) => void
}

export class PostComponent extends React.Component<IPostProps, IPostState> {
    constructor(props: any) {
        super(props)
        this.state = {
            limit: 18,
            offset: 0
        }
    }


    async componentDidMount() {
        if (this.props.user) {
            if (this.props.allPost.length === 0) {
                this.props.getAllPost(18, 0)
            }
        }
    }

    pageTurnForward = () => {
        let newOffset = this.state.offset + this.state.limit
        this.props.getAllPost(this.state.limit, newOffset)
        this.setState({
            ...this.state,
            offset: newOffset
        })
    }

    pageTurnBackwards = () => {
        if (this.state.offset > 0) {


            let newOffset = this.state.offset - this.state.limit
            this.props.getAllPost(this.state.limit, newOffset)
            this.setState({
                ...this.state,
                offset: newOffset
            })
        }
    }

    render() {

        const displayList: PostDisplayComponent[] = this.props.allPost.map<any>((Post: any) => {
            return <PostDisplayComponent id={Post.id}
                name={Post.name}
                height={Post.height}
                weight={Post.weight}
                types={[Post.types[0].type.name, Post.types[1] && Post.types[1].type.name]}
                key={Post.id}//don't use the position in the list
            />
        })

        if (this.props.user) {
            return (
                <>
                    <h3>Welcome Trainer {this.props.user && this.props.user.name}</h3>
                    <CardColumns>
                        {displayList}
                    </CardColumns>
                    <Pagination aria-label="Page navigation example">
                        <PaginationItem disabled>
                            <PaginationLink first />
                        </PaginationItem>
                        <PaginationItem disabled={!this.state.offset} onClick={this.pageTurnBackwards}>
                            <PaginationLink previous />
                        </PaginationItem>
                        <PaginationItem onClick={this.pageTurnForward}>
                            <PaginationLink next />
                        </PaginationItem>
                        <PaginationItem>
                            <PaginationLink last />
                        </PaginationItem>
                    </Pagination>
                </>

            )
        } else {
            return (
                <Redirect to='/login' />
            )
        }


    }

}
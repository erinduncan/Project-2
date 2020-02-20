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

        const displayList: PostDisplayComponent[] = this.props.allPost.map<any>((post: any) => {
            return <PostDisplayComponent id={post.id}
                title={post.name}
                body={post.body}
                like={post.like}
                user={this.props.user}
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
                        <PaginationItem disabled={!this.state.offset} onClick={this.pageTurnBackwards}>
                            <PaginationLink previous />
                        </PaginationItem>
                        <PaginationItem onClick={this.pageTurnForward}>
                            <PaginationLink next />
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
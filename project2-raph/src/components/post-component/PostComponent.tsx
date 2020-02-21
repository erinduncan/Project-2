import React from "react";
import { PostDisplayComponent } from "./post-display-component/PostDisplayComponent";
import {
  CardColumns,
  Pagination,
  PaginationItem,
  PaginationLink
} from "reactstrap";
import { Redirect } from "react-router";
import { IPost } from "../../model/IPost";
import IUser from "../../model/IUser";

interface IPostState {
  limit: number;
  offset: number;
}

interface IPostProps {
  user: IUser;
  allPosts: IPost[];
  getAllPosts: (limit: number, offset: number) => void;
}

export class PostComponent extends React.Component<IPostProps, IPostState> {
  constructor(props: any) {
    super(props);
    this.state = {
      limit: 5,
      offset: 0
    };
  }

  async componentDidMount() {
    if (this.props.user) {
      if (this.props.allPosts.length === 0) {
        this.props.getAllPosts(5, 0);
      }
    }
  }

  pageTurnForward = () => {
    let newOffset = this.state.offset + this.state.limit;
    this.props.getAllPosts(this.state.limit, newOffset);
    this.setState({
      ...this.state,
      offset: newOffset
    });
  };

  pageTurnFirst = () => {
    let newOffset = 0;
    this.props.getAllPosts(this.state.limit, newOffset);
    this.setState({
      ...this.state,
      offset: newOffset
    });
  };

  pageTurnBackwards = () => {
    if (this.state.offset > 0) {
      let newOffset = this.state.offset - this.state.limit;
      this.props.getAllPosts(this.state.limit, newOffset);
      this.setState({
        ...this.state,
        offset: newOffset
      });
    }
  };

  render() {
    // const displayList: PostDisplayComponent[] = this.props.allPosts.map<any>(
    //   (post: any) => {
    //     return (
    //       <PostDisplayComponent
    //         postId={post.postId}
    //         title={post.name}
    //         body={post.body}
    //         image={post.image}
    //         user={this.props.user}
    //       />
    //     );
    //   }
    // );

    if (this.props.user) {
      return (
        <div>
            <CardColumns>
              {this.props.allPosts[0] && (
                <PostDisplayComponent
                  post={this.props.allPosts[0]}
                  currentUser={this.props.user}
                  parent="hp"
                />
              )}
              {this.props.allPosts[1] && (
                <PostDisplayComponent
                  post={this.props.allPosts[1]}
                  currentUser={this.props.user}
                  parent="hp"
                />
              )}
              {this.props.allPosts[2] && (
                <PostDisplayComponent
                  post={this.props.allPosts[2]}
                  currentUser={this.props.user}
                  parent="hp"
                />
              )}
              {this.props.allPosts[3] && (
                <PostDisplayComponent
                  post={this.props.allPosts[3]}
                  currentUser={this.props.user}
                  parent="hp"
                />
              )}
              {this.props.allPosts[4] && (
                <PostDisplayComponent
                  post={this.props.allPosts[4]}
                  currentUser={this.props.user}
                  parent="hp"
                />
              )}
            </CardColumns>
            <Pagination aria-label="Page navigation example">
              <PaginationItem disabled>
                <PaginationLink first onClick={this.pageTurnFirst} />
              </PaginationItem>
              <PaginationItem
                disabled={!this.state.offset}
                onClick={this.pageTurnBackwards}
              >
                <PaginationLink previous />
              </PaginationItem>
              <PaginationItem onClick={this.pageTurnForward}>
                <PaginationLink next />
              </PaginationItem>
              <PaginationItem>
                <PaginationLink last />
              </PaginationItem>
            </Pagination>
          </div>
      );
    } else {
      return <Redirect to="/login" />;
    }
  }
}


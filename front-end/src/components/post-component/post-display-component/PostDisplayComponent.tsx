import React from "react";
import { Card, CardBody, CardTitle, CardText, Button, Row } from "reactstrap";
import IUser from "../../../model/IUser";
import { IPost } from "../../../model/IPost";
import { ILike } from "../../../model/ILike";
import { hitLike } from "../../../remote/api-clients/api";

interface IPostDisplayProps {
  post: IPost;
  currentUser: IUser;
  parent: string;
}

interface IPostDisplayState {
  comment: string;
}

export class PostDisplayComponent extends React.Component<
  IPostDisplayProps,
  IPostDisplayState
> {
  constructor(props: any) {
    super(props);
    this.state = {
      comment: ""
    };
  }

  updateComment = (event: any) => {
    this.setState({
      ...this.state,
      comment: event.target.value
    });
  };

  cardTextBuilder() {
    return `${this.props.post.title}\n\r
            ${this.props.post.image}\n\r
            ${this.props.post.body}\n\r
            Submitted on: ${new Date(this.props.post.submitted)} by ${
      this.props.post.postUser.handle
    }`;
  }

  like() {
    let like: ILike = {
      likeUser: this.props.currentUser,
      likePost: this.props.post
    };
    hitLike(like);
  }

  render() {
    console.log(this.props);

    return (
      <>
        <Row>
          <Card>
            <CardBody>
              <CardTitle>{this.props.post.title}</CardTitle>
              <CardText>{this.cardTextBuilder}</CardText>
            </CardBody>
          </Card>
        </Row>
        <Row>
          <Button color="secondary" onClick={() => this.like}>
            Love
          </Button>
        </Row>
      </>
    );
  }
}

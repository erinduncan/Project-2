import React from "react";
import {
  Card,
  CardBody,
  CardTitle,
  CardSubtitle,
  CardText,
  Input
} from "reactstrap";
import IUser from "../../../model/IUser";

interface IPostDisplayProps {
  id: number;
  title: string;
  body: string;
  image: any;
  // like: () => boolean; Needs to be changed to something.
  user: IUser;
  // delete: (id: string) => any
  // getPostComments: (ownerUserId: string, postId: string) => any
}

export class PostDisplayComponent extends React.PureComponent<
  IPostDisplayProps
> {
  like() {
    let radio: any = document.getElementById("like");
    return radio === onchange ? true : false;
  }

  render() {
    console.log(this.props);

    return (
      <Card>
        <CardBody>
          <CardTitle>{this.props.title}</CardTitle>
          {/* handle should be unique */}
          <CardSubtitle>{this.props.user.handle}</CardSubtitle>
          <CardText>{this.props.body}</CardText>
          <Input id="like" type="radio" aria-label="Like?">
            Like
          </Input>
        </CardBody>
      </Card>
    );
  }
}

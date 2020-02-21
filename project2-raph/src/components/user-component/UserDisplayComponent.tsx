import React from "react";
import { Card, CardBody, CardTitle, CardSubtitle, CardText } from "reactstrap";
import IUser from "../../model/IUser";
import "../../css/Main.css";
import { Link } from "react-router-dom";

export class UserDisplayComponent extends React.PureComponent<IUser> {
  render() {
    console.log(this.props);

    return (
      <Card>
        <CardBody>
          <CardTitle>{this.props.handle}</CardTitle>
          <CardSubtitle>
            {this.props.firstName + " " + this.props.lastName}
          </CardSubtitle>
          <CardText>{this.props.email}</CardText>
        </CardBody>
        <Link className="btn btn-outline-secondary" to="/post">
          Post!
        </Link>
      </Card>
    );
  }
}

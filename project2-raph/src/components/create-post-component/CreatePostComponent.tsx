import React, { useState, SyntheticEvent } from "react";
import {
  Form,
  Input,
  Container,
  FormGroup,
  Label,
  Col,
  Button
} from "reactstrap";
import ICreatePost from "../../model/ICreatePost";
import { publishPost } from "../../remote/api-clients/api";

export const CreatePostComponent: React.FC<any> = (props: ICreatePost) => {
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");
  const [image, setImage] = useState();
  // const [submitted, setSubmitted] = useState("");

  const submitPost = async (event: SyntheticEvent) => {
    event.preventDefault();
  };

  return (
    <div className="postContainer">
      <Container className="postForm">
        <h2>Make a Post</h2>
        <Form
          onSubmit={() =>
            publishPost({
              postId: 0,
              title: title,
              image: image,
              body: body,
              submitted: new Date(),
              liked: false
            }).then((r: { data: any }) => console.log(r.data))
          }
        >
          <FormGroup row>
            <Label for="title" sm={2}>
              Title
            </Label>
            <Col sm={10}>
              <Input
                type="text"
                placeholder="Title"
                onChange={val => setTitle(val.target.value)}
              />
            </Col>
          </FormGroup>

          <FormGroup row>
            <Label for="body" sm={2}>
              Body
            </Label>
            <Col sm={10}>
              <textarea
                className="form-control rounded-0"
                placeholder="Body"
                onChange={val => setBody(val.target.value)}
              ></textarea>
            </Col>
          </FormGroup>

          <FormGroup row > {/* enctype="multipart/form-data" */}
            <Label for="image" sm={2}>
              Image
            </Label>
            <Col sm={10}>
            <Input
                type="file"
                name="image"
                id="image"
                placeholder="Submit your image"
                onChange={val => setImage(val.target.value)}
              />
            </Col>
          </FormGroup>

          <Button outline color="secondary" onClick={submitPost}>
            Submit
          </Button>
        </Form>
      </Container>
    </div>
  );
};
export default CreatePostComponent;

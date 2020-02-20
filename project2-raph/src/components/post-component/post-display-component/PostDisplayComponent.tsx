import React from 'react';
import {  Card, CardBody, CardTitle, CardText } from 'reactstrap';

interface IPostDisplayProps {
    id:number;
    postText: string
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

export class PostDisplayComponent extends React.PureComponent<IPostDisplayProps>{

    cardTextBuilder(){
        return (this.props.postText)
    }

    render() {
        console.log(this.props);

        return (
            <Card>
                <CardBody>
                    <CardTitle>{this.props.setTitle(``)}</CardTitle>
                    {/* <CardSubtitle>{this.props.name}</CardSubtitle> */}
                    <CardText>{this.cardTextBuilder()}</CardText>
                    {/* <C */}
                </CardBody>
            </Card>
        )
    }
}
import React from 'react';
import {  Card, CardBody, CardTitle, CardSubtitle, CardText } from 'reactstrap';

interface IPostDisplayProps {
    id: number
    height: number
    weight: number
    name: string
    types: string[]
}

export class PostDisplayComponent extends React.PureComponent<IPostDisplayProps>{

    cardTextBuilder(){
        return `This Post: ${this.props.name} has an amusing weight of ${this.props.weight}
        it is also ${this.props.height} tall and has the type/s of ${this.props.types[0]}` + (this.props.types[1] ?  ' and ' + this.props.types[1] : '' )
    }

    render() {
        console.log(this.props);

        return (
            <Card>
                <CardBody>
                    <CardTitle>{this.props.id}</CardTitle>
                    <CardSubtitle>{this.props.name}</CardSubtitle>
                    <CardText>{this.cardTextBuilder()}</CardText>
                </CardBody>
            </Card>
        )
    }
}
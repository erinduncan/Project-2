import React from 'react'

export interface IEmailState {
    email: string
    visible: boolean
}

export class EmailComponent extends React.Component<any, IEmailState> {
    constructor(props: any) {
        super(props);
        this.state = {
            email:'',
            visible: false
        }
    }

    
}
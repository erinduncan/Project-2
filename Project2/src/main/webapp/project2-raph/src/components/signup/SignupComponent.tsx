import React from 'react'


interface ISignupComponentProps {
    showError?: (message: string) => any
    register?: (data: any) => any
    loginPage?: () => any
    classes?: any
    translate?: (state: any, param?: {}) => any
}

interface ISignupComponentState {
    [key: string]: any
    firstNameInput: string
    firstNameInputError: string
    lastNameInput: string
    lastNameInputError: string
    emailInput: string
    emailInputError: string
    passwordInput: string
    passwordInputError: string
    confirmInput: string
    confirmInputError: string
    checkInputError?: string
}

export class SignupComponent extends React.Component<ISignupComponentProps, ISignupComponentState> {

}
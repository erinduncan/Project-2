import { connect } from "react-redux";
import { IState } from "../../reducers";
import { CreateUserComponent } from "./CreateUserComponent";
import { createUser } from "../../action-mappers/create-actions";

const mapStateToProps = (state:IState) => {
    return {
        //all of the state that goes to login component goes inside here
        loginMessage:state.userState.loginMessage
    }
}


const mapDispatchToProps = {
/**
 * contains a function that will return an action that we want 
 *      the create User component to be able to call
 * @author Maresh E
 */
    createUser
}

/**
 * this connect statemengt is building a new component that passes the redux info into the login component
 * @author RevatureInstructor: Alec
 */
export default connect(mapStateToProps,mapDispatchToProps)(CreateUserComponent);
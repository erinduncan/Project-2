import { connect } from "react-redux";
import { IState } from "../../reducers";
import { CreatePostComponent } from "./CreatePostComponent";


const mapStateToProps = (state:IState) => {
    return {
        //all of the state that goes to login component goes inside here
        user: state.userState.currentUser
    }
}

// this connect statemengt is building a new component that passes the redux info into the login component
export default connect(mapStateToProps)(CreatePostComponent)
import { connect } from "react-redux";
import { UserComponent } from "./UserComponent";
import { IState } from "../../reducers";
// import { getAllUser } from '../../action-mappers/User-actions'



const mapStateToProps = (state: IState) => {
    return {
        user: state.userState.currentUser, //grab current user from store 
        // allUser: state.UserState.allUser//grab all User from store
    }
}

const mapDispatchToProps = {
    // getAllUser // action mapper for getting User with limit and offset
}


export default connect(mapStateToProps, mapDispatchToProps)(UserComponent)
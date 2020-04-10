  
import { connect } from "react-redux";
import { PostComponent } from "./PostComponent";
import { IState } from "../../reducers";
import { getAllPost } from '../../action-mappers/post-actions'



const mapStateToProps = (state: IState) => {
    return {
        user: state.userState.currentUser, //grab current user from store 
        allPost: state.postState.allpost//grab all Post from store
    }
}

const mapDispatchToProps = {
    getAllPost // action mapper for getting Post with limit and offset
}


export default connect(mapStateToProps, mapDispatchToProps)(PostComponent)
import { getMultiplePost, getPostByUrl } from "../remote/api-clients/get-post"

export const postTypes = {
    SUCCESSFUL_GET_PAGE_POST: 'POST_SUCCSSFUL_GET_PAGE_POST',
    UNSUCCESSFUL_GET_PAGE_POST: 'POST_UNSUCCSSFUL_GET_PAGE_POST',
    SUCCESSFUL_MADE_POST: 'POST_SUCCESSFUL_MADE_POST',
    UNSUCCESSFUL_MADE_POST: 'POST_UNSUCCESSFUL_MADE_POST'
}


export const getAllPost = (limit: number, offset: number) => async (dispatch: any) => {
    try {
        let postLinks: any = await getMultiplePost(limit, offset)
        let posts = await Promise.all(postLinks.results.map((objects: any) => {
            return getPostByUrl(objects.url)
        }))
        dispatch({
            type:postTypes.SUCCESSFUL_GET_PAGE_POST,//what should the reducer do
            payload:{//the new data for the store
                allpost:posts
            }
        })
    } catch (e) {
        dispatch({
            type:postTypes.UNSUCCESSFUL_GET_PAGE_POST
        })
    }
}

// export const dbGetPosts = (page: number = 0, limit: number = 10) => {
//     return (dispatch: any, getState: Function) => {
//       const state: Map<string, any> = getState()
//       const stream: Map<string, any> = state.getIn(['post', 'stream'])
//       const lastPageRequest = stream.get('lastPageRequest')
//       const lastPostId = stream.get('lastPostId')
  
//       let uid: string = state.getIn(['authorize', 'uid'])
//       if (uid && lastPageRequest !== page) {
//         return postService.getPosts(uid, lastPostId, page, limit).then((result) => {
//           if (!result.posts || !(result.posts.length > 0)) {
//             return dispatch(notMoreDataStream())
//           }
  
//           // Store last post Id
//           dispatch(lastPostStream(result.newLastPostId))
//           let parsedData: Map<string, Map<string, any>> = Map({})
//           result.posts.forEach((post) => {
//             const postId = Object.keys(post)[0]
//             const postData = post[postId]
//             const ownerId = postData.ownerUserId!
//             parsedData = parsedData.setIn([ownerId, postId], fromJS(postData))
//           })
  
//           dispatch(addPosts(parsedData))
//         })
//           .catch((error: SocialError) => {
//             dispatch(globalActions.showMessage(error.message))
//           })
  
//       }
//     }
//   }
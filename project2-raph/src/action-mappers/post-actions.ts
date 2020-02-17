import { getMultiplePost, getPostByUrl } from "../remote/api-clients/get-post"

export const postTypes = {
    SUCCESSFUL_GET_PAGE_POST: 'POST_SUCCSSFUL_GET_PAGE_POST',
    UNSUCCESSFUL_GET_PAGE_POST: 'POST_UNSUCCSSFUL_GET_PAGE_POST',
    SUCCESSFUL_MADE_POST: 'POST_SUCCESSFUL_MADE_POST',
    UNSUCCESSFUL_MADE_POST: 'POST_UNSUCCESSFUL_MADE_POST'
}


export const getAllPost = (limit: number, offset: number) => async (dispatch: any) => {
    try {
        let pokeLinks: any = await getMultiplePost(limit, offset)
        let post = await Promise.all(pokeLinks.results.map((objects: any) => {
            return getPostByUrl(objects.url)
        }))

        dispatch({
            type:postTypes.SUCCESSFUL_GET_PAGE_POST,//what should the reducer do
            payload:{//the new data for the store
                allpost:post
            }
        })

    } catch (e) {
        dispatch({
            type:postTypes.UNSUCCESSFUL_GET_PAGE_POST
        })
    }



}
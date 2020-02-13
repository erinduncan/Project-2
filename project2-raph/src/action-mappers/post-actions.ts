import { getMultiplePost, getPostByUrl } from "../remote/poke-api-clients/get-post"

export const postTypes = {
    SUCCESSFUL_GET_PAGE_POST: 'POST_SUCCSSFUL_GET_PAGE_POST',
    UNSUCCESSFUL_GET_PAGE_POST: 'POST_UNSUCCSSFUL_GET_PAGE_POST'
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
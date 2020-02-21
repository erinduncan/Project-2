export const getMultiplePost = async (limit:number, offset:number):Promise<object> => {
    let response = await fetch(`https://pokeapi.co/api/v2/pokemon/?limit=${limit}&offset=${offset}`)
    let body = await response.json()
    return body
}

export const getPostByUrl = async (url:string):Promise<object> => {
    let response = await fetch(url)
    let body = await response.json()
    return body
}

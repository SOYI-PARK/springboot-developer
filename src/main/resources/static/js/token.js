const token = searchParam('token')

if(token){
    //파라미터로 받은 토큰이 있다면 로컬 스토리지에 저장
    localStorage.setItem("access_token", token)
}

function  searchParam(key){
    return new URLSearchParams(location.search).get(key)
}
function joinChk(){
    const frm = document.querySelector('#frm');
    if(frm.uid.value.length < 5){
        alert('아이디를 5자 이상 작성해주세요');
        return false;
    } else if(frm.upw.value.length < 5){
        alert('비밀번호를 5자 이상 작성해주세요');
        return false;
    } else if(frm.upw.value !== frm.reupw.value){
        alert('비밀번호를 확인해주세요');
        return false;
    } else if(frm.nm.value.length > 5){
        alert('이름이 너무 깁니다 5글자 이하로 적어주세요');
        return false;
    }
    return true;
}
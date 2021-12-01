function joinChk(){
    var frm = document.querySelector('#frm');
    var id = frm.uid.value;
    var pw = frm.upw.value;
    var repw = frm.reupw.value;
    var nm = frm.nm.value;

    if(id.length < 5 || id.length > 20){
        alert('아이디를 5~20자 사이로 작성해주세요');
        return false;
    } else if(pw.length < 5){
        alert('비밀번호를 5자 이상 작성해주세요');
        return false;
    } else if(pw !== repw){
        alert('비밀번호를 확인해주세요');
        return false;
    } else if(nm.length > 5){
        alert('이름이 너무 깁니다 5글자 이하로 적어주세요');
        return false;
    } else {
        alert("회원가입이 정상적으로 완료되었습니다");
        return true;
    }
}
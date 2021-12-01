var frm = document.querySelector('#frm');
if(frm){
    function proc(e){
        alert('전송!!');
        e.preventDefault();
    }
    frm.addEventListener('submit', proc);
}
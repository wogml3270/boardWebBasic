<%@ page contentType="text/html;charset=utf-8" language="java" %>
<h1 class="page-title">로그인 페이지</h1>
<div class="wrap">
    <div>
    <form action="/user/login" method="post" id="frm" onsubmit="return frmSubmitEvent();">
        <div>
            <input type="text" name="uid" placeholder="id" value="wogml3270">
        </div>
        <div>
            <input type="password" name="upw" placeholder="password" value="pjh1682911">
        </div>
        <div>
            <input type="submit" value="login">
        </div>
    </form>
    <div>
        <input type="button" value="비밀번호 보이기" id="btnShowPw">
        <a href="/user/join">회원가입</a>
    </div>
    </div>
</div>
<script src="/static/js/user/login.js?ver=3"></script>

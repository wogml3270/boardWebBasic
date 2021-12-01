<%@ page contentType="text/html;charset=utf-8" language="java" %>
<h1>회원가입 페이지</h1>
<div>
    <form action="/user/join" method="post" id="frm" onsubmit="return joinChk();">
        <div>
            <input type="text" name="uid" placeholder="id type" required>
        </div>
        <div>
            <input type="password" name="upw" placeholder="password type" required>
        </div>
        <div>
            <input type="password" name="reupw" placeholder="password comfirm" required>
        </div>
        <div>
            <input type="text" name="nm" placeholder="name type" required>
        </div>
        <div>
            <label>female<input type="radio" value="0" name="gender" checked></label>
            <label>male<input type="radio" value="1" name="gender"></label>
        </div>
        <div>
            <input type="submit" value="join">
            <input type="reset" value="reset">
        </div>
    </form>
</div>
<script src="/static/js/user/join.js"></script>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<div>
    <form action="/user/login" method="post" id="frm">
        <div>
            <input type="text" name="uid" placeholder="id">
        </div>
        <div>
            <input type="password" name="upw" placeholder="password">
        </div>
        <div>
            <input type="submit" value="login">
        </div>
    </form>
    <div>
        <a href="/user/join">join</a>
    </div>
</div>
<script src="/static/js/user/login.js"></script>

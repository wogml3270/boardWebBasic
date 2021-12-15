<%@ page contentType="text/html;charset=utf-8" language="java" %>
<div>
    <div class="subContainer">
        <ul>
            <li><a href="/user/profile">프로필</a></li>
            <li><a href="/user/password">비밀번호 변경</a></li>
        </ul>
    </div>
    <div class="subBody"><jsp:include page="/WEB-INF/view/${requestScope.subPage}.jsp"></jsp:include></div>
</div>
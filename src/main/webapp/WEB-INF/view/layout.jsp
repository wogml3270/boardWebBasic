<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${requestScope.title}</title>
    <link type="text/css" rel="stylesheet" href="/static/css/common.css?ver=5">
</head>
<body>
    <div class="container">
        <div class="header">
            <ul class="topMenu">
                    <li><a href="/board/list">게시판</a></li>
                <c:if test="${sessionScope.loginUser != null}">
                    <li><a href="/board/regmod">글쓰기</a></li>
                    <li><a href="/user/logout">로그아웃</a></li>
                    <li>${sessionScope.loginUser.nm}(${sessionScope.loginUser.uid})님 환영합니다.</li>
                </c:if>
                <c:if test="${sessionScope.loginUser == null}">
                    <li><a href="/user/login">로그인</a></li>
                    <li><a href="/user/join">회원가입</a></li>
                </c:if>
            </ul>
        </div>
        <div class="body"><jsp:include page="/WEB-INF/view/${requestScope.page}.jsp"></jsp:include></div>
        <div class="footer">
            <p>footer</p>
        </div>
    </div>

</body>
</html>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${requestScope.title}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link type="text/css" rel="stylesheet" href="/static/css/common.css?v=4">
    <link type="text/css" rel="stylesheet" href="/static/css/user/userPage.css?v=4">
</head>
<body>
    <div class="container">
        <div class="header">
            <ul class="topMenu">
                <li><a href="/board/list">게시판</a></li>
                <li><a href="/board/rank?type=1">조회수 Top 10</a></li>
                <li><a href="/board/rank?type=2">댓글수 Top 10</a></li>
                <li><a href="/board/rank?type=3">좋아요 Top 10</a></li>
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
        <div class="body">
            <jsp:include page="/WEB-INF/view/${requestScope.page}.jsp"></jsp:include>
        </div>
        <div class="footer">
            <p>footer</p>
        </div>
    </div>
<c:if test="${ err != null }">
    <script>
        const body = document.querySelector('body');
        body.onload = function(){
            setTimeout(function(){
                alert('<c:out value="${err}"/>');
            }, 500);
        };
    </script>
</c:if>
</body>
</html>
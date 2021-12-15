<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/static/css/board/detail.css?v=2">
<div>
    <c:if test="${sessionScope.loginUser.iuser == requestScope.data.writer}">
    <div>
        <a href="/board/del?iboard=${requestScope.data.iboard}"><button>삭제</button></a>
        <a href="/board/regmod?iboard=${requestScope.data.iboard}"><button>수정</button></a>
    </div>
    </c:if>
    <div>
    <c:if test="${sessionScope.loginUser != null }">
        <c:choose>
            <c:when test="${requestScope.isHeart == 1}">
                <a href="/board/heart?proc=2&iboard=${requestScope.data.iboard}"><i class="fas fa-heart"></i></a>
            </c:when>
            <c:otherwise>
                <a href="/board/heart?proc=1&iboard=${requestScope.data.iboard}"><i class="far fa-heart"></i></a>
            </c:otherwise>
        </c:choose>
    </c:if>
    </div>
    <div>글번호: ${requestScope.data.iboard}</div>
    <div>조회수 : <c:out value="${requestScope.data.hit}"/></div>
    <div>작성자 : <c:out value="${requestScope.data.writerNm}"/></div>
    <div>등록일시 : <c:out value="${requestScope.data.rdt}"/></div>
    <div>제목 : <c:out value="${requestScope.data.title}"/></div>
    <div><c:out value="${requestScope.data.ctnt}"/></div>

    <c:if test="${sessionScope.loginUser != null}">
        <div>
            <form action="/board/cmt/reg" method="post">
                <input type="hidden" name="iboard" value="${requestScope.data.iboard}">
                <input type="text" name="ctnt" placeholder="댓글 내용">
                <input type="submit" value="댓글달기">
            </form>
        </div>
    </c:if>
    <div>
        <table>
            <tr>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>비고</th>
            </tr>
            <c:forEach items="${requestScope.cmtList}" var="item">
                <tr>
                    <td><c:out value="${item.ctnt}"/></td>
                    <td>${item.writerNm}</td>
                    <td>${item.rdt}</td>
                    <td>
                        <c:if test="${sessionScope.loginUser.iuser == item.writer}">
                            <button onclick="isModCmt(${item.icmt}, '${item.ctnt}');">수정</button>
                            <button onclick="isDelCmt(${requestScope.data.iboard}, ${item.icmt});">삭제</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="cmtModContainer">
    <div class="cmtModBody">
        <form action="/board/cmt/mod" method="post" id="cmtModFrm">
            <input type="hidden" name="iboard" value="${requestScope.data.iboard}">
            <input type="hidden" name="icmt">
            <div><input type="text" name="ctnt" placeholder="댓글 내용"></div>
            <div>
                <input type="submit" value="수정">
                <input type="button" value="취소" id="btnCancel">
            </div>
        </form>
    </div>
</div>
<script src="/static/js/board/detail.js?ver=2"></script>
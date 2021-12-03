<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/static/css/board/list.css?ver=5">
<div>
    <table id="boardTable">
        <tr>
            <th>no</th>
            <th>title</th>
            <th>hits</th>
            <th>writer</th>
            <th>reg-datetime</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="item">
            <tr onclick="moveToDetail(${item.iboard});">
                <td>${item.iboard}</td>
                <td><c:out value="${item.title}"/></td>
                <td>${item.hit}</td>
                <td><c:out value="${item.writerNm}"/></td>
                <td>${item.rdt}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="/static/js/board/list.js?ver=5"></script>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="/static/css/board/list.css?ver=1">
<h1 class="rankTitle">${requestScope.title}</h1>
    <c:if test="${fn:length(requestScope.list) == 0}">
        <h3>랭킹이 없습니다.</h3>
    </c:if>
    <c:if test="${fn:length(requestScope.list) > 0}">
        <div>
            <table id="boardTable">
                <colgroup>
                    <col width="5%">
                    <col width="30%">
                    <col width="5%">
                    <col width="30%">
                    <col width="30%">
                </colgroup>
                <tr>
                    <th>no</th>
                    <th>title</th>
                    <th>${param.type == 1 ? 'hit' : 'count'}</th>
                    <th>writer</th>
                    <th>reg-datetime</th>
                </tr>
                <c:forEach items="${requestScope.list}" var="item">
                    <c:set var="eachTitle" value="${fn:replace(fn:replace(item.title, '>', '&gt;'), '<', '&lt;')}"/>
                    <c:if test="${param.searchText != null && (param.searchType == 1 || param.searchType == 3 || param.searchType == 5)}">
                        <c:set var="eachTitle" value="${fn:replace(eachTitle, param.searchText, '<mark>' += param.searchText += '</mark>')}" />
                    </c:if>

                    <c:set var="eachWriterNm" value="${item.writerNm}" />
                    <c:if test="${param.searchText != null && (param.searchType == 4 || param.searchType == 5)}">
                        <c:set var="eachWriterNm" value="${fn:replace(eachWriterNm, param.searchText, '<mark>' += param.searchText += '</mark>')}" />
                    </c:if>

                    <tr class="record" onclick="moveToDetail(${item.iboard});">
                        <td>${item.iboard}</td>
                        <td>${eachTitle}</td>
                        <td>${item.cnt}</td>
                        <td>${eachWriterNm}</td>
                        <td>${item.rdt}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>
<script src="/static/js/board/list.js?ver=1"></script>
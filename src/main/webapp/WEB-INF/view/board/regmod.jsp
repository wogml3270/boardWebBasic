<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form action="/board/regmod" method="post">
        <div>
            <label>제목 : <input type="text" name="title"></label>
        </div>
        <div>
            <label>내용 : <textarea name="ctnt"></textarea></label>
        </div>
        <div>
            <input type="submit" value="등록">
            <input type="reset" value="초기화">
        </div>
    </form>
</div>
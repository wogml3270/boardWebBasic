<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${requestScope.title}</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/static/css/common.css">
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>header</h1>
        </div>
        <div class="body"><jsp:include page="/WEB-INF/view/${requestScope.page}.jsp"></jsp:include></div>
        <div class="footer">
            <p>footer</p>
        </div>
    </div>

</body>
</html>
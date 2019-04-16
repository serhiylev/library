<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>author</title>
</head>
<body>
<div>
    <form>
        <ul>
            <c:forech var = "author" items="Author">
                <%--<li>${author.}</li>--%>
            </c:forech>
        </ul>
    </form>
</div>
</body>
</html>

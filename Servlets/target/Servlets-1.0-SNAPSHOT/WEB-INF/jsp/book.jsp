<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 16.04.2019
  Time: 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
</head>
<body>
<div>
    <jsp:include page="book.jsp"/>
</div>
<div>
    <form>
        <ul>
            <c:forEach var="book" items="Books">
                <li>Id = ${book.getId}</li>
                <li>Name = ${book.getName}</li>
                <li>ReleaseDate = ${book.getReleaseDate}</li>
                <li>Available = ${book.isAvailable}</li>
            </c:forEach>
        </ul>
    </form>
</div>

</body>
</html>

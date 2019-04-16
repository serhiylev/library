<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 16.04.2019
  Time: 3:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>book</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<div>
    <form method="post" action="create-book">
        <h2>Create book</h2>
            <input type="text" name="ID" placeholder="ID">
            <input type="text" name="NAME" placeholder="NAME">
            <input type="text" name="RELEASE_DATE" placeholder="RELEASE_DATE">
            <input type="text" name="AVAILABLE" placeholder="AVAILABLE">
        <button class="button" type="submit"></button>
    </form>

    <form method="post" action="delete-book">
        <h2>Delete book</h2>
        <input type = "text" name="ID" placeholder="ID">
        <button class="button" type="submit"></button>
    </form>

    <form method="post" action="update-book">
        <h2>Update book</h2>
            <input type="text" name="ID" placeholder="ID">
            <input type="text" name="NAME" placeholder="NAME">
            <input type="text" name="RELEASE_DATE" placeholder="RELEASE_DATE">
            <input type="text" name="AVAILABLE" placeholder="AVAILABLE">
        <button class="button" type="submit"></button>
    </form>

    <form class="review">
        <h2>All books</h2>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Release Date</th>
                <th>Available</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}" varStatus="rowCounter">
                <tr>
                    <td>${book.getId()}</td>
                    <td>${book.getName()}</td>
                    <td>${book.getReleaseDate().toString()}</td>
                    <td>${book.isAvailable()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="button" type="submit"></button>
    </form>
</div>

</body>
</html>

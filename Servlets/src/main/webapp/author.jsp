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
    <title>author</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<div>
    <form method="post" action="create_author">
        <h2>Create Author</h2>
            <input type="text" name="ID" placeholder="ID">
            <input type="text" name="FIRSTNAME" placeholder="FIRSTNAME">
            <input type="text" name="LASTNAME" placeholder="LASTNAME">
            <input type="text" name="AGE" placeholder="AGE">
        <button class="button" type="submit">Create Author</button>
    </form>

    <form method="post" action="author">
        <h2>Delete Author</h2>
        <input type="text" name="ID" placeholder="ID">
        <button class="button" type="submit">Delete Author</button>
    </form>

    <form method="post" action="update_author">
        <h2>Update Author</h2>
            <input type="text" name="ID" placeholder="ID">
            <input type="text" name="FIRSTNAME" placeholder="FIRSTNAME">
            <input type="text" name="LASTNAME" placeholder="LASTNAME">
            <input type="text" name="AGE" placeholder="AGE">
        <button class="button" type="submit">Update Author</button>
    </form>

    <form class="review">
        <h2>All Authors</h2>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="author" items="${authors}" varStatus="rowCounter">
                <tr>
                    <td>${author.getId()}</td>
                    <td>${author.getFirstName()}</td>
                    <td>${author.getLastName()}</td>
                    <td>${author.getAge()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="button" type="submit">Update</button>
    </form>


</div>
</body>
</html>

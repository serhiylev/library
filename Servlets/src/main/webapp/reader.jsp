<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 16.04.2019
  Time: 3:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reader</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<div>
    <form method="post" action="create-reader">
        <h2>Create reader</h2>
            <input type="text" name="ID" placeholder="ID">
            <input type="text" name="FIRSTNAME" placeholder="FIRSTNAME">
            <input type="text" name="LASTNAME" placeholder="LASTNAME">
            <input type="text" name="AGE" placeholder="AGE">
        <button class="button" type="submit"></button>
    </form>

    <form method="post" action="delete-reader">
        <h2>Delete reader</h2>
        <input type="text" name="ID" placeholder="ID">
        <button class="button" type="submit"></button>
    </form>

    <form method="post" action="update-reader">
        <h2>Update reader</h2>
            <input type="text" name="ID" placeholder="ID">
            <input type="text" name="FIRSTNAME" placeholder="FIRSTNAME">
            <input type="text" name="LASTNAME" placeholder="LASTNAME">
            <input type="text" name="AGE" placeholder="AGE">
        <button class="button" type="submit"></button>
    </form>

    <form class="review">
        <h2>All readers</h2>
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
            <c:forEach var="reader" items="${readers}" varStatus="rowCounter">
                <tr>
                    <td>${reader.getId()}</td>
                    <td>${reader.getFirstName()}</td>
                    <td>${reader.getLastName()}</td>
                    <td>${reader.getAge()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="button" type="submit"></button>
    </form>
</div>
</body>
</html>

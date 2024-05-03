<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 03/05/2024
  Time: 3:24 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Present Management</h1>
    <h2>
        <a href="present?action=create">Add New Present</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Present</h2></caption>
        <tr>
            <th>ID</th>
            <th>Code</th>
            <th>Name</th>
            <th>price</th>
            <th>ship</th>
            <th>img</th>
        </tr>
        <c:forEach var="pr" items="${listPresent}">
            <tr>
                <td><c:out value="${pr.id}"/></td>
                <td><c:out value="${pr.code}"/></td>
                <td><c:out value="${pr.name}"/></td>
                <td><c:out value="${pr.price}"/></td>
                <td><c:out value="${pr.ship}"/></td>
                <td><c:out value="${pr.img}"/></td>
                <td>
                    <a href="present?action=edit&id=${pr.id}">Edit</a>
                    <a href="present?action=delete&id=${pr.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

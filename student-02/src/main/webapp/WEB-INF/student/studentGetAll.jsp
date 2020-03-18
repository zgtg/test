<%--
  Created by IntelliJ IDEA.
  User: 13126
  Date: 2020/3/18
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <td>id</td>
                <td>name</td>
                <td>birthday</td>
                <td>province</td>
                <td>sex</td>
                <td>sports</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${studentList}" var="student">
                <tr>
<%--                    <td><input type="checkbox" name="email-checkbox" value="${email.id}"></td>--%>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.birthday}</td>
                    <td>${student.province}</td>
                    <td>${student.sex}</td>
                    <td>${student.sports}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

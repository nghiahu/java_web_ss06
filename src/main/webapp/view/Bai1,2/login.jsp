<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 13/05/2025
  Time: 9:09 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .formLoginBook{
        border: 1px solid black;
        width: 350px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
</style>
<body>
<form action="<%=request.getContextPath()%>/bookController?action=login" method="post" class="formLoginBook">
    <h1>Đăng nhập</h1>
    <label>Username</label>
    <input type="text" name="username" required>
    <label>Password</label>
    <input type="text" name="password" required>
    <button type="submit" style="margin: 10px">Đăng nhập</button>
</form>
<p>Bạn chưa có tài khoản!<a href="register.jsp">Đăng ký</a></p>
<c:if test="${error != null}">
    <h1>${error}</h1>
</c:if>
</body>
</html>

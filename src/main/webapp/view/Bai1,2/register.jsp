<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 13/05/2025
  Time: 9:10 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .formRegisBook{
        border: 1px solid black;
        width: 350px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
</style>
<body>
<form action="<%=request.getContextPath()%>/bookController?action=register" method="post" class="formRegisBook">
    <h1>Đăng ký</h1>
    <label>Username</label>
    <input type="text" name="username" required>
    <label>Password</label>
    <input type="text" name="password" required>
    <label>Emaik</label>
    <input type="text" name="email" required>
    <label>Phone</label>
    <input type="text" name="phone" required>
    <button type="submit" style="margin: 10px">Đăng ký</button>
</form>
<p>Đã có tài khoản!<a href="login.jsp">Đăng nhập</a></p>
</body>
</html>

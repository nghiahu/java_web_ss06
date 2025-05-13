<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 13/05/2025
  Time: 12:37 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <style>
        .formEditBook{
            border: 1px solid black;
            width: 350px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
<body>
<form class="formEditBook" action="<%=request.getContextPath()%>/bookController?action=update&id=<%=request.getAttribute("idUpdate")%>" method="post">
    <h1>Cập nhật sách</h1>
    <label>Tiêu đề</label>
    <input type="text" name="title" value="<%=request.getAttribute("titleUpdate")%>" required>
    <label>Tác giả</label>
    <input type="text" name="author" value="<%=request.getAttribute("authorUpdate")%>" required>
    <label>Thể loại</label>
    <input type="text" name="catalog" value="<%=request.getAttribute("catalogUpdate")%>"required>
    <label>Số lượng</label>
    <input type="number" name="quantity" value="<%=request.getAttribute("quantityUpdate")%>"required>
    <button type="submit" style="margin: 10px">Cập nhật</button>
</form>
</body>
</html>

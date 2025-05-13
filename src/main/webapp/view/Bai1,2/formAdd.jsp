<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 12/05/2025
  Time: 11:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
  .formAddBook{
    border: 1px solid black;
    width: 350px;
    display: flex;
    flex-direction: column;
    align-items: center;
  }
</style>
<body>
  <form class="formAddBook" action="<%=request.getContextPath()%>/bookController?action=add" method="post">
    <h1>Thêm mới sách</h1>
    <label>Tiêu đề</label>
    <input type="text" name="title" required>
    <label>Tác giả</label>
    <input type="text" name="author" required>
    <label>Thể loại</label>
    <input type="text" name="catalog" required>
    <label>Số lượng</label>
    <input type="number" name="quantity" required>
    <button type="submit" style="margin: 10px">Thêm</button>
  </form>
</body>
</html>

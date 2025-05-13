<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nghia
  Date: 12/05/2025
  Time: 5:27 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table{
        border: 1px solid black;
        width: 600px;
    }
    th,td{
        border: 1px solid black;
    }
</style>
<body>
<h1>Danh sách các cuốn sách đã có</h1>
    <table>
        <tr>
            <th>Mã sách</th>
            <th>Tiêu đề</th>
            <th>Tác giả</th>
            <th>Thể loại</th>
            <th>Số lượng</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.category}</td>
                <td>${book.quantity}</td>
                <td>
                    <a href="bookController?action=update&id=${book.id}">
                        <button>Sửa</button>
                    </a>
                    <button onclick="confirmDelete(${book.id})">Xóa</button>
                </td>
            </tr>
        </c:forEach>
    </table>
<a href="bookController?action=add"><button>Thêm sách</button></a>
</body>
</html>
<script type="text/javascript">
    function confirmDelete(id) {
        if (confirm("Bạn có chắc chắn muốn xóa không?")) {
            window.location.href = "bookController?action=delete&id="+id;
        }
    }
</script>

<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-12
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<form action="/Update?id=${sach.id}" method="post">
    <div class="mt-3">
        <lable>Ma</lable>
        <input type="text" name="ma" class="form-control" value="${sach.ma}">
    </div>
    <div class="mt-3">
        <lable>ten</lable>
        <input type="text" name="ten" class="form-control" value="${sach.ten}">
    </div>
    <div class="mt-3">
        <lable>soTrang</lable>
        <input type="text" name="soTrang" class="form-control" value="${sach.soTrang}">
    </div>
    <div class="mt-3">
        <lable>donGia</lable>
        <input type="text" name="donGia" class="form-control" value="${sach.donGia}">
    </div>
    <div class="mt-3">
        <lable>NhaXuatBan</lable>
        <select class="form-select" aria-label="Default select example" name="idNhaXuatBan">
            <option selected hidden value="${sach.nhaXuatBan.id}">${sach.nhaXuatBan.ma}</option>
            <c:forEach items="${listNXB}" var="b">
                <option value="${b.id}">${b.ma}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-success">Update</button>
</form>
</body>
</html>

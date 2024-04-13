<%--
  Created by IntelliJ IDEA.
  User: Admin BVCN88 02
  Date: 2024-04-11
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
<%--    <script>--%>
<%--        &lt;%&ndash; Kiểm tra nếu biến listRong tồn tại và không rỗng thì hiển thị thông báo &ndash;%&gt;--%>
<%--        <% if(request.getAttribute("listRong") != null && !((String)request.getAttribute("listRong")).isEmpty()) { %>--%>
<%--        alert("${listRong}");--%>
<%--        <% } %>--%>
<%--    </script>--%>
    <script>
        <% if(request.getAttribute("listRong")!=null){%>
        alert("${listRong}");
        <% } %>

        <% if(request.getAttribute("maTrung")!=null){%>
        alert("${maTrung}")
        <%}%>
    </script>

</head>
<body>
<div>
    <form action="/Add" method="post">
        <div class="mt-3">
            <lable>Ma</lable>
            <input type="text" name="ma" class="form-control" value="${sach.ma}">
            <p style="color: red">${loiMa}</p>
        </div>
        <div class="mt-3">
            <lable>ten</lable>
            <input type="text" name="ten" class="form-control" value="${sach.ten}">
            <p style="color: red">${loiTen}</p>
        </div>
        <div class="mt-3">
            <lable>soTrang</lable>
            <input type="text" name="soTrang" class="form-control" value="${sach.soTrang}">
            <p style="color: red">${loiTrang}</p>
        </div>
        <div class="mt-3">
            <lable>donGia</lable>
            <input type="text" name="donGia" class="form-control" value="${sach.donGia}">
            <p style="color: red">${LoiGia}</p>
        </div>
        <div class="mt-3">
            <lable>NhaXuatBan</lable>
            <select class="form-select" aria-label="Default select example" name="idNhaXuatBan">
                <c:forEach items="${listNXB}" var="b">
                    <option value="${b.id}">${b.ma}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Add</button>
    </form>
</div>
<table class="table">
    <thead>
    <th>ma</th>
    <th>ten</th>
    <th>soTrang</th>
    <th>donGia</th>
    <th>tenNhaXuatBan</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${listS}" var="a">
        <tr>
            <td>${a.ma}</td>
            <td>${a.ten}</td>
            <td>${a.soTrang}</td>
            <td>${a.donGia}</td>
            <td>${a.tenNhaXuatBan}</td>
            <td>
                <a href="/ViewUpdate?id=${a.id}" class="btn btn-success">Edit</a>
                <a href="/Delete?id=${a.id}" onclick="return confirm('Ban co muon xoa khong ?')"
                   class="btn btn-success">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${pageNumber > 1}">
    <a href="?pageNumber=${pageNumber - 1}&pageSize=${pageSize}" class="btn btn-primary">Previous</a>
</c:if>
<c:if test="${listS.size() == pageSize}">
    <a href="?pageNumber=${pageNumber + 1}&pageSize=${pageSize}" class="btn btn-primary">Next</a>
</c:if>
</body>
</html>

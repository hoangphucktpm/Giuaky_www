<%@ page import="iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Loaithuoc" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/10/2024
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sach loai thuoc</title>
</head>
<body>
<tr>
    <td>21036541 - Huỳnh Hoàng Phúc</td>
</tr>
<tr>
    <td>
        <a href="controller?action=listLoaiThuoc"> Danh sách các loại thuốc</a> |
        <a href="controller?action=listThuoc"> Danh sách thuốc</a> |
        <a href="controller?action=addThuoc"> Thêm thuốc mới</a> |
    </td>
</tr>
<h1>Danh sách loại thuốc</h1>

<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã loại</th>
        <th>Tên loại</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Loaithuoc> loaiThuocList = (List<Loaithuoc>) request.getAttribute("listLoaiThuoc");
        if (loaiThuocList != null) {
            int stt = 1;
            for (Loaithuoc loaithuoc : loaiThuocList) {
    %>
    <tr>
        <td><%= stt++ %>
        </td>
        <td><%= loaithuoc.getId() %>
        </td>
        <td><%= loaithuoc.getTenloai() %>
        </td>
    </tr>
    <%


            }
        }
    %>
    </tbody>
</table>
</body>
</html>

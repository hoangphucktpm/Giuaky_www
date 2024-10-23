<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlythuoc.models.LoaiThuoc" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <tr>
        <td>21036541 - Huỳnh Hoàng Phúc</td>
    </tr>
    <tr>
        <td>
            <a href="controller?action=listLoaiThuoc">Danh sách các loại thuốc</a> |
            <a href="controller?action=listThuoc">Danh sách thuốc</a> |
            <a href="controller?action=addThuoc">Thêm thuốc mới</a>
        </td>
    </tr>
    <title>Danh Sách Loại Thuốc</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h1>Danh Sách Loại Thuốc</h1>
<table>
    <thead>
    <tr>
        <th>Mã loại</th>
        <th>Tên loại</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<LoaiThuoc> loaiThuocList = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");
        if (loaiThuocList != null) {
            for (LoaiThuoc loaiThuoc : loaiThuocList) {
    %>
    <tr>
        <td><%= loaiThuoc.getMaLoai() %></td>
        <td><%= loaiThuoc.getTenLoai() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
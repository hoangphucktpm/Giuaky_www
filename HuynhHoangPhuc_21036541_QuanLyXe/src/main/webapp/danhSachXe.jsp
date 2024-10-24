<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlyxe.models.Loaixe" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlyxe.models.Xe" %>
<html>
<head>
    <title>Danh Sách Xe</title>
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
<tr>
    <td>21036541 - Huỳnh Hoàng Phúc</td>
</tr>
<tr>
    <td>
        <a href="controller?action=listLoaiThuoc">Danh sách các loại xe</a> |
        <a href="controller?action=listThuoc">Danh sách xe</a> |
        <a href="controller?action=addThuoc">Thêm xe mới</a>
    </td>
</tr>
<h1>Danh Sách Xe</h1>

<form method="get" action="controller">
    <input type="hidden" name="action" value="filterByLoai">
    <label for="maLoai">Chọn loại xe:</label>
    <select name="maLoai" id="maLoai">
        <option value="">Tất cả</option>
        <%
            List<Loaixe> loaiXeList = (List<Loaixe>) request.getAttribute("listLoaiXe");
            if (loaiXeList != null) {
                for (Loaixe loaiXe : loaiXeList) {
        %>
        <option value="<%= loaiXe.getMaloai() %>"><%= loaiXe.getTenloai() %></option>
        <%
                }
            }
        %>
    </select>
    <button type="submit">Lọc</button>
</form>

<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Giá</th>
        <th>Năm sản xuất</th>
        <th>Tên xe</th>
        <th>Tên loại</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Xe> xeList= (List<Xe>) request.getAttribute("listXe");
        if (xeList != null) {
            int stt = 1;
            for (Xe xe : xeList) {
    %>
    <tr>
        <td><%= stt++ %></td>
        <td><%= xe.getGia() %></td>
        <td><%= xe.getNamsx() %></td>
        <td><%= xe.getTenxe() %></td>
        <td><%= xe.getMaloai().getTenloai() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
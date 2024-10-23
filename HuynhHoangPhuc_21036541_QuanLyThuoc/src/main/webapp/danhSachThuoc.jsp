<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlythuoc.models.Thuoc" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlythuoc.models.LoaiThuoc" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Danh Sách Thuốc</title>
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
        <a href="controller?action=listLoaiThuoc">Danh sách các loại thuốc</a> |
        <a href="controller?action=listThuoc">Danh sách thuốc</a> |
        <a href="controller?action=addThuoc">Thêm thuốc mới</a>
    </td>
</tr>
<h1>Danh Sách Thuốc</h1>

<form method="get" action="controller">
    <input type="hidden" name="action" value="filterByLoai">
    <label for="maLoai">Chọn loại thuốc:</label>
    <select name="maLoai" id="maLoai">
        <option value="">Tất cả</option>
        <%
            List<LoaiThuoc> loaiThuocList = (List<LoaiThuoc>) request.getAttribute("loaiThuocList");
            if (loaiThuocList != null) {
                for (LoaiThuoc loaiThuoc : loaiThuocList) {
        %>
        <option value="<%= loaiThuoc.getMaLoai() %>"><%= loaiThuoc.getTenLoai() %></option>
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
        <th>Tên thuốc</th>
        <th>Mã loại</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Thuoc> thuocList = (List<Thuoc>) request.getAttribute("thuocList");
        if (thuocList != null) {
            int stt = 1;
            for (Thuoc thuoc : thuocList) {
    %>
    <tr>
        <td><%= stt++ %></td>
        <td><%= thuoc.getGia() %></td>
        <td><%= thuoc.getNamSx() %></td>
        <td><%= thuoc.getTenThuoc() %></td>
        <td><%= thuoc.getMaLoai().getTenLoai() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
<%@ page import="java.util.List" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Thuoc" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Loaithuoc" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 25/10/2024
  Time: 12:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách thuốc</title>
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
<h1>Danh sách thuốc</h1>
<form method="get" action="controller">
    <input type="hidden" name="action" value="listThuocByLoai">
    <label for="maloai">Chon loại xe:</label>
    <select name="maloai" id="maloai">
        <option value="">Tất cả</option>
        <%
            List<Loaithuoc> loaithuocList = (List<Loaithuoc>)
                    request.getAttribute("listLoaiThuoc");
            if (loaithuocList != null) {
                for (Loaithuoc loaithuoc : loaithuocList) {
        %>
        <option value="<%= loaithuoc.getId()%>"><%= loaithuoc.getTenloai()%>
        </option>
        <%
                }
            }
        %>
    </select>
    <button type="submit">Lọc</button>
</form>

<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên thuốc</th>
        <th>Giá</th>
        <th>Năm sản xuất</th>
        <th>Tên loại</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Thuoc> thuocList = (List<Thuoc>) request.getAttribute("listThuoc");
        if (thuocList != null) {
            int stt = 1;
            for (Thuoc thuoc : thuocList) {
    %>
    <tr>
        <td><%= stt++ %>
        </td>
        <td><%= thuoc.getTenthuoc() %>
        </td>
        <td><%= thuoc.getGia() %>
        </td>
        <td><%= thuoc.getNamsx() %>
        </td>
        <td><%= thuoc.getMaloai().getTenloai() %>
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

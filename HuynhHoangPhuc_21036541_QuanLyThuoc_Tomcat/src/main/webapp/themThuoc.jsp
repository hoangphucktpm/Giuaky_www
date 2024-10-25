<%@ page import="java.util.List" %>
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
    <title>Title</title>
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
<h1>Thêm thuốc mới</h1>
<form action="controller" method="post">
    <input type="hidden" name="action" value="add">

    <label for="mathuoc">Mã thuốc:</label>
    <input type="text" id="mathuoc" name="mathuoc" required><br><br>

    <label for="tenthuoc">Tên thuốc:</label>
    <input type="text" id="tenthuoc" name="tenthuoc" required><br><br>

    <label for="gia">Gia thuốc:</label>
    <input type="text" id="gia" name="gia" required><br><br>

    <label for="namsx">Năm sản xuất:</label>
    <input type="text" id="namsx" name="namsx" required><br><br>

    <label for="maloai">Loại xe:</label>
    <select id="maloai" name="maloai" required>
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
        } else {
        %>
        <option value="">No</option>
        <%
            }
        %>
    </select> <br><br>

    <button type="submit">Teem thuoc</button>


</form>

</body>
</html>

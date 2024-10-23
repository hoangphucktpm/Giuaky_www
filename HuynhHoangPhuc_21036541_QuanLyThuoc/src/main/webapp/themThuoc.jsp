<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlythuoc.models.LoaiThuoc" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Thêm Thuốc Mới</title>
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
<h1>Thêm Thuốc Mới</h1>
<form action="controller" method="post">
    <input type="hidden" name="action" value="addThuocSubmit">
    <label for="maThuoc">Mã Thuốc:</label>
    <input type="text" id="maThuoc" name="maThuoc" required><br><br>

    <label for="tenThuoc">Tên Thuốc:</label>
    <input type="text" id="tenThuoc" name="tenThuoc" required><br><br>

    <label for="gia">Giá:</label>
    <input type="number" id="gia" name="gia" step="0.01" required><br><br>

    <label for="namSx">Năm Sản Xuất:</label>
    <input type="number" id="namSx" name="namSx" required><br><br>

    <label for="maLoai">Loại Thuốc:</label>
    <select id="maLoai" name="maLoai" required>
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
    </select><br><br>

    <button type="submit">Thêm Thuốc</button>
</form>
</body>
</html>
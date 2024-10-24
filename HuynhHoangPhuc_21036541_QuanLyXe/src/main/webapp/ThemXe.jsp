<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlyxe.models.Loaixe" %>
<html>
<head>
    <title>Thêm Xe Mới</title>
</head>
<body>
<table>
    <tr>
        <td>21036541 - Huỳnh Hoàng Phúc</td>
    </tr>
    <tr>
        <td>
            <a href="controller?action=listLoaiXe">Danh sách các loại xe</a> |
            <a href="controller?action=listXe">Danh sách xe</a> |
            <a href="controller?action=addXe">Thêm xe mới</a>
        </td>
    </tr>
</table>
<h1>Thêm Xe Mới</h1>
<form action="controller" method="post">
    <input type="hidden" name="action" value="addXeSubmit">

    <label for="maXe">Mã Xe:</label>
    <input type="text" id="maXe" name="maXe" required><br><br>

    <label for="tenXe">Tên Xe:</label>
    <input type="text" id="tenXe" name="tenXe" required><br><br>

    <label for="gia">Giá:</label>
    <input type="number" id="gia" name="gia" step="0.01" required><br><br>

    <label for="namSx">Năm Sản Xuất:</label>
    <input type="number" id="namSx" name="namSx" required><br><br>

    <label for="maLoai">Loại Xe:</label>
    <select id="maLoai" name="maLoai" required>
        <%
            List<Loaixe> loaiXeList = (List<Loaixe>) request.getAttribute("listLoaiXe");
            if (loaiXeList != null) {
                for (Loaixe loaiXe : loaiXeList) {
        %>
        <option value="<%= loaiXe.getMaloai() %>"><%= loaiXe.getTenloai() %></option>
        <%
            }
        } else {
        %>
        <option value="">No types available</option>
        <%
            }
        %>
    </select><br><br>

    <button type="submit">Thêm Xe</button>
</form>
</body>
</html>
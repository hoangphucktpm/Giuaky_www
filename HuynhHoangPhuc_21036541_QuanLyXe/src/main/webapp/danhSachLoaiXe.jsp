<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.huynhhoangphuc_21036541_quanlyxe.models.Loaixe" %>
<html>
<head>
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
  <title>Danh Sách Loại Xe</title>
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
<h1>Danh Sách Loại Xe</h1>
<table>
  <thead>
  <tr>
    <th>Mã loại</th>
    <th>Tên loại</th>
  </tr>
  </thead>
  <tbody>
  <%
    List<Loaixe> loaiXeList = (List<Loaixe>) request.getAttribute("listLoaiXe");
    if (loaiXeList != null) {
      for (Loaixe loaixe : loaiXeList) {
  %>
  <tr>
    <td><%= loaixe.getMaloai() %></td>
    <td><%= loaixe.getTenloai() %></td>
  </tr>
  <%
      }
    }
  %>
  </tbody>
</table>
</body>
</html>
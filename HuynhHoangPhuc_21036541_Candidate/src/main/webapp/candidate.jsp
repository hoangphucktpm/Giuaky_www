<%@ page import="iuh.huynhhoangphuc_21036541_candidate.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate List</title>
</head>
<body>
<h1>Danh sách Candidate</h1>
<table border="1">
    <thead>
    <tr>
        <th>STT</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Full Name</th>
        <th>Details</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidates");
        if (candidateList != null) {
            int stt = 1;
            for (Candidate candidate : candidateList) {
    %>
    <tr>
        <td><%= stt++ %></td>
        <td><%= candidate.getPhone() %></td>
        <td><%= candidate.getEmail() %></td>
        <td><%= candidate.getFullName() %></td>
        <td><a href="controller?action=viewCandidate&id=<%= candidate.getId() %>">View Details</a></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
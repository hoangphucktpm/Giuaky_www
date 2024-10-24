<%@ page import="iuh.huynhhoangphuc_21036541_candidate.models.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 2 - Candidates with at least 5 years of experience</title>
</head>
<body>
<h1>Report 2 - Candidates with at least 5 years of experience</h1>

<%
    List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidates");
    if (candidateList != null && !candidateList.isEmpty()) {
%>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Full Name</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Candidate candidate : candidateList) {
    %>
    <tr>
        <td><%= candidate.getId() %></td>
        <td><%= candidate.getPhone() %></td>
        <td><%= candidate.getEmail() %></td>
        <td><%= candidate.getFullName() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
} else {
%>
<p>No candidates found with at least 5 years of experience.</p>
<%
    }
%>
</body>
</html>
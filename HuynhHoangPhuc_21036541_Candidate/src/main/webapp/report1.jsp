<%@ page import="iuh.huynhhoangphuc_21036541_candidate.models.Candidate" %>
<%@ page import="iuh.huynhhoangphuc_21036541_candidate.enums.Roles" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 1 - Candidates by Role</title>
</head>
<body>
<h1>Report 1 - Candidates by Role</h1>
<form action="controller" method="get">
    <input type="hidden" name="action" value="report1">
    <label for="role">Select Role:</label>
    <select id="role" name="role">
        <%
            for (Roles role : Roles.values()) {
        %>
        <option value="<%= role.name() %>"><%= role.name() %></option>
        <%
            }
        %>
    </select>
    <button type="submit">View</button>
</form>

<%
    List<Candidate> candidateList = (List<Candidate>) request.getAttribute("candidates");
    if (candidateList != null && !candidateList.isEmpty()) {
%>
<h2>List of Candidates who worked as <%= request.getParameter("role") %></h2>
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
} else if (request.getParameter("role") != null) {
%>
<p>No candidates found for the selected role.</p>
<%
    }
%>
</body>
</html>
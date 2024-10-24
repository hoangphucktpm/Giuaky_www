<%@ page import="iuh.huynhhoangphuc_21036541_candidate.models.Candidate" %>
<%@ page import="iuh.huynhhoangphuc_21036541_candidate.models.Experience" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Candidate Details</title>
</head>
<body>
<%
  Candidate candidate = (Candidate) request.getAttribute("candidate");
  if (candidate != null) {
%>
<h1>Candidate Details</h1>
<p><strong>ID:</strong> <%= candidate.getId() %></p>
<p><strong>Phone:</strong> <%= candidate.getPhone() %></p>
<p><strong>Email:</strong> <%= candidate.getEmail() %></p>
<p><strong>Full Name:</strong> <%= candidate.getFullName() %></p>

<h2>Experiences</h2>
<table border="1">
  <thead>
  <tr>
    <th>Company</th>
    <th>From Date</th>
    <th>To Date</th>
    <th>Role</th>
    <th>Work Description</th>
  </tr>
  </thead>
  <tbody>
  <%
    for (Experience experience : candidate.getExperiences()) {
  %>
  <tr>
    <td><%= experience.getCompanyName() %></td>
    <td><%= experience.getFromDate() %></td>
    <td><%= experience.getToDate() %></td>
    <td><%= experience.getRole() %></td>
    <td><%= experience.getWorkDescription() %></td>
  </tr>
  <%
    }
  %>
  </tbody>
</table>
<%
} else {
%>
<p>Candidate not found.</p>
<%
  }
%>
</body>
</html>
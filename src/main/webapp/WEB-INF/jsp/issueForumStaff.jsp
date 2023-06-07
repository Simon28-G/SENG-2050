<%--
  Created by IntelliJ IDEA.
  User: lgala
  Date: 4/06/2023
  Time: 12:53 am
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Incident Report System</title>
  <link rel="stylesheet" href="../css/issuesPagesStyle.css">
  <script src="../js/issueForumSort.js"></script>
</head>
<body>
<h1>Welcome to the Incident Report System</h1>

<div class="navbar">
  <a href="issueForumStaff.jsp">Issues</a>
  <a href="#">Knowledge Base</a>
  <a href="#">Log out</a>
</div>

<h2>Issue List</h2>
<table id="issueTable">
  <tr>
    <th onclick="sortTable(0)">Title</th>
    <th onclick="sortTable(1)">Status</th>
    <th onclick="sortTable(2)">Reporting Date</th>
    <th onclick="sortTable(3)">Category</th>
    <th onclick="sortTable(4)">Assigned Staff</th>
  </tr>
  <s:iterator value="issueList"> <%-- 'issueList' WILL BE THE ARRAY THAT STORES THE ISSUES --%>
    <tr>
      <td><s:property value="title"/></td>
      <td><s:property value="status"/></td>
      <td><s:property value="dateReported"/></td>
      <td><s:property value="category"/></td>
      <td><s:property value="staffId"/></td>
    </tr>
  </s:iterator>
  <!-- Add more rows with issue data from the database -->
</table>
<footer>
  <p><em>Logged in as: Staff member</em></p>
</footer>
</body>
</html>

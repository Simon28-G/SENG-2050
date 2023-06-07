<%--
  Created by IntelliJ IDEA.
  User: nathanvilmen
  Date: 07/06/2023
  Time: 17:41
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
  <a href="issueForumUser.jsp">Issues</a>
  <a href="#">Knowledge Base</a>
  <a href="#">Log out</a>
</div>

<s:form action="searchAction">
  <s:textfield name="searchQuery" placeholder="Search..." />
  <s:submit value="Search" />
</s:form>

<h2>Issue List</h2>
<table id="issueTable">
  <tr>
    <th onclick="sortTable(0)">Title</th>
    <th onclick="sortTable(1)">Status</th>
    <th onclick="sortTable(2)">Reporting Date</th>
    <th onclick="sortTable(3)">Category</th>
    <th onclick="sortTable(4)">Assigned Staff</th>
  </tr>
  <s:iterator value="issueSearchList"> <%-- 'issueList' WILL BE THE ARRAY THAT STORES THE ISSUES --%>
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
  <p><em>Logged in as: </em></p>
</footer>
</body>
</html>

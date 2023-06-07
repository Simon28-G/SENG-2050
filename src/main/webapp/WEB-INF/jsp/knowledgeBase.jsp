<%--
  Created by IntelliJ IDEA.
  User: nathanvilmen
  Date: 07/06/2023
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="app.PersonBean" %>
<%@ page import="app.UserBean" %>
<%@ page import="app.ManagerBean" %>
<%@ page import="app.StaffBean" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
  PersonBean person = (PersonBean) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Incident Report System</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/issuesPagesStyle.css">
  <script src="${pageContext.request.contextPath}/js/issueForumSort.js"></script>
</head>
<body>
<h1>Knowledge Base</h1>
<h3>Here you can find all the resolved issues that can help you into finding a solution to your problem.</h3>

<div class="navbar">
  <s:a action="issueForumUser">Issues</s:a>
  <s:a class="active" action="knowledgeBase">Knowledge Base</s:a>
  <s:a action="logout">Log out</s:a>
</div>

<div class="search-container">
  <s:form action="searchAction" class="search container">
    <s:textfield name="searchQuery" placeholder="Search..." style="margin-right: 10px;" class="input"/>
    <s:submit value="Search" class="button"/>
  </s:form>
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
  <p><em>Logged in as:
    <%if (person instanceof UserBean){%>User
    <%} else if (person instanceof ManagerBean){%>Manager
    <%} else if (person instanceof StaffBean){%>Staff member
    <%}%>
  </em></p>
</footer>
</body>
</html>

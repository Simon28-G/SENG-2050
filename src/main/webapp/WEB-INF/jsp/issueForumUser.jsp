<%--
  Created by IntelliJ IDEA.
  User: lgala
  Date: 4/06/2023
  Time: 12:53 am
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
    <script src="../js/issueForumSort.js"></script>
</head>
<body>
<h1>Welcome to the Incident Report System</h1>

<div class="navbar">
    <s:a action="issueForumUser">Issues</s:a>
    <s:a action="knowledgeBase">Knowledge Base</s:a>
    <s:a action="logout">Log out</s:a>
</div>


<div style="display: flex;">
    <s:form action="searchAction" style="display: flex;">
        <s:textfield name="searchQuery" placeholder="Search..." />
        <s:submit value="Search" />
    </s:form>

    <s:form action="displayIssueForm" style="margin-left: auto;">
        <s:submit value="New Issue" />
    </s:form>
</div>


<h2>List of the issues</h2>
<table id="issueTable">
    <tr>
        <th onclick="sortTable(0)">Title</th>
        <th onclick="sortTable(1)">State</th>
        <th onclick="sortTable(2)">Reporting Date</th>
        <th onclick="sortTable(3)">Category</th>
        <th onclick="sortTable(4)">Assigned Staff</th>
    </tr>

    <s:iterator value="issuesList">
        <tr>
            <td><s:property value="title"/></td>
            <td><s:property value="state"/></td>
            <td><s:property value="dateReported"/></td>
            <td><s:property value="category"/></td>
            <td><s:property value="staffId"/></td>
        </tr>
    </s:iterator>
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

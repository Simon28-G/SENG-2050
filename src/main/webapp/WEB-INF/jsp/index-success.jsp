<%--
  Created by IntelliJ IDEA.
  User: lgala
  Date: 2/06/2023
  Time: 10:19 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Issue Forum</title>
</head>
<body>
<div>
    <button class="dropbtn">Menu</button>
    <div>
        <a href="#">Issues</a>
        <a href="#">Knowledge Base</a>
        <a href="#">Assigned Issues</a>
        <a href="#">Log Out</a>
    </div>
</div>
<table>
    <tr>
        <th><button onclick="sortByTitle">Title</button></th>
        <th><button onclick="sortByStatus">Status</button></th>
        <th><button onclick="sortByDate">Reported Date</button></th>
        <th><button onclick="sortByCategory">Category</button></th>
        <th><button onclick="sortByStaff">Assigned Staff</button></th>
    </tr>
    <s:iterator value="issueList"> <%-- 'issueList' WILL BE THE ARRAY THAT STORES THE ISSUES --%>
        <tr>
            <td><s:property value="issueId"/></td>
            <td><s:property value="title"/></td>
            <td><s:property value="status"/></td>
            <td><s:property value="dateReported"/></td>
            <td><s:property value="Category"/></td>
            <td><s:property value="staffId"/></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lgala
  Date: 2/06/2023
  Time: 10:20 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page import="org.apache.struts2.ServletActionContext" %>
<%@ page import="app.PersonBean" %>
<%@ page import="app.UserBean" %>
<%@ page import="app.ManagerBean" %>
<%@ page import="app.StaffBean" %>

<%
    PersonBean person = (PersonBean) session.getAttribute("user");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Issue Display</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/issuesPagesStyle.css">
</head>
<body>

<s:form action="issueForumUser" style="margin-left: auto;">
    <s:submit value="Back" class="newButton"/>
</s:form>

<h1>Issue</h1>

<h2>Title: <s:property value="issue.title" /></h2>
<p>Description:</p>
    <div class="s-property-value"><s:property value="issue.description"/></div>
<p>Status: </p>
    <div class="s-property-value"><s:property value="issue.state"/></div>
<p>Issue reporting date: </p>
    <div class="s-property-value"> <s:property value="issue.dateReported"/> </div>
<p>Category:</p>
    <div class="s-property-value"><s:property value="issue.category"/></div>
<p>ID of the staff member assigned:</p>
    <div class="s-property-value"><s:property value="issue.staffId"/></div>
<c:if test="${issue.file != null}">
<a href="downloadFile">Download File</a>
</c:if>

<table>
    <tr>
        <th>Comments:</th>
    </tr>
    <s:iterator value="commentList">
        <tr>
            <td><s:property value="staffId"/></td>
            <td><s:property value="commentText"/></td>
            <td><s:form action="replyComment" style="margin-left: auto;">
                <s:submit value="Reply" class="newButton"/>
            </s:form></td>
        </tr>
    </s:iterator>
</table>
<div>
    <s:form action="addComment" style="margin-left: auto;">
        <s:submit value="Add Comment" class="newButton"/>
    </s:form>
    <% if (person instanceof ManagerBean){%>
    <s:form action="addToKB" style="margin-left: auto;">
        <s:submit value="Add to Knowledge Base" class="newButton"/>
    </s:form>
    <%}%>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: nathanvilmen
  Date: 2/06/2023
  Time: 3:09 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>Issue Form</title>
    <link rel="stylesheet" href="../css/issueFormStyle.css">
</head>
<body>
<div class="navbar">
    <a href="#">Issues</a>
    <a href="#">Knowledge Base</a>
    <a href="#">Log out</a>
</div>
<h1>New Issue</h1>

<s:form action="submitIssue" enctype="multipart/form-data">
    <s:textfield id="title" name="issue.title" label="Issue Title" placeholder="Title" /><br/>
    <s:textarea id="description" name="issue.description" placeholder="Description" label="Issue Description"/>
    <s:select label="Category" headerKey="-1" headerValue="-- Select a category -- " list="{'NETWORK', 'SOFTWARE', 'HARDWARE', 'EMAIL', 'ACCOUNT'}" name="issue.category" value="defaultCategory"/>
    <s:file id="file" name="issue.file" label="File" />
    <s:submit value="Submit" />
</s:form>

</body>
</html></html>
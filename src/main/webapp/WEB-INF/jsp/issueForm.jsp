<%--
  Created by IntelliJ IDEA.
  User: lgala
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

<s:form action="submitIssue" name="issueForm" method="POST">
    <label for="title">Issue Title:</label>
    <input id="title" name="title" /><br/>
    <label for="desc">Issue Description:</label>
    <input id="desc" type="text" name="description"/>
    <label for="category">Category:</label>
    <select id="category" name="category" list="dropDownValues">
        <option>NETWORK</option>
        <option>SOFTWARE</option>
        <option>HARDWARE</option>
        <option>EMAIL</option>
        <option>ACCOUNT</option>
    </select>
    <label for="file">File:</label>
    <input id="file" name="file" type="file" label="File"/>
    <input type="submit"/>
</s:form>

</body>
</html></html>
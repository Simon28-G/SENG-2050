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
    <h1>New Issue</h1>

    <s:form action="submitForm">
        <s:textfield name="title" label="Title"/>
        <s:textfield name="description" label="Description"/>
        <s:textfield name="category" label="Category"/>
        <s:textfield name="tags" label="Tags"/>
        <s:textfield name="file" label="File"/>
        <s:submit value="Submit"/>
    </s:form>

</body>
</html>

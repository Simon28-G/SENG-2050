<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 07/06/2023
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Issue Form</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/issueFormStyle.css">
</head>
<body>

<s:a action="issueForumUser">Back</s:a>

<h1>Assign a resolver to the issue</h1>

<s:form action="submitResolverPerson">
  <s:set var="issueID" value="issueID" />
  <s:hidden name="issueID" value="%{#issueID}" />
    <s:select label="Select Staff" headerValue="-- Select a staff person -- " list="staffMap" listKey="key" listValue="value" value="%{staffMap[key]}"/>
  <s:submit value="Submit" />
</s:form>

</body>
</html>

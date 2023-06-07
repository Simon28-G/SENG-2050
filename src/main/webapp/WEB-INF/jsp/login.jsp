<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 02/06/2023
  Time: 00:27
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginFormStyle.css">
</head>
<body>
    <s:form action="login" method="post">
        <h3>Login</h3>
        <s:textfield name="credentialHolder.username" placeholder="Enter Username" label="Username"/>
        <s:password  name="credentialHolder.password" placeholder="Enter Password" label="Password" />
        <br/>
        <s:submit value="login" />
    </s:form>

</body>
</html>

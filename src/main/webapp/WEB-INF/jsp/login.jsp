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
    <link rel="stylesheet" type="text/css" href="../css/loginFormStyle.css">
</head>
<body>
    <s:form action="login" method="POST">
        <h3>Login</h3>
        <s:textfield id="username" name="username" placeholder="Enter Username" label="Username"/>
        <s:password id="password" name="password" placeholder="Enter Password" label="Password" />
        <br/>
        <s:submit name="login" value="Login" />
    </s:form>

</body>
</html>

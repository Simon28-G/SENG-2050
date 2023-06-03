<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 02/06/2023
  Time: 00:27
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form action="auth/AuthAction" name="loginForm" method="POST">
        <h3>Login</h3>
        <label for="username">Username: </label>
        <input id="username" type="text" name="username" placeholder=" Enter Username">
        <label for="password">Password: </label>
        <input id="password" type="password" name="password" placeholder="Enter Password">
        <input type="submit" name="login" value="Login"/>
    </form>

</body>
</html>

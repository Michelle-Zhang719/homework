<%--
  Created by IntelliJ IDEA.
  User: minjie
  Date: 2023/5/17
  Time: 22:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
  <form action="/user/login" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit">
  </form>

</body>
</html>

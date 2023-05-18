<%--
  Created by IntelliJ IDEA.
  User: minjie
  Date: 2023/5/17
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

    <form action="/user/register" method="post" enctype="multipart/form-data">

        <input type="text" name="username">
        <input type="password" name="password">
        <input type="file" name="image">
        <input type="submit">
    </form>
</body>
</html>

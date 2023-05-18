<%--
  Created by IntelliJ IDEA.
  User: minjie
  Date: 2023/5/17
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
    <form action="/user/info" method="get">
        ${user.username}
        ${user.password}
        ${user.imageurl}
    </form>

</body>
</html>

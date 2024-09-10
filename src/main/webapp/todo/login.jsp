<%--
  Created by IntelliJ IDEA.
  User: blueb
  Date: 2024-09-10
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="/login", method="post">
<div>
    <span>아이디  <input type="text" name="mid" placeholder="input id"></span>
</div>
<div>
    <span>비밀번호  <input type="text" name="mpw" placeholder="input password"></span>
</div>
<button type="submit">Login</button>
</form>
</body>
</html>

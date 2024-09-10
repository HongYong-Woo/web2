<%--
  Created by IntelliJ IDEA.
  User: blueb
  Date: 2024-09-10
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
    <c:if test="${param.result == 'error'}"><h1>로그인 에러 발생</h1></c:if>

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

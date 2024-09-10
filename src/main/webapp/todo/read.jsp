<%--
  Created by IntelliJ IDEA.
  User: blueb
  Date: 2024-09-04
  Time: 오후 5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Read Page</title>
</head>
<body>
<div><input type="text" value="${dto.tno}" readonly></div>
<div><input type="text" value="${dto.title}" readonly></div>
<div><input type="date" value="${dto.dueDate}" readonly></div>
<div><input type="checkbox"  ${dto.finished ? "checked" : ""} disabled></div>
<a href="/todo/modify?tno=${dto.tno}">Modify/Remove</a>
<a href="/todo/list">List</a>
</body>
</html>

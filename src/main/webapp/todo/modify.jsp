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
    <title>Modift Page</title>
</head>
<body>
    <form action="/todo/modify" method="post">
        <div><input type="text" name="tno" value="${dto.tno}" readonly></div>
        <div><input type="text" name="title" value="${dto.title}" ></div>
        <div><input type="date" name="date" value="${dto.dueDate}" ></div>
        <div><input type="checkbox" name="finished"  ${dto.finished ? "checked" : ""} ></div>
        <button type="submit">Modify</button>
    </form>
    <form action="/todo/remove" method="post">
        <div><input type="hidden" name="tno" value="${dto.tno}"></div>
        <button type="submit">Remove</button>
    </form>

</body>
</html>

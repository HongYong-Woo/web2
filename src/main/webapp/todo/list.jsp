<%--
  Created by IntelliJ IDEA.
  User: blueb
  Date: 2024-09-04
  Time: 오후 5:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todo List Page</title>
</head>
<body>
    <h1>Todo List</h1>
    <%--        ${dtolist}--%>
<%--    ${dtolist[0].tno} --- ${dtolist[0].title} --- ${dtolist[0].dueDate}--%>

<%--    <h3>${1+2+3}</h3>--%>
<%--    <h3>${"AAA" += "BBB"}</h3>--%>
<%--    <h3>${"AAA".equals("aaa")}</h3>--%>

<%--<ul>
    <c:forEach var="dto" items="${dtolist}">
        <li>${dto}</li>
    </c:forEach>
</ul>--%>
    <ul>
        <c:forEach var="dto" items="${dtoList}">
        <li><span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>
            <span>${dto.title}</span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "DONE" : "NOT YET"}</span>
<%--        <c:choose><c:when test="${dto.finished == true}">DONE</c:when><c:otherwise>NOT YET</c:otherwise></c:choose></li>--%>
        </c:forEach>
    </ul>

    <form action="/todo/register" method="get">
        <button type="submit">register</button>
    </form>
    <form action="/logout" method="post">
        <button type="submit">Logout</button>
    </form>

</body>
</html>

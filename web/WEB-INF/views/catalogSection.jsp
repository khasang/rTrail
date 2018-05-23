<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Товары</title>
</head>
<h1>Товары</h1>
<ul>
    <c:forEach items="${elements}" var="element">
        <li><a href="${element.key}">${element.value}</a></li>
    </c:forEach>
</ul>
<p><a href="/catalog/">&larr;&nbsp;назад</a></p>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Каталог товаров</title>
</head>
<body>
<h1>Каталог товаров</h1>
<ul>
    <c:forEach items="${sections}" var="section">
        <li><a href="${section.key}">${section.value}</a></li>
    </c:forEach>
</ul>
</body>
</html>

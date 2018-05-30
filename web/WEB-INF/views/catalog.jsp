<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
</head>
<h1>${h1}</h1>
<p>${text}</p>
<c:if test="${links != null && links.size() > 0}">
    <ul>
        <c:forEach items="${links}" var="link">
            <li><a href="${link.key}">${link.value}</a></li>
        </c:forEach>
    </ul>
</c:if>
<p><a href="${back}">&larr;&nbsp;назад</a></p>
</body>
</html>

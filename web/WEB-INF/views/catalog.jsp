<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
</head>
<h1>${h1}</h1>
<p>${text}</p>
<c:if test="${sections != null && sections.size() > 0}">
    <ul>
        <c:forEach items="${sections}" var="section">
            <li><a href="${section.key}">${section.value}</a></li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>

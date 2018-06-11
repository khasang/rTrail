<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/catalog.css">
</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-12">
            <h1>${h1}</h1>
        </div>
    </div>
    <c:if test="${breadcrumbs != null && breadcrumbs.size() > 0}">
        <div class="row">
            <div class="col-md-12">
                <ol class="breadcrumb">
                    <c:forEach items="${breadcrumbs}" var="link" varStatus="status">
                        <c:choose>
                            <c:when test="${status.count eq breadcrumbs.size()}">
                                <li class="active">${link.value}</li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${link.key}">${link.value}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ol>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="col-md-4">
            <div class="list-group">
                <c:forEach items="${leftMenu}" var="menuItem">
                    <a href="${menuItem.link}"
                       class="list-group-item<c:if test="${menuItem.active}"> active</c:if>">${menuItem.name}</a>

                    <c:if test="${menuItem.selected && menuItem.subMenu != null && menuItem.subMenu.size() > 0}">
                        <div class="collapse-off list-group-submenu" id="sub_categoria_4">
                            <c:forEach items="${menuItem.subMenu}" var="subMenuItem">
                                <a href="${subMenuItem.link}"
                                   class="list-group-item sub-item<c:if test="${subMenuItem.active}">
                                   active</c:if>">${subMenuItem.name}</a>
                            </c:forEach>
                        </div>
                    </c:if>

                </c:forEach>
            </div>
        </div>
        <div class="col-md-8">${text}</div>
    </div>
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-8"><p><a href="${back}">&larr;&nbsp;назад</a></p></div>
    </div>
</div>


<br/><br/>


</body>
</html>

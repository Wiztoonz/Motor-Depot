<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/session/sessionAdmin.jsp"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<html lang="${sessionScope.language}">
<head>
    <meta charset="UTF-8">
    <script src="${pageContext.request.contextPath}/www/js/jquery.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/www/css/materialize.min.css"  media="screen,projection"/>
    <title><fmt:message key="language.admin"/></title>
</head>
<body>

    <div class="wrapper">
        <div class="header">
            <div class="inner-header">
                <nav>
                    <div class="nav-wrapper light-blue darken-4">
                        <ul id="nav-mobile" class="left hide-on-med-and-down">
                            <li><a href="exit"><fmt:message key="language.log.out"/></a></li>
                        </ul>
                        <ul class="right">
                            <li><a class='dropdown-trigger btn light-blue darken-4' href='#' data-target='dropdown'><fmt:message key="language.control.panel"/></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <ul id='dropdown' class='dropdown-content'>
            <li><a href="admin/car"><fmt:message key="language.a.cars"/></a></li>
            <li><a href="admin/flight"><fmt:message key="language.flights"/></a></li>
            <li><a href="admin/registration"><fmt:message key="language.users"/></a></li>
        </ul>
    </div>


    <script src="${pageContext.request.contextPath}/www/js/materialize.min.js"></script>
    <script>
        $('.dropdown-trigger').dropdown();
    </script>
</body>
</html>

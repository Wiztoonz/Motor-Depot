<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/session/sessionDriver.jsp"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<html lang="${sessionScope.language}">
<head>
    <meta charset="UTF-8">
    <script src="${pageContext.request.contextPath}/www/js/jquery.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/www/css/materialize.min.css"  media="screen,projection"/>
    <title>Driver</title>
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
                            <li><a href="driver/request"><fmt:message key="language.control.panel"/></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/www/js/materialize.min.js"></script>
</body>
</html>

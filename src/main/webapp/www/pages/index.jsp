<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/session/sessionPages.jsp"%>
<c:if test="${not empty param.language}">
    <c:set var="language" value="${param.language}" scope="session"/>
</c:if>
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="language" var="msg"/>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="${pageContext.request.contextPath}/www/js/jquery.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/www/css/materialize.min.css"  media="screen,projection"/>
    <title><fmt:message bundle="${msg}" key="language.motor.depot"/></title>
</head>
<body>
    <div class="wrapper  light-blue darken-3">
        <div class="header">
            <div class="inner-header">
                <nav>
                    <div class="nav-wrapper light-blue darken-4">
                        <span class="brand-logo center"><fmt:message bundle="${msg}" key="language.motor.depot"/></span>
                        <ul id="nav-mobile" class="right hide-on-med-and-down">
                            <li><a href="login"><fmt:message bundle="${msg}" key="language.sing.in"/></a></li>
                            <li><a href="registration"><fmt:message bundle="${msg}" key="language.registration"/></a></li>
                        </ul>
                        <ul class="left">
                            <li><a class='dropdown-trigger btn light-blue darken-4'  href='#' data-target='dropdown' style="width: 150px; min-width: 150px; max-width: 150px;"><fmt:message bundle="${msg}" key="language.language"/></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
            <ul id='dropdown' class='dropdown-content'>
                <li><a href="main?language=ru"><fmt:message bundle="${msg}" key="language.russian"/></a></li>
                <li><a href="main?language=en"><fmt:message bundle="${msg}" key="language.english"/></a></li>
            </ul>
        </div>
        <div class="row">
            <div class="sidebar-left">
                <div class="inner-sidebar-left">
                    <div class="col s6">
                        <div class="card">
                            <div class="card-image">
                                <img alt="" src="${pageContext.request.contextPath}/www/pages/images/car.png">
                                <span class="card-title"><fmt:message bundle="${msg}" key="language.passenger.transportation"/></span>
                            </div>
                            <div class="card-content">
                                <p><fmt:message bundle="${msg}" key="language.comfortable.car.transportation"/>.</p>
                            </div>
                            <div class="card-action">
                                <span><fmt:message bundle="${msg}" key="language.cars"/></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="sidebar-right">
                <div class="inner-sidebar-right">
                    <div class="col s6">
                        <div class="card">
                            <div class="card-image">
                                <img alt="" src="${pageContext.request.contextPath}/www/pages/images/bigCar.jpg">
                                <span class="card-title"><fmt:message bundle="${msg}" key="language.freight.transportation"/></span>
                            </div>
                            <div class="card-content">
                                <p><fmt:message bundle="${msg}" key="language.comfortable.transportation.by.truck"/>.</p>
                            </div>
                            <div class="card-action">
                                <span><fmt:message bundle="${msg}" key="language.trucks"/></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="page-footer light-blue darken-4">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text"><fmt:message bundle="${msg}" key="language.motor.depot"/></h5>
                        <p class="grey-text text-lighten-4"><fmt:message bundle="${msg}" key="language.transportations.on.automobile.and.trucks.with.a.quality.guarantee.only.from.us"/>.</p>
                    </div>
                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text"><fmt:message bundle="${msg}" key="language.links"/></h5>
                        <ul>
                            <li><a class="grey-text text-lighten-3" href="#"><fmt:message bundle="${msg}" key="language.cooperation"/>.</a></li>
                            <li><a class="grey-text text-lighten-3" href="#"><fmt:message bundle="${msg}" key="language.more.about.us"/>.</a></li>
                            <li><a class="grey-text text-lighten-3" href="#"><fmt:message bundle="${msg}" key="language.partners"/>.</a></li>
                        </ul>
                    </div>
                </div>
                <div class="footer-copyright">
                    <div class="container center">
                        <span>© 2019 Copyright MotorDepot</span>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/www/js/materialize.min.js"></script>
    <script>
        $('.dropdown-trigger').dropdown();
    </script>
</body>
</html>
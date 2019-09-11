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
    <title><fmt:message key="language.user.registration"/></title>
</head>
<body>

    <div class="wrapper">
        <div class="header">
            <div class="inner-header">
                <nav>
                    <div class="nav-wrapper light-blue darken-4">
                        <ul id="nav-mobile" class="left hide-on-med-and-down">
                            <li><a href="${pageContext.request.contextPath}/main"><fmt:message key="language.back"/></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>


        <div class="valign-wrapper row login-box">
            <c:choose>
                <c:when test="${requestScope.email != null}">
                    <c:set var="emailValid" value="${requestScope.email}"/>
                </c:when>
                <c:when test="${requestScope.email == null}">
                    <c:set var="emailValid" value="language.emailValid.no.date"/>
                </c:when>

            </c:choose>
            <c:choose>
                <c:when test="${requestScope.emailTrue != null}">
                    <c:set var="emailTrue" value="${requestScope.emailTrue}"/>
                </c:when>
                <c:when test="${requestScope.emailTrue == null}">
                    <c:set var="emailTrue" value="language.emailTrue.no.date"/>
                </c:when>
            </c:choose>
            <div class="col card hoverable s10 pull-s1 m6 pull-m3 l4 pull-l4">
                <form action="${pageContext.request.contextPath}/adminCreate" method="post">
                    <div class="card-content">
                        <span class="card-title"><fmt:message key="language.registration"/>:</span>
                        <div class="row">
                            <div class="input-field col s12">
                                <label for="FirstName"><fmt:message key="language.name"/>:</label>
                                <input type="text" name="firstName" id="FirstName" required>
                            </div>
                            <div class="input-field col s12">
                                <label for="SecondName"><fmt:message key="language.surname"/>:</label>
                                <input type="text" name="secondName" id="SecondName" required>
                            </div>
                            <div class="input-field col s12">
                                <label for="Password"><fmt:message key="language.password"/>:</label>
                                <input type="password" name="password" id="Password" required>
                            </div>
                            <div class="input-field col s12">
                                <label for="Email"><fmt:message key="language.mail"/>:</label>
                                <input type="email" name="email" id="Email" required>
                            </div>
                            <div class="input-field col s12">
                                <select name="role" required>
                                    <option disabled selected><fmt:message key="language.role"/></option>
                                    <option value="Driver"><fmt:message key="language.driver"/></option>
                                    <option value="Dispatcher"><fmt:message key="language.dispatcher"/></option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="card-action center-align">
                        <div class="row">
                            <span class="center-align red-text">
                                <fmt:message key="${emailTrue}"/>
                                <fmt:message key="${emailValid}"/>
                            </span>
                        </div>
                        <button type="reset" id="reset" class="btn waves-effect light-blue darken-4 center-align"><fmt:message key="language.clear.data"/></button>
                        <button type="submit" class="btn waves-effect light-blue darken-4 center-align"><fmt:message key="language.to.register"/></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/www/js/materialize.min.js"></script>
    <script>
        $("#reset").on("click", function() {
            $('label').removeClass('active');
        });
        $(document).ready(function () {
            $('select').formSelect();
        });
    </script>
</body>
</html>

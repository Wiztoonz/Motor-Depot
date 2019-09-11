<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/session/sessionPages.jsp"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<html lang="${sessionScope.language}">
<head>
    <script src="${pageContext.request.contextPath}/www/js/jquery.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/www/css/materialize.min.css"  media="screen,projection"/>
    <title><fmt:message key="language.login"/></title>
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
            <div class="col card hoverable s10 pull-s1 m6 pull-m3 l4 pull-l4">
                <form action="login" method="post">
                    <div class="card-content">
                        <span class="card-title"><fmt:message key="language.enter.data"/>:</span>
                        <div class="row">
                            <div class="input-field col s12">
                                <input type="email" name="email" id="email" class="validate" required>
                                <label for="email"><fmt:message key="language.mail"/>:</label>
                            </div>
                            <div class="input-field col s12">
                                <input type="password" name="password" id="password" class="validate" required>
                                <label for="password"><fmt:message key="language.password"/>:</label>
                            </div>
                        </div>
                    </div>
                    <div class="card-action right-align">
                        <button type="reset" id="reset" class="btn waves-effect light-blue darken-4 center-align"><fmt:message key="language.clear.data"/></button>
                        <button type="submit" class="btn waves-effect light-blue darken-4 center-align"><fmt:message key="language.sing.in"/></button>
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
    </script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<c:choose>
    <c:when test="${sessionScope.Admin != null}">
        <c:set var="admin" value="admin"/>
    </c:when>
    <c:when test="${sessionScope.Admin == null}">
        <c:set var="admin" value=""/>
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${sessionScope.Dispatcher != null}">
        <c:set var="dispatcher" value="dispatcher"/>
    </c:when>
    <c:when test="${sessionScope.Dispatcher == null}">
        <c:set var="dispatcher" value=""/>
    </c:when>
</c:choose>

<html lang="${sessionScope.language}">
<head>
    <meta charset="UTF-8">
    <script src="${pageContext.request.contextPath}/www/js/jquery.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/www/css/materialize.min.css" media="screen,projection" />
    <title><fmt:message key="language.a.cars"/></title>
</head>
<body class="light-blue darken-4">
    <div class="wrapper white">
        <div class="header">
            <div class="inner-header">
                <nav>
                    <div class="nav-wrapper light-blue darken-4">
                        <ul id="nav-mobile" class="left hide-on-med-and-down">
                            <li><a href="${pageContext.request.contextPath}/main"><fmt:message key="language.back"/></a></li>
                        </ul>
                        <ul class="right">
                            <li class="right"><span>&nbspId:&nbsp${sessionScope.Dispatcher.id}${sessionScope.Admin.id}&nbsp</span>&nbsp</li>
                            <li class="right"><span>&nbsp<fmt:message key="language.user"/>:&nbsp${sessionScope.Dispatcher.firstName}${sessionScope.Admin.firstName}&nbsp${sessionScope.Dispatcher.secondName}${sessionScope.Admin.secondName}&nbsp</span></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col s12">
                <ul class="tabs  indigo darken-4">
                    <li class="tab col s4"><a href="#test1"><fmt:message key="language.add.machine"/></a></li>
                    <li class="tab col s4"><a href="#test2"><fmt:message key="language.machine.editing"/></a></li>
                    <li class="tab col s4"><a href="#test3"><fmt:message key="language.remove.car"/></a></li>
                </ul>
            </div>
            <div id="test1" class="col s6 offset-l3">
                <form action="${pageContext.request.contextPath}/carCreate" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="car"><fmt:message key="language.the.car"/>:</label>
                            <input type="text" name="car" id="car" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select name="description">
                                <option disabled selected><fmt:message key="language.choose.a.car"/></option>
                                <option><fmt:message key="language.passenger.car"/></option>
                                <option><fmt:message key="language.small.truck"/></option>
                                <option><fmt:message key="language.passenger.car.with.trailer"/></option>
                                <option><fmt:message key="language.truck"/></option>
                                <option><fmt:message key="language.truck.trailer"/></option>
                            </select>
                            <label><fmt:message key="language.description"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select name="carStatus">
                                <option disabled selected><fmt:message key="language.select.a.category"/></option>
                                <option>B</option>
                                <option>BE</option>
                                <option value="C">C</option>
                                <option value="CE">CE</option>
                            </select>
                            <label><fmt:message key="language.indicate.the.status"/></label>
                        </div>
                        <button class="btn waves-effect light-blue darken-4" type="submit" name="action"><fmt:message key="language.add"/></button>
                    </div>
                </form>
            </div>
        </div>

        <div class="row">
            <div id="test2" class="col s6 offset-l3">
                <form action="${pageContext.request.contextPath}/carUpdate" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="carId"><fmt:message key="language.the.car.id"/>:</label>
                            <input type="number" name="carId" id="carId" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="carUpdate"><fmt:message key="language.the.car"/>:</label>
                            <input type="text" name="carUpdate" id="carUpdate" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select name="statusUpdate">
                                <option disabled selected><fmt:message key="language.select.a.category"/></option>
                                <option>B</option>
                                <option>BE</option>
                                <option value="C">C</option>
                                <option value="CE">CE</option>
                            </select>
                            <label><fmt:message key="language.indicate.the.status"/></label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <select name="descriptionUpdate">
                                <option disabled selected><fmt:message key="language.choose.a.car"/></option>
                                <option><fmt:message key="language.passenger.car"/></option>
                                <option><fmt:message key="language.small.truck"/></option>
                                <option><fmt:message key="language.passenger.car.with.trailer"/></option>
                                <option><fmt:message key="language.truck"/></option>
                                <option><fmt:message key="language.truck.trailer"/></option>
                            </select>
                            <label><fmt:message key="language.description"/></label>
                        </div>
                        <button class="btn waves-effect light-blue darken-4" type="submit" name="action"><fmt:message key="language.edit"/></button>
                    </div>
                </form>
            </div>
        </div>

        <div class="row">
            <div id="test3" class="col s6 offset-l3">
                <form action="${pageContext.request.contextPath}/carDelete" method="post" class="col s12">
                    <div class="row">
                        <div class="input-field col s12">
                            <label for="carDeleteId"><fmt:message key="language.the.car.id"/>:</label>
                            <input type="number" name="carDeleteId" id="carDeleteId" required>
                        </div>
                        <button class="btn waves-effect light-blue darken-4" type="submit" name="action"><fmt:message key="language.delete"/></button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <footer class="page-footer light-blue darken-4">
        <div class="row">
            <div class="col s12">
                <ul class="tabs  indigo darken-4">
                    <li class="tab col s12"><a href="#test11"><fmt:message key="language.a.cars"/></a></li>
                </ul>
            </div>
        </div>

        <div class="row">
            <div id="test11" class="col s12">
                <div class="row">
                    <div class="col s12 center">
                        <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown3'><fmt:message key="language.status"/></a>
                    </div>
                    <ul id='dropdown3' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                        <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/car/sortBCars">B</a></li>
                        <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/car/sortBECars">BE</a></li>
                        <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/car/sortCCars">C</a></li>
                        <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/car/sortCECars">CE</a></li>
                    </ul>
                </div>
                <table class="light-blue darken-3">
                    <thead>
                    <tr>
                        <th><fmt:message key="language.cars.id"/></th>
                        <th><fmt:message key="language.a.cars"/></th>
                        <th><fmt:message key="language.description"/></th>
                        <th><fmt:message key="language.status"/></th>
                    </tr>
                    </thead>
                    <c:forEach var="c" items="${sessionScope.ListCars}">
                        <tbody>
                        <tr>
                            <td><c:out value="${c.id}"/></td>
                            <td><c:out value="${c.car}"/></td>
                            <td><c:out value="${c.description}"/></td>
                            <td><c:out value="${c.carStatus}"/></td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
    </footer>

    <script src="${pageContext.request.contextPath}/www/js/materialize.min.js"></script>
    <script>
        $(document).ready(function () {
            $('select').formSelect();
        });
        $(document).ready(function () {
            $('.tabs').tabs();
        });
        $('.dropdown-trigger').dropdown();
    </script>
</body>
</html>

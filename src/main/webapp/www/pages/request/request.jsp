<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/session/sessionDriver.jsp"%>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<!DOCTYPE html>
<html lang="${sessionScope.language}">
<head>
    <meta charset="UTF-8">
    <script src="${pageContext.request.contextPath}/www/js/jquery.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/www/css/materialize.min.css" media="screen,projection" />
    <title><fmt:message key="language.request"/></title>
</head>
<body class="light-blue darken-4">
<div class="wrapper">
    <div class="header">
        <div class="inner-header">
            <nav>
                <div class="nav-wrapper light-blue darken-4">
                    <ul id="nav-mobile" class="left hide-on-med-and-down">
                        <li><a href="${pageContext.request.contextPath}/main"><fmt:message key="language.back"/></a></li>
                    </ul>
                    <ul  class="right">
                        <li class="right"><span>&nbspId:&nbsp${sessionScope.Driver.id}&nbsp</span>&nbsp</li>
                        <li class="right"><span>&nbsp<fmt:message key="language.user"/>:&nbsp${sessionScope.Driver.firstName}&nbsp${sessionScope.Driver.secondName}&nbsp</span></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <div class="row light-blue lighten-5">

        <div class="sidebar-left">
            <div class="inner-sidebar-left">
                <div class="col s6">
                    <h3 class="center"><fmt:message key="language.create.application"/></h3>

                    <form action="${pageContext.request.contextPath}/requestCreate" method="post" class="col s12">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="FlightNumber" type="number" name="flightNumber" class="validate">
                                <label for="FlightNumber"><fmt:message key="language.flight.number"/></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <select name="carCharacteristics">
                                    <option disabled selected><fmt:message key="language.description"/></option>
                                    <option><fmt:message key="language.passenger.car"/></option>
                                    <option><fmt:message key="language.small.truck"/></option>
                                    <option><fmt:message key="language.passenger.car.with.trailer"/></option>
                                    <option><fmt:message key="language.truck"/></option>
                                    <option><fmt:message key="language.truck.trailer"/></option>
                                </select>
                                <label><fmt:message key="language.car.characteristics"/></label>
                            </div>
                            <button class="btn waves-effect waves-light" type="submit" name="action"><fmt:message key="language.create"/></button>
                        </div>
                    </form>

                </div>
            </div>
        </div>

        <div class="sidebar-right">
            <div class="inner-sidebar-right">
                <div class="col s6">
                    <h3 class="center"><fmt:message key="language.flight.management"/></h3>

                    <form action="${pageContext.request.contextPath}/flightUserEdit" method="post" class="col s12">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="numberEdit" type="number" name="numberEdit" class="validate">
                                <label for="numberEdit"><fmt:message key="language.flight.number"/></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <select name="statusEdit">
                                    <option disabled selected><fmt:message key="language.status"/></option>
                                    <option value="In progress"><fmt:message key="language.in.progress"/></option>
                                    <option value="Is closed"><fmt:message key="language.is.closed"/></option>
                                </select>
                                <label><fmt:message key="language.indicate.the.status"/></label>
                            </div>
                            <button class="btn waves-effect waves-light" type="submit" name="action"><fmt:message key="language.edit"/></button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col s12">
            <ul class="tabs  indigo darken-4">
                <li class="tab col s4"><a href="#test1"><fmt:message key="language.flights"/></a></li>
                <li class="tab col s4"><a href="#test2"><fmt:message key="language.applications"/></a></li>
                <li class="tab col s4"><a href="#test3"><fmt:message key="language.flight"/></a></li>
            </ul>
        </div>
        <div id="test1" class="col s12">
            <div class="row">
                <div class="col s12 left">
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown112'><fmt:message key="language.flight.number"/></a>
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown113'><fmt:message key="language.creation.date"/></a>
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown114'><fmt:message key="language.status"/></a>
                </div>
                <ul id='dropdown112' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortUpFlightNumbers"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortDownFlightNumbers"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown113' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortUpFightDates"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortDownFightDates"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown114' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortOpenStatus"><fmt:message key="language.open"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortProgressStatus"><fmt:message key="language.in.progress"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortCloseStatus"><fmt:message key="language.is.closed"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortCancelStatus"><fmt:message key="language.canceled"/></a></li>
                </ul>
            </div>
            <table class="light-blue darken-3">
                <thead>
                <tr>
                    <th><fmt:message key="language.flight.number"/></th>
                    <th><fmt:message key="language.creation.date"/></th>
                    <th><fmt:message key="language.description"/></th>
                    <th><fmt:message key="language.status"/></th>
                    <th><fmt:message key="language.driver.id"/></th>
                </tr>
                </thead>
                <c:forEach var="i" items="${sessionScope.Flights}">
                    <tbody>
                    <tr>
                        <td><c:out value="${i.flightsNumber}"/></td>
                        <td><c:out value="${i.creationDate}"/></td>
                        <td><c:out value="${i.description}"/></td>
                        <td> <c:out value="${i.status}"/></td>
                        <td> <c:out value="${i.idOfUser}"/></td>
                    </tr>
                    </tbody>
                </c:forEach>

            </table>
        </div>
        <div id="test2" class="col s12">
            <div class="row">
                <div class="col s12 center">
                        <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown1'><fmt:message key="language.flight.number"/></a>
                        <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown2'><fmt:message key="language.creation.date"/></a>
                </div>
                <ul id='dropdown1' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortUpFlightsUser"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortDownFlightsUser"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown2' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortUpFlightsRequest"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortDownFlightsRequest"><fmt:message key="language.down"/></a></li>
                </ul>
            </div>
            <table class="light-blue darken-3">
                <thead>
                <tr>
                    <th><fmt:message key="language.flight.number"/></th>
                    <th><fmt:message key="language.creation.date"/></th>
                    <th><fmt:message key="language.driver.id"/></th>
                </tr>
                </thead>
                <c:forEach var="j" items="${sessionScope.UserReq}">
                    <tbody>
                    <tr>
                        <td><c:out value="${j.flightNumber}"/></td>
                        <td><c:out value="${j.creationDate}"/></td>
                        <td><c:out value="${j.userId}"/></td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        <div id="test3" class="col s12">
            <div class="row">
                <div class="col s12 right-align">
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown11'><fmt:message key="language.flight.number"/></a>
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown22'><fmt:message key="language.creation.date"/></a>
                </div>
                <ul id='dropdown11' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortUpFlightsTheUser"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortDownFlightsTheUser"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown22' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortUpFlightsCreateTheUser"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/driver/request/sortDownFlightsDateCreateTheUser"><fmt:message key="language.down"/></a></li>
                </ul>
            </div>
            <table class="light-blue darken-3">
                <thead>
                <tr>
                    <th><fmt:message key="language.flight.number"/></th>
                    <th><fmt:message key="language.creation.date"/></th>
                    <th><fmt:message key="language.status"/></th>
                    <th><fmt:message key="language.driver.id"/></th>
                </tr>
                </thead>
                <c:forEach var="k" items="${sessionScope.FlightsUser}">
                <tbody>
                <tr>
                    <td><c:out value="${k.flightsNumber}"/></td>
                    <td><c:out value="${k.creationDate}"/></td>
                    <td> <c:out value="${k.status}"/></td>
                    <td> <c:out value="${k.idOfUser}"/></td>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/taglib.jsp"%>
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
    <title><fmt:message key="language.flights"/></title>
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
                    <ul  class="right">
                        <li class="right"><span>&nbspId:&nbsp${sessionScope.Dispatcher.id}${sessionScope.Admin.id}&nbsp</span>&nbsp</li>
                        <li class="right"><span>&nbsp<fmt:message key="language.user"/>:&nbsp${sessionScope.Dispatcher.firstName}${sessionScope.Admin.firstName}&nbsp${sessionScope.Dispatcher.secondName}${sessionScope.Admin.secondName}&nbsp</span></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>

    <div class="row">

        <c:set var="count" value="${requestScope.Count}"/>
           <c:forEach var="p" items="${sessionScope.Progress}">
               <c:out value="${p.firstName}"/>
               <c:out value="${p.secondName}"/>
               <c:out value="${p.description}"/>
               <br>
           </c:forEach>
        Коль-во: <c:out value="${count}"/>


        <div class="col s12">
            <ul class="tabs  indigo darken-4">
                <li class="tab col s4"><a href="#test1"><fmt:message key="language.create.a.flight"/></a></li>
                <li class="tab col s4"><a href="#test2"><fmt:message key="language.schedule.a.flight"/></a></li>
                <li class="tab col s4"><a href="#test3"><fmt:message key="language.flight.management"/></a></li>
            </ul>
        </div>
        <div id="test1" class="col s6 offset-l3">
                        <form action="${pageContext.request.contextPath}/flightCreate" method="post" class="col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="carId"><fmt:message key="language.cars.id"/>:</label>
                                    <input type="number" name="carId" id="carId" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <select name="description">
                                        <option disabled selected><fmt:message key="language.flight.description"/></option>
                                        <option><fmt:message key="language.passenger.flight"/></option>
                                        <option><fmt:message key="language.cargo.flight"/></option>
                                    </select>
                                    <label><fmt:message key="language.description"/></label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <select name="status">
                                        <option disabled selected><fmt:message key="language.status"/></option>
                                        <option value="Open"><fmt:message key="language.open"/></option>
                                    </select>
                                    <label><fmt:message key="language.indicate.the.status"/></label>
                                </div>
                                <button class="btn waves-effect light-blue darken-4" type="submit" name="action"><fmt:message key="language.create.a.flight"/></button>
                            </div>
                        </form>
        </div>
<%--        --%>
        <div id="test2" class="col s6 offset-l3">
                        <form action="${pageContext.request.contextPath}/editFlight" method="post" class="col s12">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="userAddId"><fmt:message key="language.driver.id"/></label>
                                    <input type="number" name="userAddId" id="userAddId" required>
                                </div>
                            </div>
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="numberAddFlight"><fmt:message key="language.flight.number"/></label>
                                    <input type="number" name="numberAddFlight" id="numberAddFlight" required>
                                </div>
                            </div>
                            <div class="row">
                                <button class="btn waves-effect light-blue darken-4" type="submit" name="action"><fmt:message key="language.assign"/></button>
                            </div>
                        </form>
        </div>
        <div id="test3" class="col s6 offset-l3">
                        <form action="${pageContext.request.contextPath}/flightSystemEdit" method="post" class="col s12">
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
                                        <option value="Canceled"><fmt:message key="language.canceled"/></option>
                                    </select>
                                    <label><fmt:message key="language.indicate.the.status"/></label>
                                </div>
                            </div>
                            <div class="row">
                                <button class="btn waves-effect light-blue darken-4" type="submit" name="action"><fmt:message key="language.edit"/></button>
                            </div>
                        </form>
        </div>
    </div>

    <footer class="page-footer light-blue darken-4">
    <div class="row">
        <div class="col s12">
            <ul class="tabs  indigo darken-4">
                <li class="tab col s4"><a href="#test11"><fmt:message key="language.flights"/></a></li>
                <li class="tab col s4"><a href="#test12"><fmt:message key="language.flight.requests"/></a></li>
                <li class="tab col s4"><a href="#test22"><fmt:message key="language.a.cars"/></a></li>
            </ul>
        </div>
        <div id="test11" class="col s12">
            <div class="row">
                <div class="col s12 left">
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown112'><fmt:message key="language.flight.number"/></a>
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown113'><fmt:message key="language.creation.date"/></a>
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown114'><fmt:message key="language.status"/></a>
                </div>
                <ul id='dropdown112' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortUpFlightNumbers"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortDownFlightNumbers"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown113' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortUpFightDates"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortDownFightDates"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown114' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortOpenStatus"><fmt:message key="language.open"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortProgressStatus"><fmt:message key="language.in.progress"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortCloseStatus"><fmt:message key="language.is.closed"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortCancelStatus"><fmt:message key="language.canceled"/></a></li>
                </ul>
            </div>
            <table class="light-blue darken-3">
                <thead>
                <tr>
                    <th><fmt:message key="language.flight.number"/></th>
                    <th><fmt:message key="language.creation.date"/></th>
                    <th><fmt:message key="language.description"/></th>
                    <th><fmt:message key="language.cars.id"/></th>
                    <th><fmt:message key="language.status"/></th>
                    <th><fmt:message key="language.driver"/></th>
                </tr>
                </thead>
                <c:forEach var="f" items="${sessionScope.ListFlights}">
                    <tbody>
                    <tr>
                        <td><c:out value="${f.flightsNumber}"/></td>
                        <td><c:out value="${f.creationDate}"/></td>
                        <td><c:out value="${f.description}"/></td>
                        <td><c:out value="${f.carId}"/></td>
                        <td><c:out value="${f.status}"/></td>
                        <td><c:out value="${f.idOfUser}"/></td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        <div id="test12" class="col s12">
            <div class="row">
                <div class="col s12 center">
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown11'><fmt:message key="language.driver.id"/></a>
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown12'><fmt:message key="language.flight.number"/></a>
                </div>
                <ul id='dropdown11' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortUpFlightsUser"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortDownFlightsUser"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown12' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortUpFlightsRequest"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortDownFlightsRequest"><fmt:message key="language.down"/></a></li>
                </ul>
            </div>
            <table class="light-blue darken-3">
                <thead>
                <tr>
                    <th><fmt:message key="language.driver.id"/></th>
                    <th><fmt:message key="language.flight.number"/></th>
                    <th class="center-align"><fmt:message key="language.car.characteristics"/></th>
                </tr>
                </thead>
                <c:forEach var="i" items="${sessionScope.ListUserRequest}">
                    <tbody>
                        <tr>
                            <td><c:out value="${i.userId}"/></td>
                            <td><c:out value="${i.flightNumber}"/></td>
                            <td class="center-align"><c:out value="${i.carCharacteristics}"/></td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        <div id="test22" class="col s12">
            <div class="row">
                <div class="col s12 right-align">
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown1'><fmt:message key="language.cars.id"/></a>
                    <a href="#" class="dropdown-trigger btn waves-effect waves-light btn-small light-blue darken-3" data-target='dropdown3'><fmt:message key="language.status"/></a>
                </div>
                <ul id='dropdown1' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortUpCarId"><fmt:message key="language.up"/></a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortDownCarId"><fmt:message key="language.down"/></a></li>
                </ul>
                <ul id='dropdown3' class='dropdown-content' style="width: 150px; min-width: 150px; max-width: 150px;">
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortBCars">B</a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortBECars">BE</a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortCCars">C</a></li>
                    <li><a href="${pageContext.request.contextPath}/${admin}${dispatcher}/flight/sortCECars">CE</a></li>
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

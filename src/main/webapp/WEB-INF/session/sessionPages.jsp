<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<code>
    <c:choose>
        <c:when test="${sessionScope.Driver != null}">
            <c:redirect url="driver"/>
        </c:when>
        <c:when test="${sessionScope.Admin != null}">
            <c:redirect url="admin"/>
        </c:when>
        <c:when test="${sessionScope.Dispatcher != null}">
            <c:redirect url="dispatcher"/>
        </c:when>
    </c:choose>
</code>


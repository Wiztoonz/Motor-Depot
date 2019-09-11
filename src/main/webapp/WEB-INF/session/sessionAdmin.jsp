<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<code>
    <c:choose>
        <c:when test="${sessionScope.Admin == null}">
            <c:redirect url="/login"/>
        </c:when>
    </c:choose>
</code>
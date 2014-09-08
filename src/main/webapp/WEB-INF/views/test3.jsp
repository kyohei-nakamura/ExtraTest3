<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<form:form modelAttribute="value" action="${appUrl}/test3-input">
    <c:forEach var="i" begin="1" end="2" step="1">
        <form:input path="value[value-${i}]"/><p>
    </c:forEach>
    <input type="submit">
</form:form>

</body>
</html>
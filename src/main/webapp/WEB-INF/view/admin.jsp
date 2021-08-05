<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>admin</title>
</head>
<body>


<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2 style="color: red">${pageContext.request.userPrincipal.name}</h2>
    <a href="*/logout"> LOGOUT </a>
</c:if>

<h3>Message: ${mass}</h3>

</body>
</html>

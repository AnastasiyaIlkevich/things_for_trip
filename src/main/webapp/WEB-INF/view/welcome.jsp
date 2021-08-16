<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
</head>
<h1>Вы вошли</h1>

<h2>Добро пожалавать. </h2>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2 style="color: red">${pageContext.request.userPrincipal.name}</h2>
    <a href="*/logout"> LOGOUT </a>
</c:if>



</body>
</html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>
<html>
<head>
</head>
<body>
<h1>Message: ${mass}</h1>
<div>
    <form modelAttribute="user" action="${pageContext.request.contextPath}/loginUser" method="post">

        <br>Username :<input type="text" placeholder="Login" oninput="this.className = ''" name="name"/><br>
        <br>password :<input type="password" placeholder="Password" oninput="this.className = ''" name="password"/></br>

        <button>Log in</button>
    </form>
</div>
</body>
</html>

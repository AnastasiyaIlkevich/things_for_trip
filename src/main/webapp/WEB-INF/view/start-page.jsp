<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>
<html>
<head>
</head>
<body>
<div>
  <form modelAttribute="userJSP" action="${pageContext.request.contextPath}/register" method="get">
    <button>Sing up</button>
  </form>

  <form modelAttribute="userJSP" action="${pageContext.request.contextPath}/sing-in" method="get">
    <button>Sign in</button>
  </form>
</div>
</body>
</html>
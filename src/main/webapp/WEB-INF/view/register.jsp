<%@ page isELIgnored="false"%>
<html>
<head>
</head>
<body>
<h1>Message: ${mass}</h1>
<div>
    <form modelAttribute="user" action="${pageContext.request.contextPath}/addUser" method="post">

            <br>Username :<input  type="text"  placeholder="Login" oninput="this.className = ''" name="name"/><br>
            <br>Email :<input  type="email"  placeholder="Email" oninput="this.className = ''" name="email"/></br>
            <br>password :<input  type="password"  placeholder="Password" oninput="this.className = ''" name="password"/></br>

        <button >Sing up</button>
    </form>
   </div>
</body>
</html>
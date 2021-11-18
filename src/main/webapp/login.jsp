<%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 18/11/21
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="Login" method="post">
    <table>
        <tr>
            <td>User</td>
            <td><input name="user" /></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input name="password" /></td>
        </tr>
    </table>
    <input type="submit" />
</form>
<% String message = (String) request.getAttribute("mis"); %>
<% if (message != null) {%>
<div>
    <p><%=message%></p>
</div>
<%} %>
</body>
</html>

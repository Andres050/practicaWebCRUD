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

<!-- Formulario con el contenido de user, password -->
<!-- Action Login = Quando haga click al input type submit lanzara la informacion por post a la classe Login sitiada en /com.example.practicawebcrud.web.Login -->
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
</body>
</html>

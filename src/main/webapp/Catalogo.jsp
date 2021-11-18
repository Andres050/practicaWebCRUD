<%@ page import="com.example.practicawebcrud.Dades.Business" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.practicawebcrud.Domini.Product" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 18/11/21
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    Business business = new Business();
%>
<% String user = (String) request.getAttribute("user"); String password = (String) request.getAttribute("password");%>
<% if (user.equals("andres") && password.equals("12345")) {%>
<body>
<%
    business.listProduct(response.getWriter());
%>
<h1>Esto es el catalogo</h1>
</body>
<%}%>
</html>

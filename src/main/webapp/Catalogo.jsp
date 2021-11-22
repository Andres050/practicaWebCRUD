<%@ page import="com.example.practicawebcrud.Dades.Business" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.practicawebcrud.Domini.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 18/11/21
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productos</title>
    <style>
        tr, table, th, thead, tbody {
            border: black solid 2px;
        }
    </style>
</head>
<%
    List<Product> list = (List<Product>) request.getAttribute("llista");
%>
<% String user = (String) request.getAttribute("user"); String password = (String) request.getAttribute("password");%>
<% if (user.equals("andres") && password.equals("12345")) {%>
<body>
<h1>Esto es el catalogo</h1>
<table style="border: black solid 2px">
    <tr>
        <th>IdPro</th>
        <th>namePro</th>
        <th>descriptPro</th>
        <th>pricePro</th>
    </tr>
    <tr>
        <% for (int i = 0; i < list.size(); i++){%>
        <td><%=list.get(i).getIdPro()%></td>
        <td><%=list.get(i).getNamePro()%></td>
        <td><%=list.get(i).getDescriptPro()%></td>
        <td><%=list.get(i).getPricePro()%></td>
        <%}%>
        <td><button type="submit" formmethod="get">Delete</button></td>
    </tr>
</table>
</body>
<%}%>
</html>

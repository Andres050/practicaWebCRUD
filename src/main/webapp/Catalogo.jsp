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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        body {
            margin-left: 100px;
            margin-right: 100px;
        }
        h1 {
            margin-top: 50px;
            margin-bottom: 50px;
            text-align: center;
        }
    </style>
</head>
<!-- GET ATRIBUTE LISTA -->
<% Business business = new Business();%>
<% List<Product> list = business.list(); %>
<% String singleProduct = (String) request.getAttribute("SingleProduct"); %>

<body>
<h1>CATALOGO DE PRODUCTOS</h1>
<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">IdPro</th>
        <th scope="col">namePro</th>
        <th scope="col">descriptPro</th>
        <th scope="col">pricePro</th>
        <th scope="col">OPERATIONS</th>
    </tr>
    </thead>
    <tbody>
    <!-- ASIN ES COMO SE HACE UN FOR -->
        <% for (int i = 0; i < list.size(); i++){%>
        <tr>
            <!-- ASIN ES COMO SE USE EL %= UN FOR-->
            <th scope="row"><a href="CatalogoProductos?action=view&id=<%=list.get(i).getIdPro()%>" type="submit" class="btn btn-secondary mb-2">VIEW</a></th>
            <th><%=list.get(i).getIdPro()%></th>
        <td><%=list.get(i).getNamePro()%></td>
        <td><%=list.get(i).getDescriptPro()%></td>
        <td><%=list.get(i).getPricePro()%></td>
            <!-- Action y el id para hacer la action con la id, ademas lo paso por get ya que esta en el enlaze-->
            <td><a href="CatalogoProductos?action=edit&id=<%=list.get(i).getIdPro()%>" type="submit" class="btn btn-primary mb-2">EDIT</a></td>
            <td><a href="CatalogoProductos?action=delete&id=<%=list.get(i).getIdPro()%>" type="submit" class="btn btn-primary mb-2">DELETE</a></td>
        </tr>
        <%}%>
    </tbody>
</table>
<!-- Action y el id para hacer la action con la id, ademas lo paso por get ya que esta en el enlaze-->
<a href="CatalogoProductos?action=add&id=-1" type="submit" class="btn btn-success mb-2">ADD NEW ITEM</a>
<a href="CatalogoProductos?action=removeAll&id=-1" type="submit" class="btn btn-danger mb-2">REMOVE ALL ITEMS</a>

<!-- Si hay algun fallo se mostrara aqui-->
<div class="alert alert-success" role="alert">
    <%=singleProduct%>
</div>
</body>
</html>

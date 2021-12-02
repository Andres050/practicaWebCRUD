<%@ page import="com.example.practicawebcrud.Domini.Product" %><%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 2/12/21
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <style>
        body {
            margin-left: 100px;
            margin-right: 100px;
        }
        h1 {
            text-align: center;
        }
        form {
            margin-top: 40px;
        }
    </style>
</head>
<% Product product = (Product) request.getAttribute("viewProduct");%>
<% String action = (String) request.getAttribute("action");%>
<% request.setAttribute("action",action);%>
<body>
<form class="form-inline">
    <div class="form-group mx-sm-3">
        <label for="<%=action%>" class="sr-only">ACTION</label>
        <input type="text" class="form-control" id="<%=action%>" name="<%=action%>" value="<%=action%>" readonly="readonly">
    </div>
    <div class="form-group mx-sm-3">
        <label for="<%=product.getIdPro()%>" class="sr-only">idPro</label>
        <input type="text" class="form-control" id="<%=product.getIdPro()%>"  name="<%=product.getIdPro()%>"  value="<%=product.getIdPro()%>" readonly="readonly">
    </div>
    <div class="form-group mx-sm-3">
        <label for="<%=product.getNamePro()%>" class="sr-only">namePro</label>
        <input type="text" class="form-control" id="<%=product.getNamePro()%>" name="<%=product.getNamePro()%>" value="<%=product.getNamePro()%>" readonly="readonly">
    </div>
    <div class="form-group mx-sm-3">
        <label for="<%=product.getDescriptPro()%>" class="sr-only">descPro</label>
        <input type="text" class="form-control" id="<%=product.getDescriptPro()%>" name="<%=product.getDescriptPro()%>" value="<%=product.getDescriptPro()%>" readonly="readonly">
    </div>
    <div class="form-group mx-sm-3">
        <label for="<%=product.getPricePro()%>" class="sr-only">price</label>
        <input type="text" class="form-control" id="<%=product.getPricePro()%>" name="<%=product.getPricePro()%>" value="<%=product.getPricePro()%>" readonly="readonly">
    </div>
</form>
<form action="Catalogo.jsp" class="form-inline">
    <button class="btn btn-primary">RETURN</button>
</form>
</body>
</html>


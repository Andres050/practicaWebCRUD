<%--
  Created by IntelliJ IDEA.
  User: alumneifc33b
  Date: 23/11/21
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addProduct</title>
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
<% String action = (String) request.getAttribute("action");%>
<% request.setAttribute("action",action);%>
<body>
<form action="CatalogoProductos" method="post" class="form-inline">
    <div class="form-group mx-sm-3">
        <label for="<%=action%>" class="sr-only">ACTION</label>
        <input type="text" class="form-control" id="<%=action%>" name="<%=action%>" value="<%=action%>" readonly="readonly">
    </div>
    <div class="form-group mx-sm-3">
        <label for="namePro" class="sr-only">namePro</label>
        <input type="text" class="form-control" id="namePro" name="namePro" placeholder="name">
    </div>
    <div class="form-group mx-sm-3">
        <label for="descriptPro" class="sr-only">descriptPro</label>
        <input type="text" class="form-control" id="descriptPro" name="descriptPro" placeholder="desc">
    </div>
    <div class="form-group mx-sm-3">
        <label for="pricePro" class="sr-only">pricePro</label>
        <input type="number" class="form-control" id="pricePro" name="pricePro" placeholder="33">
    </div>
    <button type="submit" class="btn btn-primary">SEND</button>
</form>
</body>
</html>

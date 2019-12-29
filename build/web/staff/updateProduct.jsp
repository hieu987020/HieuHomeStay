<%-- 
    Document   : updateProduct
    Created on : 20-Aug-2019, 13:38:23
    Author     : hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Product!</h1>
        <form action="/HieuHomeStay/StaffUpdateProductController" method="POST">
            ID: <input type="text" name="id" value="${requestScope.INFO.id}" readonly/></br>
            Name: <input type="text" name="name" value="${requestScope.INFO.name}"/></br>
            Quantity: <input type="text" name="quantity" value="${requestScope.INFO.quantity}"/></br>
            Price: <input type="text" name="price" value="${requestScope.INFO.price}"/></br>
            Coin: <input type="text" name="coin" value="${requestScope.INFO.coin}"/></br>
            Type: <input type="text" name="type" value="${requestScope.INFO.type}"/></br>
            Source: <input type="text" name="source" value="${requestScope.INFO.source}"/></br>
            isMaintenance: <input type="text" name="isMaintenance" value="${requestScope.INFO.delete}"/></br>
            <input type="hidden" value="${param.search}" name="search"/>
            <input type="submit" value="Update"/>         
        </form>
    </body>
</html>

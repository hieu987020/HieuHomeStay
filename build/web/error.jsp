<%-- 
    Document   : error
    Created on : 18-Aug-2019, 14:04:03
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
        <h1>ERROR PAGE!</h1>
        <font color="red">${requestScope.ERROR}</font>
    </body>
</html>

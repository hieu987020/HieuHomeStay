<%-- 
    Document   : billCoinSuccess
    Created on : 25-Aug-2019, 01:54:19
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
        <h1>MAKE NEW BILL COIN SUCCESS!</h1>
        <font color="green">ID:</font>${requestScope.BILL.id}</br>
        <font color="green">InfoID:</font>${requestScope.BILL.infoID}</br>
        <font color="green">Coin:</font>${requestScope.BILL.coin} Coin</br>
        <font color="green">Time:</font>${requestScope.BILL.time}</br>
        <a href="staff/index.jsp">Back to Main</a>


    </body>
</html>

<%-- 
    Document   : success
    Created on : 24-Aug-2019, 03:11:29
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
        <h1>CHECK OUT SUCCESS! THIS IS ALL ABOUT THE BILL</h1>
    <font color="blue">ID:</font> ${requestScope.BILL.id}</br></br>
        <font color="blue">InfoID: </font> ${requestScope.BILL.infoID}</br></br>
        <font color="blue">StaffID: </font> ${requestScope.BILL.staffID}</br></br>
        <font color="blue">DateFrom: </font>${requestScope.BILL.dateFrom}</br></br>
        <font color="blue">DateTo: </font> ${requestScope.BILL.dateTo}</br></br>
        <font color="blue">SumBefore: </font> ${requestScope.BILL.sumBefore}$</br></br>
        <font color="blue">MoneyDiscount: </font> ${requestScope.BILL.discount}$</br></br>
        <font color="blue">SumAfter: </font> ${requestScope.BILL.sumAfter}$</br></br>
        <font color="blue">Time: </font> ${requestScope.BILL.time}</br></br>       
        <a href="staff/index.jsp">Go back Main</a>
    </body>
</html>

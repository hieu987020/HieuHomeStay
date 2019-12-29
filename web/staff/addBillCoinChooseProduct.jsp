<%-- 
    Document   : addBillCoinChooseProduct
    Created on : 24-Aug-2019, 23:33:08
    Author     : hieu
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Choose Product!</h1>
        <c:if test="${requestScope.INFO != null}">
            <c:if test="${not empty requestScope.INFO}" var="checkINFO">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>                           
                            <th>Name</th>
                            <th>Coin</th>
                            <th>Type</th>
                            <th>Choose Button</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.name}</td>
                                <td>${dto.coin}</td>
                                <td>${dto.type}</td>
                                <td>
                                    <form action="StaffAddBillChooseProductController" method="POST">
                                        <input type="hidden" value="${requestScope.BILLID}" name="billID" readonly/>
                                        <input type="hidden" value="${dto.id}" name="proID"/>
                                        <input type="hidden" value="${dto.coin}" name="coin"/>
                                        Quantity: <input type="text" name="quantity" required pattern="[1-9]{1}[0-9]{0,}" title="quantity > 0"/>
                                        <input type="submit" value="Choose"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!checkINFO}">
                No Product
            </c:if>
        </c:if>
                <h1>CONFIRM</h1>
                <form action="StaffConfirmBillCoin" method="POST">
                    <input type="hidden" value="${requestScope.BILLID}" name="billID"/>
                    <input type="submit" value="Confirm"/>
                </form>
                </br></br></br>
                <font color="red"><h2>${requestScope.INVALID}</h2></font>
    </body>
</html>

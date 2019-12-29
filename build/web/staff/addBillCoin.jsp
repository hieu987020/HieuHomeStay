<%-- 
    Document   : addBillCoin
    Created on : 24-Aug-2019, 22:25:49
    Author     : hieu
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>BILL COIN!</h1>
        <c:if test="${requestScope.LIST != null}">
            <c:if test="${not empty requestScope.LIST}" var="checkLIST">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>InfoID</th>
                            <th>Choose Button</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.LIST}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.infoID}</td>
                                <td>
                                    <form action="StaffAddBillChooseInfoController" method="POST">
                                        <input type="hidden" value="${dto.infoID}" name="id"/>
                                        <input type="submit" value="Choose" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!checkLIST}">
                No one is at Otera
            </c:if>
        </c:if>
        </br><a href="staff/index.jsp">Go back Main</a>
    </body>
</html>

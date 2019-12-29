<%-- 
    Document   : viewBill
    Created on : 23-Aug-2019, 21:55:24
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
        <h1>All Bill NOT APPROVED!</h1>
        <c:if test="${requestScope.NOTAPPROVED != null}">
            <c:if test="${not empty requestScope.NOTAPPROVED}" var="checkNotApproved">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>InfoID</th>
                            <th>DateFrom</th>
                            <th>DateTo</th>
                            <th>Check Out Button</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.NOTAPPROVED}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.infoID}</td>
                                <td>${dto.dateFrom}</td>
                                <td>${dto.dateTo}</td>
                                <td>
                                    <form action="StaffCheckOutController" method="POST">
                                        <input type="hidden" value="${dto.id}" name="id"/>
                                        <input type="submit" value="Check Out"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>           
            </c:if>
            <c:if test="${!checkNotApproved}">
                No Record Bill Not Approved
            </c:if>
        </c:if>



        <h1>All Bill APPROVED!</h1>
        <c:if test="${requestScope.APPROVED != null}">
            <c:if test="${not empty requestScope.APPROVED}" var="checkApproved">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>InfoID</th>
                            <th>StaffID</th>
                            <th>DateFrom</th>
                            <th>DateTo</th>                       
                            <th>SumBefore</th>
                            <th>MoneyDiscount</th>
                            <th>SumAfter</th>
                            <th>Time</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.APPROVED}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.infoID}</td>
                                <td>${dto.staffID}</td>
                                <td>${dto.dateFrom}</td>
                                <td>${dto.dateTo}</td>
                                <td>${dto.sumBefore}</td>
                                <td>${dto.discount}</td>
                                <td>${dto.sumAfter}</td>
                                <td>${dto.time}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>           
            </c:if>
            <c:if test="${!checkApproved}">
                No Record Bill Approved
            </c:if>
        </c:if>
    </body>
</html>

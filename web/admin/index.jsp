<%-- 
    Document   : index
    Created on : 18-Aug-2019, 13:25:47
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
        <h1>WELCOME ADMIN ${sessionScope.USERLOGIN} DEPTRAI!</h1>
        <form action="/HieuHomeStay/AdminViewCustomerController">
            <input type="submit" value="View Customer"/>
        </form>
        </br>
        <form action="/HieuHomeStay/AdminViewStaffController">
            <input type="submit" value="View Staff"/>
        </form>

        <c:if test="${requestScope.INFOCUSTOMER != null}" var="list">
            <c:if test="${not empty requestScope.INFOCUSTOMER}" var="checkINFO1">
                <h1>All Customer!</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>Become Staff Button</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFOCUSTOMER}" var="dto1" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto1.username}</td>
                                <td>
                                    <form action="AdminChangeRoleController" method="POST">
                                        <input type="hidden" value="${dto1.username}" name="id"/>
                                        <input type="submit" value="Up to Staff"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${!checkINFO1}">
                No record
            </c:if>
        </c:if>

        <c:if test="${requestScope.INFOSTAFF != null}" var="list">
            <c:if test="${not empty requestScope.INFOSTAFF}" var="checkINFO2">
                <h1>All Staff!</h1>
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Username</th>
                            <th>View History</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.INFOSTAFF}" var="dto2" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto2.username}</td>
                                <td>
                                    <form action="AdminViewHistoryStaffController" method="POST">
                                        <input type="hidden" value="${dto2.infoID}" name="id"/>
                                        <input type="submit" value="View History"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
            <c:if test="${!checkINFO2}">
                No record
            </c:if>
        </c:if>
        </br>
        <form action="LogoutController" method="POST">
            <input type="submit" value="Log Out"/>
        </form>

    </body>
</html>

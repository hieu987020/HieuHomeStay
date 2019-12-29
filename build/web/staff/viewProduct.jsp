<%-- 
    Document   : viewProduct
    Created on : 20-Aug-2019, 12:35:07
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
        <h1>Insert Product!</h1>
        <form action="/HieuHomeStay/StaffInsertProductController" method="POST">
            Name: <input type="text" name="name" required/>
            </br>
            Quantity: <input type="text" name="quantity" pattern="[1-9]{1}[0-9]{0,}" title="number please" required />
            </br>
            Price: <input type="text" name="price" pattern="[1-9]{1}[0-9]{0,}" title="number please" required />
            </br>
            Coin: <input type="text" name="coin" pattern="[1-9]{1}[0-9]{0,}" title="number please" required/>
            </br>
            Type: <input type="text" name="type" required/>
            </br>
            Source: <input type="text" name="source" required/>
            </br>
            <input type="submit" value="Insert"/>
        </form>
        <h1>All Product!</h1>
        <form action="StaffSearchProductController" method="POST">
            Name: <input type="text" name="search"/>
            <input type="submit" value="Search"/>
        </form>
    <c:if test="${requestScope.INFO != null}" var="list">
        <c:if test="${not empty requestScope.INFO}" var="checkINFO">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Coin</th>
                        <th>Type</th>                        
                        <th>Source</th>
                        <th>isMaintenance</th>
                        <th>Update</th>
                        <th>Maintenance</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.INFO}" var="dto" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${dto.id}</td>
                        <td>${dto.name}</td>
                        <td>${dto.quantity}</td>
                        <td>${dto.price}</td>
                        <td>${dto.coin}</td>
                        <td>${dto.type}</td>
                        <td>${dto.source}</td>
                        <td>${dto.delete}</td>
                        <td>
                            <form action="StaffEditProductController" method="POST">
                                <input type="hidden" value="${param.search}" name="search"/>
                                <input type="hidden" value="${dto.id}" name="id"/>
                                <input type="submit" value="Update"/>
                            </form>                               
                        </td>
                        <td>
                            <form action="StaffDeleteProductController" method="POST">
                                <input type="hidden" value="${param.search}" name="search"/>
                                <input type="hidden" value="${dto.id}" name="id"/>
                                <input type="submit" value="Maintenance"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${!checkINFO}">
            No record
        </c:if>
    </c:if>
            <a href="staff/index.jsp">Go Back Main</a>
</body>
</html>

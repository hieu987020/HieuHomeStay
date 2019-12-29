<%-- 
    Document   : checkOut
    Created on : 23-Aug-2019, 23:00:34
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
        <!------------------------------------------------------------------------------------------------>
        <h1>CHECK OUT!</h1> 
        BILL ID: ${requestScope.BILLID}
        <font color="red"><h2>ROOM--------------------------------------------------------------------------</h2></font>
        <c:forEach items="${requestScope.ROOM}" var="dto" varStatus="counter">
            <font color="blue"><strong>No: ${counter.count}</strong></font></br>
            ID: ${dto.id}</br>
            Name: ${dto.name}</br>
            Price(1 day): ${dto.price}</br>
            ---------------------</br>
        </c:forEach>

        <!------------------------------------------------------------------------------------------------>
        <font color="red"><h2>PRODUCT---------------------------------------------------------------------</h2></font>
        <c:if test="${requestScope.PRODUCT != null}">
            <c:if test="${not empty requestScope.PRODUCT}">
                <c:forEach items="${requestScope.PRODUCT}" var="dto" varStatus="counter">
                    <form action="StaffRemoveProductBillController" method="POST">
                        <font color="blue"><strong>No: ${counter.count}</strong></font></br>
                        ID: ${dto.id}</br>
                        Name: ${dto.name}</br>  
                        Price(for 1): ${dto.price}$</br>
                        <input type="hidden" value="${requestScope.BILLID}" name="id"/>
                        <input type="hidden" value="${dto.id}" name="proId"/>
                        <input type="submit" value="Remove"/>
                        </br>
                    </form>
                    <form action="StaffUpdateQuantityProductBillController">
                        Quantity : <input type="text" name="quantity" required pattern="[1-9]{1}[0-9]{0,}"/>
                        <input type="hidden" value="${requestScope.BILLID}" name="id"/>
                        <input type="hidden" value="${dto.id}" name="proId"/>
                        <input type="hidden" value="${dto.price}" name="price"/>
                        <input type="submit" value="Update Quantity"/></br>
                        ----------------------------------------------------------------------------------</br>
                    </form>
                </c:forEach>
            </c:if>
        </c:if>
        </br>

        <c:if test="${requestScope.ALLPRODUCT != null}">
            <c:if test="${not empty requestScope.ALLPRODUCT}" var="checkPro">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Type</th>                  
                            <th>Add To Bill Button</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.ALLPRODUCT}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.name}</td>
                                <td>${dto.price}</td>
                                <td>${dto.type}</td>
                                <td>
                                    <form action="StaffAddProductToBillController" method="POST">
                                        <input type="hidden" value="${dto.id}" name="proId"/>
                                        <input type="hidden" value="${dto.price}" name="price"/>
                                        <input type="hidden" value="${requestScope.BILLID}" name="id"/>
                                        <input type="submit" value="Add To Bill"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!checkPro}">
                No record for all product
            </c:if>
        </c:if>


        <!------------------------------------------------------------------------------------------------>
        <font color="red"><h2>SERVICE------------------------------------------------------------------------</h2></font>
        <c:if test="${requestScope.SERVICE != null}">
            <c:if test="${not empty requestScope.SERVICE}">
                <c:forEach items="${requestScope.SERVICE}" var="dto" varStatus="counter">
                    <form action="StaffRemoveServiceBillController" method="POST">
                        <font color="blue"><strong>No: ${counter.count}</strong></font></br>
                        ID: ${dto.id}</br>
                        Name: ${dto.name}</br>      
                        Price: ${dto.price}$</br>
                        <input type="hidden" value="${requestScope.BILLID}" name="id"/>
                        <input type="hidden" value="${dto.id}" name="serId"/>
                        <input type="submit" value="Remove"/>
                        ---------------------</br></br>
                    </form>
                </c:forEach>
            </c:if>
        </c:if>


        <c:if test="${requestScope.ALLSERVICE != null}">
            <c:if test="${not empty requestScope.ALLSERVICE}" var="checkSer">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>                  
                            <th>Add To Bill Button</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.ALLSERVICE}" var="dto" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.name}</td>
                                <td>${dto.price}</td>
                                <td>
                                    <form action="StaffAddServiceToBillController" method="POST">
                                        <input type="hidden" value="${dto.id}" name="serId"/>
                                        <input type="hidden" value="${dto.price}" name="price"/>
                                        <input type="hidden" value="${requestScope.BILLID}" name="id"/>
                                        <input type="submit" value="Add To Bill"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${!checkSer}">
                No record for all service
            </c:if>
        </c:if>
        <h1>LAST STEP CHECK OUT BUTTON HERE</h1>
        <form action="StaffCheckOutTotalPriceController" method="POST">
            <input type="hidden" name="billId" value="${requestScope.BILLID}"/>
            <input type="submit" value="Last Check Out"/>
        </form>

    </body>
</html>

<%-- 
    Document   : updateRoom.jsp
    Created on : 20-Aug-2019, 11:21:37
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
        <h1>Update Room!</h1>
        <form action="/HieuHomeStay/StaffUpdateRoomController" method="POST">
            ID: <input type="text" name="id"  value="${requestScope.INFO.id}" readonly/>
            </br>
            Name: <input type="text" name="name" value="${requestScope.INFO.name}"/>
            </br>
            Des: <input type="text" name="des" value="${requestScope.INFO.des}"/>
            </br>
            Price <input type="text" name="price" value="${requestScope.INFO.price}"/>
            </br>
            Source: <input type="text" name="source" value="${requestScope.INFO.source}"/>
            </br>
            Maintenance: <input type="text" name="maintenance" value="${requestScope.INFO.delete}"/>
            </br>
            <input type="hidden" value="${param.search}" name="search"/>
            <input type="submit"  value="Update"/>
        </form>
    </body>
</html>

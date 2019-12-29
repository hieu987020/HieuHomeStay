<%-- 
    Document   : updateService
    Created on : 20-Aug-2019, 17:14:51
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
        <h1>Update Service!</h1>
        <form action="/HieuHomeStay/StaffUpdateServiceController">
            ID: <input type="text" name="id" value="${INFO.id}" readonly/></br>
            Name: <input type="text" name="name" value="${INFO.name}" required/></br>
            Price: <input type="text" name="price" value="${INFO.price}" required/></br>
            Des: <input type="text" name="des" value="${INFO.des}" required/></br>
            Source: <input type="text" name="source" value="${INFO.source}" required/></br>
            isMaintenance: <input type="text" name="delete" value="${INFO.delete}" required/></br>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>

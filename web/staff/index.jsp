<%-- 
    Document   : index
    Created on : 18-Aug-2019, 13:25:58
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
        <h1>Welcome Staff ${sessionScope.USERLOGIN}!</h1>
        
        <a href="/HieuHomeStay/StaffViewRoomController"><h2>view room</h2></a>
        </br>
        <a href="/HieuHomeStay/StaffViewProductController"><h2>view product</h2></a>  
        </br>
        <a href="/HieuHomeStay/StaffViewServiceController"><h2>view service</h2></a>   
        </br>
        <a href="/HieuHomeStay/StaffViewBillController"><h2>view bill</h2></a>
        </br>      
        <a href="/HieuHomeStay/StaffAddBillCoinController"><h2>add new Bill Coin</h2></a>
        </br>
        
        <form action="/HieuHomeStay/LogoutController" method="POST">
            <input type="submit" value="Log Out"/>
        </form>
    </body>
</html>

<%-- 
    Document   : adminPage
    Created on : 29-Jun-2025, 14:20:17
    Author     : kohji
--%>

<%@ page import="model.Manager" %>
<%
    Manager manager = (Manager) session.getAttribute("manager");

    if (manager == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String name = manager.getUsername();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Welcome, <%= name%>!</h1>
           <a href="registerPage.jsp">New User Registration</a>
        <br><br><br>
    </body>
</html>

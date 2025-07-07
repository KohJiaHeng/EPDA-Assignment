<%-- 
    Document   : registerPage
    Created on : 28-Jun-2025, 15:34:19
    Author     : kohji
--%>
<%@ page import="model.Manager" %>
<%
    Manager manager = (Manager) session.getAttribute("manager");
    boolean isManagerAccount = (manager != null);

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%= isManagerAccount ? "Admin Register Page" : "User Registration Page"%></title>
    </head>
    <body>
        <% if (isManagerAccount) { %>
        <h2>Welcome Admin, register new accounts below:</h2>
        <a href="adminPage.jsp">← Back to Admin Page</a>
        <% } else { %>
        <a href="loginPage.jsp">Login Page</a>
        <% }%>

        <br><br>
        <form action="<%= isManagerAccount ? "adminRegister" : "Register"%>" method="POST">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" size="20"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="text" name="Password" size="20"></td>
                </tr>
                <tr>
                    <td>Roles: </td>
                    <td>
                        <% if (isManagerAccount) { %>
                        <select name="roles" id="role" required>
                            <option value="" disabled selected>Select role</option>
                            <option value="Manager">Manager</option>
                            <option value="Doctor">Doctor</option>
                            <option value="CounterStaff">Counter Staff</option>
                        </select>

                        <% } else { %>
                       
                        <input type="text" name="roles" size="20" placeholder="CUSTOMER">
                        
                        
                        <input type="text" name="email" size="20" placeholder="Email">
                        
                       
                        <input type="text" name="gender" size="20" placeholder="Gender">
                        
                        
                        <input type="text" name="phone" size="20" placeholder="Phone Number">
                        
                       
                        <input type="text" name="ic" size="20" placeholder="IC">
                        
                       
                        <input type="text" name="address" size="20" placeholder="Address">
                        <% }%>
                    </td>
                </tr>
            </table>
            <p><input type="submit" value="Register"></p>
        </form>
    </body>
</html>

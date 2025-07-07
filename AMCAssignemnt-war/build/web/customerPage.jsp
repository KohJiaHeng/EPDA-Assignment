<%-- 
    Document   : customerPage
    Created on : 29-Jun-2025, 14:13:25
    Author     : kohji
--%>

<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Customer> customerList = (List<Customer>) request.getAttribute("customerList");
    if (customerList != null && !customerList.isEmpty()) {
        Customer customer = customerList.get(0);
%>
<!DOCTYPE html>
<html>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Page</title>

    <body>
        <h1>Welcome, <%= customer.getCusName()%>!</h1>

        <h2>Your Gender: <%= customer.getCusGender()%></h2>

        <ul>
            <p>Customer Email: <%= customer.getCusEmail()%></p>
        </ul>
        
        <form action="updateUserProfile" method="post">
            <label for="cusName">Edit Name:</label>
            <input type="text" name="cusName" id="cusName" value="" required />
            <input type="hidden" name="cusUsername" value="<%= customer.getCusName()%>" />
            <input type="hidden" name="cusID" value="<%= customer.getId()%>" />
            <br>
            <input type="submit" value="Update Name" />
        </form>



    </body>

    <%
        }
    %>
</html>

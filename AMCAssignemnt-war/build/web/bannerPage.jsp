<%@page import="model.Customer"%>
<%@page import="model.Manager"%>
<%@ page import="model.UserAccount" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserAccount user = (UserAccount) session.getAttribute("user");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String username = user.getUsername();
    String role = user.getRoles();

    String redirectPage = "unknown.jsp";
    if ("DOCTOR".equalsIgnoreCase(role)) {
        redirectPage = "doctorPage.jsp";
    } else if ("ADMIN".equalsIgnoreCase(role) || "Manager".equalsIgnoreCase(role)) {
        Manager manager = new Manager(); 
        manager.setUsername(username);
        session.setAttribute("manager", manager); 
        redirectPage = "adminPage.jsp";
    } else if ("CUSTOMER".equalsIgnoreCase(role)) {
        Customer customer = new Customer(); 
        customer.setCusName(username);
        session.setAttribute("customer", customer); 
        redirectPage = "customerPage";
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Login Successful</title>
        <style>
            body {
                font-family: 'Segoe UI', sans-serif;
                background: linear-gradient(to right, #a8e063, #56ab2f);
                color: white;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
                margin: 0;
                animation: fadeIn 1.5s ease-in;
                text-align: center;
            }

            h1 {
                font-size: 3em;
                margin-bottom: 0.3em;
            }

            p {
                font-size: 1.5em;
                margin: 0.2em;
            }

            @keyframes fadeIn {
                from { opacity: 0; transform: translateY(30px); }
                to { opacity: 1; transform: translateY(0); }
            }

            @keyframes fadeOut {
                from { opacity: 1; }
                to { opacity: 0; transform: translateY(-30px); }
            }

            .fade-out {
                animation: fadeOut 1s forwards;
            }
        </style>

        <script>
            setTimeout(() => {
                document.body.classList.add("fade-out");
                setTimeout(() => {
                    window.location.href = "<%= redirectPage%>";
                }, 1000);
            }, 3000);
        </script>
    </head>
    <body>
        <h1>Login Successful!</h1>
        <p>Welcome, <%= username%>!</p>
        <p>Redirecting to your <%= role.toLowerCase()%> page...</p>
    </body>
</html>

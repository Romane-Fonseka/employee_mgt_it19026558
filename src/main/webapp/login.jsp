<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f1f1f1;
        }
        .login-box {
            width: 400px;
            padding: 40px;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
<div class="login-container">
    <div class="login-box">
        <h2 class="w3-center">Welcome!</h2>
        
        <!-- Employee Login -->
        <div>
            <h4>Employee Login</h4>
            <form action="LoginServlet" method="post">
                <label><i class="fa fa-user"></i> Username</label>
                <input class="w3-input w3-border" type="text" name="employeeId" required>
                <label><i class="fa fa-lock"></i> Password</label>
                <input class="w3-input w3-border" type="password" name="employeePassword" required>
                <input type="hidden" name="action" value="login">
                <button class="w3-button w3-blue w3-margin-top">Login</button>
            </form>
        </div>
        
        
        <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="w3-panel w3-red w3-margin-top">
        <p><i class="fa fa-exclamation-circle"></i> <%= request.getAttribute("errorMessage") %></p>
    </div>
<% } %>
        
    </div>
</div>
</body>
</html>
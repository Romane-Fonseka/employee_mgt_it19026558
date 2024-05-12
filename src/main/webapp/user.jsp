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
    <div class="registration-container">
    <div class="login-box">
        <form action="LoginServlet" method="post">
            <h2>User Registration</h2>
            <label><i class="fa fa-user"></i> Username</label>
             <input class="w3-input w3-border" type="number" name="username" required><br>
            <label><i class="fa fa-lock"></i> Password</label>
            <input class="w3-input w3-border" type="password" name="password" required><br>
            <label><i class="fa fa-lock"></i>Role</label>
            <input class="w3-input w3-border" type="text" name="role" required><br>
            <input type="hidden" name="action" value="register">
            <button class="w3-button w3-blue w3-margin-top" type="submit">Register</button>
        </form>
        </div>
    </div>
</body>
</html>

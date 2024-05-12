<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
        .form-container {
            width: 50%; /* Increased width */
            margin: 50px auto;
            padding: 20px;
            background-color: #f1f1f1;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container input[type=text], 
        .form-container input[type=email], 
        .form-container input[type=number] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-container button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        .form-container button:hover {
            background-color: #45a049;
        }
        /* Sidebar Styles */
        .sidebar {
            height: 100%;
            width: 300px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            transition: 0.5s;
            padding-top: 60px;
        }

        .sidebar a {
            padding: 10px 15px;
            text-decoration: none;
            font-size: 18px;
            color: #818181;
            display: block;
            transition: 0.3s;
        }

        .sidebar a:hover {
            color: #f1f1f1;
        }

        .main {
            margin-left: 300px; /* Same width as the sidebar */
            padding: 20px;
        }
    </style>
</head>
<body>

<!-- Main content -->
<div class="main">
    <div class="form-container">
        <h2>Update Employee</h2>
        
        <form action="Update" method="post">
            <label for="id">Employee ID:</label><br>
            <input type="number" id="id" name="id" value="<%= request.getParameter("id") %>" readonly><br><br>
                
            <label for="firstName">First Name:</label><br>
            <input type="text" id="firstName" name="firstName" value="<%= request.getParameter("firstName") %>"><br><br>

            <label for="lastName">Last Name:</label><br>
            <input type="text" id="lastName" name="lastName" value="<%= request.getParameter("lastName") %>"><br><br>

            <label for="email">Email:</label><br>
            <input type="email" id="email" name="email" value="<%= request.getParameter("email") %>"><br><br>

            <label for="department">Department:</label><br>
            <input type="text" id="department" name="department" value="<%= request.getParameter("department") %>"><br><br>

            <label for="salary">Salary:</label><br>
            <input type="number" id="salary" name="salary" value="<%= request.getParameter("salary") %>"><br><br>
            
            <label for="role">Role:</label><br>
            <input type="text" id="role" name="role" value="<%= request.getParameter("role") %>"><br><br>

            <button class="w3-button w3-blue" type="submit">Update Employee</button>
        </form>
    </div>
</div>

</body>
</html>

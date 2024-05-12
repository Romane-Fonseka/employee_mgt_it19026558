<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Attendance</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
    </style>
</head>
<body class="w3-light-grey">
<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <span class="w3-bar-item w3-right">Attendance Dashboard</span>
</div>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidebar">
    <br>
    <div class="w3-container">
        <h5>Daily Attendance</h5>
    </div>
    <hr>
    <div class="w3-container">
        <h5>Employee Management</h5>
    </div>
    <div class="w3-bar-block">
        <a href="dash2.html" class="w3-bar-item w3-button w3-padding"><i class="fa fa-user fa-fw"></i> Profile</a>
        <a href="attendance.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-calendar fa-fw"></i> Attendance</a>
        <a href="login.jsp" class="w3-bar-item w3-button w3-padding"><i class="fa fa-sign-out fa-fw"></i> Logout</a>

    </div>
</nav>

<!-- Page content -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-calendar"></i> Employee Attendance</b></h5>
    </header>

    <!-- Attendance Form -->
    <div class="w3-container">
        <h5>Log Time</h5>
        <form action="AttendanceServlet" method="post">
            <label for="employeeNo">Employee No:</label>
            <input class="w3-input w3-border" type="text" placeholder="Enter Employee No" id="employeeNo" name="employeeNo" required>
            
            <p>
                <input class="w3-radio" type="radio" name="attendance" onclick="setAttendanceType('login')" required>
                <label for="logIn">Log In</label>
            </p>
            <p>
                <input class="w3-radio" type="radio" name="attendance" onclick="setAttendanceType('logout')" required>
                <label for="logOut">Log Out</label>
            </p>

            <input type="hidden" name="action" value="markAttendance">
            <input type="hidden" name="attendanceType" id="attendanceType">
            
            <button class="w3-button w3-blue w3-margin-top">Submit</button>
        </form>
    </div>

</div>

<script>
    // Fetching the logged-in user's name from the session and updating the welcome message
    document.getElementById("loggedInUserName").innerText = '<%= session.getAttribute("loggedInUser") %>';

    // Function to set the attendance type
    function setAttendanceType(type) {
        document.getElementById('attendanceType').value = type;
    }
</script>

</body>
</html>